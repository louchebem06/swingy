package com.school42.swingy.game;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;		

import com.school42.swingy.hero.*;

public class Game implements ActionListener, ListSelectionListener {
	
	private JFrame frame;
	private JButton btnNewHero, 
					btnCreateHero,
					btnCancelCreateHero,
					btnCli,
					btnLoadHero,
					btnNorth,
					btnEast,
					btnSouth,
					btnWest,
					btnFight,
					btnRun;
	private JTextField inputNameHero;
	private Vector<String> classHero;
	private JComboBox<String> heroConboBox;
	private Vector<Hero> heros;
	private CaretListener validateInputNameHero;
	private String mode, menu;
	private JList<Hero> heroList;
	private JTextArea statHero;
	private Border border;
	private Hero currentHero;

	public Game() {
		frame = new JFrame();;
		btnNewHero = new JButton("New Hero");
		btnCreateHero = new JButton("Create");
		btnCancelCreateHero = new JButton("Cancel");
		btnLoadHero = new JButton("Load");
		btnCli = new JButton("CLI");
		inputNameHero = new JTextField();
		classHero = getClassHero();
		heroConboBox = new JComboBox<String>(classHero);
		heros = new Vector<Hero>();
		validateInputNameHero = new CaretListener() {
			public void caretUpdate(javax.swing.event.CaretEvent e) {
				JTextField text = (JTextField)e.getSource();
				String tmp = text.getText();
				if (tmp.length() == 0)
					btnCreateHero.setEnabled(false);
				else
					btnCreateHero.setEnabled(true);
			}
		};

		menu = "main";
		btnCreateHero.setEnabled(false);
		inputNameHero.addCaretListener(validateInputNameHero);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		heroList = new JList<Hero>(heros);
		heroList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		statHero = new JTextArea();
		border = BorderFactory.createLineBorder(Color.BLACK);
    	statHero.setBorder(border);
		statHero.setEditable(false);
		btnLoadHero.setEnabled(false);

		btnNorth = new JButton("North");
		btnEast = new JButton("East");
		btnSouth = new JButton("South");
		btnWest = new JButton("West");
		btnFight = new JButton("Fight");
		btnRun = new JButton("Run");
	}

	private Vector<String> getClassHero() {
		Vector<String> classHeros = new Vector<String>();
		File f = new File("./com/school42/swingy/hero/heros");
        String[] names = f.list();
        for (String name : names) {
			String ext = name.substring(name.length() - 5);
            if (!ext.equals(".java"))
				continue ;
			String className = name.substring(0, name.length() - 5);
			classHeros.add(className);
        }
		return (classHeros);
	}

	private void checkArg(String av[]) throws Exception {
		int len = av.length;
		if (len < 1)
			throw new Exception("Not enough argument");
		else if (len > 1)
			throw new Exception("Too much argument");
		String arg = av[0];
		if (arg.equals("gui")) {
			mode = "gui";
			mainMenu();
		}
		else if (arg.equals("cli")) {
			mode = "cli";
			mainMenuCli();
		}
		else
			throw new Exception(arg + " is not valid");
	}

	private void clearFrame(String title, int width, int height) {
		frame.getContentPane().removeAll();
 		frame.repaint();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setTitle(title);
		frame.setLayout(null);
	}

	private void changeMode() {
		mode = (mode.equals("cli")) ? "gui" : "cli";
		if (mode.equals("cli")) {
			System.out.println("Cli mode activate");
			frame.setVisible(false);
		}
	}

	private void switchMode(String screen) {
		if (screen.equals("main")) {
			changeMode();
			menu = screen;
			if (mode.equals("gui"))
				mainMenu();
			else
				mainMenuCli();
		}
	}

	private void mainMenu() {
		menu = "main";
		clearFrame("Main menu", 500, 500);
		
		JPanel panel = (JPanel)frame.getContentPane();
		JScrollPane scrollPane = new JScrollPane();
		JLabel herosLabel = new JLabel("HEROS");
		JLabel statLabel = new JLabel("STATS");

		panel.add(btnNewHero);
		panel.add(btnCli);
		scrollPane.setViewportView(heroList);
		panel.add(scrollPane);
		panel.add(herosLabel);
		panel.add(statHero);
		panel.add(statLabel);
		panel.add(btnLoadHero);

		btnNewHero.setBounds(0, 0, 100, 30);
		btnNewHero.addActionListener(this);

		btnCli.setBounds(400, 0, 100, 30);
		btnCli.addActionListener(this);

		btnLoadHero.setBounds(100, 0, 100, 30);
		btnLoadHero.addActionListener(this);

		herosLabel.setBounds(90, 22, 200, 50);
		scrollPane.setBounds(10, 60, 200, 400);

		statLabel.setBounds(320, 22, 200, 50);
		statHero.setBounds(220, 60, 270, 400);

		heroList.addListSelectionListener(this);
	}

