package com.school42.swingy.game;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import com.school42.swingy.hero.*;

public class Game implements ActionListener {
	
	private JFrame frame;
	private JButton btnNewHero, 
					btnCreateHero,
					btnCancelCreateHero,
					btnCli;
	private JTextField inputNameHero;
	private Vector<String> classHero;
	private JComboBox heroConboBox;
	private Vector<Hero> heros;
	private CaretListener validateInputNameHero;
	private String mode;
	private String menu;

	public Game() {
		frame = new JFrame();;
		btnNewHero = new JButton("New Hero");
		btnCreateHero = new JButton("Create");
		btnCancelCreateHero = new JButton("Cancel");
		btnCli = new JButton("CLI");
		inputNameHero = new JTextField();
		classHero = getClassHero();
		heroConboBox = new JComboBox(classHero);
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
		panel.add(btnNewHero);
		panel.add(btnCli);

		btnNewHero.setBounds(0, 0, 100, 30);
		btnNewHero.addActionListener(this);

		btnCli.setBounds(400, 0, 100, 30);
		btnCli.addActionListener(this);
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
					default:
						System.out.println("'" + option + "'" + " option not valid");
				}
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

	private boolean addHero(String heroName, String className) {
		if (heroName.length() == 0)
			return (false);
		for (String heroClass : classHero) {
			if (heroClass == className) {
				Hero hero = HeroFactory.newHero(className, heroName);
				heros.add(hero);
				if (mode.equals("cli"))
					System.out.println("Create Hero: " + hero);
				return (true);
			}
		}
		return (false);
	}

	public static void main(String av[]) {
		Game main = new Game();
		try {
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
		}
	}

}
