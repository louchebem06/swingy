package main.java;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

import main.java.hero.*;		

public class Window implements ActionListener, ListSelectionListener {
	
	private JFrame frame;
	private JButton btnNewHero, 
					btnCreateHero,
					btnCancelCreateHero,
					btnLoadHero,
					btnNorth,
					btnEast,
					btnSouth,
					btnWest,
					btnFight,
					btnRun;
	private JTextField inputNameHero;
	private JComboBox<String> heroConboBox;
	private CaretListener validateInputNameHero;
	private JList<Hero> heroList;
	private JTextArea statHero;
	private Border border;
	private Map<String, ImageIcon> imgClass;
	private JLabel usingImgDescription, usingImgStat;
	private JLabel positionLabel;

	public Window(Vector<Hero> heros, Vector<String> classHero) {
		frame = new JFrame();
		btnNewHero = new JButton("New Hero");
		btnCreateHero = new JButton("Create");
		btnCancelCreateHero = new JButton("Cancel");
		btnLoadHero = new JButton("Load");
		inputNameHero = new JTextField();
		heroConboBox = new JComboBox<String>(classHero);
		validateInputNameHero = new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				JTextField text = (JTextField)e.getSource();
				String tmp = text.getText();
				if (tmp.length() == 0)
					btnCreateHero.setEnabled(false);
				else
					btnCreateHero.setEnabled(true);
			}
		};
		btnCreateHero.setEnabled(false);
		inputNameHero.addCaretListener(validateInputNameHero);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		heroList = new JList<Hero>(heros);
		heroList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		statHero = new JTextArea();
		positionLabel = new JLabel();
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

		// btnNorth.setEnabled(false);
		// btnSouth.setEnabled(false);
		// btnWest.setEnabled(false);
		// btnEast.setEnabled(false);

		btnFight.setEnabled(false);
		btnRun.setEnabled(false);

		imgClass = new HashMap<String, ImageIcon>();

		getAllImg(classHero);

		usingImgStat = new JLabel();
		usingImgDescription = new JLabel();
	}

	private void clearFrame(String title, int width, int height) {
		frame.getContentPane().removeAll();
 		frame.repaint();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setTitle(title);
		frame.setLayout(null);
	}

	public void mainMenu() {
		clearFrame("Main menu", 500, 500);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 250),
							(Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 250));
		
		JPanel panel = (JPanel)frame.getContentPane();
		JScrollPane scrollPane = new JScrollPane();
		JLabel herosLabel = new JLabel("HEROS");
		JLabel statLabel = new JLabel("STATS");

		panel.add(btnNewHero);
		scrollPane.setViewportView(heroList);
		panel.add(scrollPane);
		panel.add(herosLabel);
		panel.add(statHero);
		panel.add(statLabel);
		panel.add(btnLoadHero);
		panel.add(usingImgStat);

		btnNewHero.setBounds(0, 0, 100, 30);
		btnNewHero.addActionListener(this);

		btnLoadHero.setBounds(100, 0, 100, 30);
		btnLoadHero.addActionListener(this);

		herosLabel.setBounds(90, 22, 200, 50);
		scrollPane.setBounds(10, 60, 200, 400);

		statLabel.setBounds(320, 22, 200, 50);
		statHero.setBounds(220, 60, 270, 210);

		usingImgStat.setBounds(260, 280, 180, 180);

		heroList.addListSelectionListener(this);
	}

	private ImageIcon getImg(String name, int width, int height) {
		ImageIcon warlock = new ImageIcon(getClass().getClassLoader().getResource(name));
		Image img = warlock.getImage();
		Image newimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return (new ImageIcon(newimg));
	}

	private void getAllImg(Vector<String> classHero) {
		for (String classNameHero : classHero) {
			imgClass.put(classNameHero,
						getImg(classNameHero.toLowerCase() + ".jpg",
								200,
								200));
		}
	}

	private void createHero() {
		clearFrame("Create Hero", 400, 400);

		JLabel nameLabel = new JLabel("Name:");
		JLabel classNameLabel = new JLabel("Class:");
		JPanel panel = (JPanel)frame.getContentPane();
		String item = heroConboBox.getSelectedItem().toString();
		
		usingImgDescription.setIcon(imgClass.get(item));

		panel.add(btnCreateHero);
		panel.add(nameLabel);
		panel.add(inputNameHero);
		panel.add(heroConboBox);
		panel.add(classNameLabel);
		panel.add(btnCancelCreateHero);
		panel.add(usingImgDescription);

		nameLabel.setBounds(10, 30, 80, 30);
		inputNameHero.setBounds(90, 30, 300, 30);

		classNameLabel.setBounds(10, 60, 80, 30);
		heroConboBox.setBounds(90, 60, 300, 30);

		btnCreateHero.setBounds(75, 330, 100, 30);
		btnCancelCreateHero.setBounds(215, 330, 100, 30);

		usingImgDescription.setBounds(100, 105, 200, 200);
	
		btnCreateHero.addActionListener(this);
		btnCancelCreateHero.addActionListener(this);
		heroConboBox.addActionListener(this);
	}

	private void cardGame() {
		clearFrame("Game", 500, 440);

		JPanel panel = (JPanel)frame.getContentPane();
		JScrollPane scrollPane = new JScrollPane();

		JLabel nameLabel = new JLabel("Name: " + Game.currentHero.getName());
		JLabel classNameLabel = new JLabel("Class: " + Game.currentHero.getClassName());
		JLabel attackLabel = new JLabel("Attack: " + Game.currentHero.getAttack());
		JLabel defenseLabel = new JLabel("Defense: " + Game.currentHero.getDefense());
		JLabel hpLabel = new JLabel("HitPoint: " + Game.currentHero.getHitPoint());
		JLabel weaponLabel = new JLabel("Weapon: not equiped");
		JLabel armorLabel = new JLabel("Armor: not equiped");
		JLabel helmLabel = new JLabel("Helm: not equiped");
		JLabel lvlLabel = new JLabel("Level: " + Game.currentHero.getLevel());
		JLabel xpLabel = new JLabel("XP: " + Game.currentHero.getXp());
		positionLabel.setText("Current position: (" + Game.position.getX() + "," + Game.position.getY() + ")");
		JLabel imgPlayer = new JLabel();
		JLabel msgGame = new JLabel("MSG HERE");
		imgPlayer.setIcon(imgClass.get(Game.currentHero.getClassName()));

		Artefacs weapon = Game.currentHero.getWeapon();
		Artefacs armor = Game.currentHero.getArmor();
		Artefacs helm = Game.currentHero.getHelm();

		if (weapon != null)
			weaponLabel.setText("Weapon: " + weapon);
		if (armor != null)
			armorLabel.setText("Armor: " + armor);
		if (helm != null)
			helmLabel.setText("Helm: " + helm);

		panel.add(scrollPane);

		panel.add(btnNorth);
		panel.add(btnEast);
		panel.add(btnSouth);
		panel.add(btnWest);

		panel.add(btnFight);
		panel.add(btnRun);
	
		panel.add(nameLabel);
		panel.add(classNameLabel);
		panel.add(attackLabel);
		panel.add(defenseLabel);
		panel.add(hpLabel);
		panel.add(weaponLabel);
		panel.add(helmLabel);
		panel.add(armorLabel);
		panel.add(lvlLabel);
		panel.add(xpLabel);
		panel.add(positionLabel);
		panel.add(imgPlayer);

		panel.add(msgGame);

		nameLabel.setBounds(10, 10, 200, 30);
		classNameLabel.setBounds(10, 30, 200, 30);
		attackLabel.setBounds(10, 50, 200, 30);
		defenseLabel.setBounds(10, 70, 200, 30);
		hpLabel.setBounds(10, 90, 200, 30);
		weaponLabel.setBounds(10, 110, 200, 30);
		armorLabel.setBounds(10, 130, 200, 30);
		helmLabel.setBounds(10, 150, 200, 30);
		lvlLabel.setBounds(10, 170, 200, 30);
		xpLabel.setBounds(10, 190, 200, 30);
		positionLabel.setBounds(10, 210, 200, 30);
		imgPlayer.setBounds(10, 240, 170, 160);

		scrollPane.setBounds(190, 10, 300, 270);

		msgGame.setBounds(190, 275, 300, 30);

		btnNorth.setBounds(230, 320, 100, 30);
		btnSouth.setBounds(230, 380, 100, 30);
		btnWest.setBounds(180, 350, 100, 30);
		btnEast.setBounds(280, 350, 100, 30);

		btnFight.setBounds(390, 320, 100, 30);
		btnRun.setBounds(390, 350, 100, 30);

		btnNorth.addActionListener(this);
		btnSouth.addActionListener(this);
		btnWest.addActionListener(this);
		btnEast.addActionListener(this);

		btnFight.addActionListener(this);
		btnRun.addActionListener(this);
	}

	private void updatePosition(int x, int y, int sizeMap) {
		if (y > 0 && y < sizeMap)
			Game.position.setY(y);
		if (x > 0 && x < sizeMap)
			Game.position.setX(x);
		positionLabel.setText("Current position: (" + x + "," + y + ")");
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
			if (!Utils.addHero(name, className))
				return ;
			inputNameHero.setText("");
			mainMenu();
		} else if (e.getSource() == btnLoadHero) {
			int sizeMap = Game.currentHero.getSizeMap();
			Game.position.setX(sizeMap / 2);
			Game.position.setY(sizeMap / 2);
			cardGame();
		} else if (e.getSource() == heroConboBox) {
			String item = heroConboBox.getSelectedItem().toString();
			usingImgDescription.setIcon(imgClass.get(item));
		} else if (e.getSource() == btnNorth) {
			updatePosition(Game.position.getX(), Game.position.getY() - 1, Game.currentHero.getSizeMap());
		} else if (e.getSource() == btnSouth) {
			updatePosition(Game.position.getX(), Game.position.getY() + 1, Game.currentHero.getSizeMap());
		} else if (e.getSource() == btnWest) {
			updatePosition(Game.position.getX() - 1, Game.position.getY(), Game.currentHero.getSizeMap());
		} else if (e.getSource() == btnEast) {
			updatePosition(Game.position.getX() + 1, Game.position.getY(), Game.currentHero.getSizeMap());
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
			Game.currentHero = hero;
			usingImgStat.setIcon(imgClass.get(hero.getClassName()));
		}
	}

}