	private void mainMenuCli() {
		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			if (!menu.equals("main")) {
				System.exit(1);
			}
			System.out.println("\n== MAIN MENU ==");
			System.out.println("ACTION :");
			System.out.println("\t- create");
			System.out.println("\t- list [hero or class]");
			System.out.println("\t- info [heroId or class]");
			System.out.println("\t- load <heroId>");
			System.out.println("\t- gui");
			System.out.println("\t- exit");
			System.out.print("\n\n-> ");
			try {
				String value = reader.readLine();
				String split[] = value.split(" ");
				String option = (split.length >= 1) ? split[0] : "";
				String arg = (split.length >= 2) ? split[1] : "";
				switch (option) {
					case "create":
						System.out.println("CreateCli WIP");
						break ;
					case "list":
						if (arg.equals("hero")) {
							if (heros.size() == 0) {
								System.out.println("No hero found");
								continue ;
							}
							for (int i = 0; i < heros.size(); i++) {
								Hero hero = heros.elementAt(i);
								System.out.println("ID: " + i);
								System.out.println(hero);
							}
						} else if (arg.equals("class")) {
								for (int i = 0; i < classHero.size(); i++) {
									String className = classHero.elementAt(i);
									System.out.println(className);
								}
						} else
							System.out.println(arg + " argument not valid");
						break ;
					case "info":
						int heroId;
						try {
							heroId = Integer.parseInt(arg);
						} catch (Exception e) {
							System.out.println("heroId is invalid");
							continue ;
						}
						if (heroId >= heros.size()) {
							System.out.println("ID invalid");
							continue ;
						}
						Hero hero = heros.elementAt(heroId);
						System.out.println("Name: " + hero.getName());
						System.out.println("Class: " + hero.getClassName());
						System.out.println("Level: " + hero.getLevel());
						System.out.println("XP: " + hero.getXp());
						System.out.println("Attack: " + hero.getAttack());
						System.out.println("Defense: " + hero.getDefense());
						System.out.println("HitPoints: " + hero.getHitPoint());
						System.out.println("Armor: " + hero.getArmor());
						System.out.println("Helm: " + hero.getHelm());
						System.out.println("Weapon: " + hero.getWeapon());
						break ;
					case "load":
						System.out.println("Load WIP");
						break ;
					case "gui":
						switchMode("main");
						return ;
					case "exit":
						System.exit(0);
						break;
				}
				System.out.println("'" + option + "'" + " option not valid");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				System.exit(1);
			}
		}
	}

	private void createHero() {
		menu = "createHero";
		clearFrame("Create Hero", 400, 200);

		JLabel nameLabel = new JLabel("Name:");
		JLabel classNameLabel = new JLabel("Class:");
		JPanel panel = (JPanel)frame.getContentPane();

		panel.add(btnCreateHero);
		panel.add(nameLabel);
		panel.add(inputNameHero);
		panel.add(heroConboBox);
		panel.add(classNameLabel);
		panel.add(btnCancelCreateHero);
		panel.add(btnCli);

		nameLabel.setBounds(10, 30, 80, 30);
		inputNameHero.setBounds(90, 30, 300, 30);

		classNameLabel.setBounds(10, 60, 80, 30);
		heroConboBox.setBounds(90, 60, 300, 30);

		btnCreateHero.setBounds(75, 130, 100, 30);
		btnCancelCreateHero.setBounds(215, 130, 100, 30);
	
		btnCreateHero.addActionListener(this);
		btnCancelCreateHero.addActionListener(this);

		btnCli.setBounds(300, 0, 100, 30);
		btnCli.addActionListener(this);
	}

	private void cardGame() {
		menu = "game";
		clearFrame("Game", 520, 750);

		JPanel panel = (JPanel)frame.getContentPane();
		JScrollPane scrollPane = new JScrollPane();

		panel.add(scrollPane);
		panel.add(btnNorth);
		panel.add(btnEast);
		panel.add(btnSouth);
		panel.add(btnWest);
		panel.add(btnFight);
		panel.add(btnRun);

		// scrollPane.setViewportView(ITENM);
		// int sizeMap = currentHero.getSizeMap();

		scrollPane.setBounds(10, 10, 500, 500);

		btnNorth.setBounds(70, 550, 100, 30);
		btnSouth.setBounds(70, 650, 100, 30);
		btnWest.setBounds(20, 600, 100, 30);
		btnEast.setBounds(120, 600, 100, 30);

		btnFight.setBounds(360, 570, 100, 30);
		btnRun.setBounds(300, 630, 100, 30);

		btnNorth.setEnabled(false);
		btnSouth.setEnabled(false);
		btnWest.setEnabled(false);
		btnEast.setEnabled(false);;

		btnFight.setEnabled(false);
		btnRun.setEnabled(false);
	}

	private boolean addHero(String heroName, String className) {
		if (heroName.length() == 0)
			return (false);
		for (String heroClass : classHero) {
			if (heroClass == className) {
				Hero hero = HeroFactory.newHero(className, heroName, 0, 0);
				heros.add(hero);
				if (mode.equals("cli"))
					System.out.println("Create Hero: " + hero);
				return (true);
			}
		}
		return (false);
	}
	
	private void connectToBdd() {
	    try
		{
			//étape 1: charger la classe de driver
			Class.forName("com.mysql.jdbc.Driver");
			//étape 2: créer l'objet de connexion
			Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/swingy", "swingy", "swingy");
			//étape 3: créer l'objet statement 
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM heros");
			//étape 4: exécuter la requête
			while(res.next())
				System.out.println(res.getInt(1)+"  "+res.getString(2)
				+"  "+res.getString(3));
			//étape 5: fermez l'objet de connexion
			conn.close();
		}
		catch(Exception e){ 
			System.out.println(e);
		}
	}

	public static void main(String av[]) {
		Game main = new Game();
		try {
			main.connectToBdd();
			main.checkArg(av);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelCreateHero)
			mainMenu();
		else if (e.getSource() == btnNewHero)
			createHero();
		else if (e.getSource() == btnCreateHero) {
			String name = inputNameHero.getText();
			String className = (String)heroConboBox.getSelectedItem();
			if (!addHero(name, className))
				return ;
			inputNameHero.setText("");
			mainMenu();
		} else if (e.getSource() == btnCli) {
			switchMode(menu);
		} else if (e.getSource() == btnLoadHero) {
			cardGame();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == heroList) {
			Hero hero = heroList.getSelectedValue();
			statHero.selectAll();
    		statHero.replaceSelection("");
			statHero.append(hero.getStat());
			btnLoadHero.setEnabled(true);
			currentHero = hero;
		}
	}

}
