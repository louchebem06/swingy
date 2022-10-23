package com.school42.swingy;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

import com.school42.swingy.hero.*;
import com.school42.swingy.artefac.*;

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
	private JLabel usingImgHero;
	private JLabel msgGame;
	private static final DecimalFormat df = new DecimalFormat("0.00");

	private boolean isFirstLaunch = true;

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

		btnFight.setEnabled(false);
		btnRun.setEnabled(false);

		usingImgHero = new JLabel();

		msgGame = new JLabel();
	}

	private void clearFrame(String title, int width, int height) {
		frame.getContentPane().removeAll();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setTitle(title);
		frame.setLayout(null);
		btnNorth.removeActionListener(this);
		btnNewHero.removeActionListener(this);
		btnCreateHero.removeActionListener(this);
		btnCancelCreateHero.removeActionListener(this);
		btnLoadHero.removeActionListener(this);
		btnNorth.removeActionListener(this);
		btnEast.removeActionListener(this);
		btnSouth.removeActionListener(this);
		btnWest.removeActionListener(this);
		btnFight.removeActionListener(this);
		btnRun.removeActionListener(this);
	}

	private void centerFrame(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}

	public void mainMenu() {
		clearFrame("Main menu", 500, 500);
		if (isFirstLaunch) {
			centerFrame(frame);
			isFirstLaunch = false;
		}
		
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
		panel.add(usingImgHero);

		btnNewHero.setBounds(0, 0, 100, 30);
		btnNewHero.addActionListener(this);

		btnLoadHero.setBounds(100, 0, 100, 30);
		btnLoadHero.addActionListener(this);

		herosLabel.setBounds(90, 22, 200, 50);
		scrollPane.setBounds(10, 60, 200, 400);

		statLabel.setBounds(320, 22, 200, 50);
		statHero.setBounds(220, 60, 270, 210);

		usingImgHero.setIcon(new ImageIcon());
		usingImgHero.setBounds(280, 280, 180, 180);

		heroList.addListSelectionListener(this);
	}

	private void createHero() {
		clearFrame("Create Hero", 400, 400);

		JLabel nameLabel = new JLabel("Name:");
		JLabel classNameLabel = new JLabel("Class:");
		JPanel panel = (JPanel)frame.getContentPane();
		String item = heroConboBox.getSelectedItem().toString();

		Hero heroTmp = HeroFactory.newHero(item, "tmp", 0, 0);

		usingImgHero.setIcon(heroTmp.getIcon(200));

		panel.add(btnCreateHero);
		panel.add(nameLabel);
		panel.add(inputNameHero);
		panel.add(heroConboBox);
		panel.add(classNameLabel);
		panel.add(btnCancelCreateHero);
		panel.add(usingImgHero);

		nameLabel.setBounds(10, 30, 80, 30);
		inputNameHero.setBounds(90, 30, 300, 30);

		classNameLabel.setBounds(10, 60, 80, 30);
		heroConboBox.setBounds(90, 60, 300, 30);

		btnCreateHero.setBounds(75, 330, 100, 30);
		btnCancelCreateHero.setBounds(215, 330, 100, 30);

		usingImgHero.setBounds(100, 105, 200, 200);
	
		btnCreateHero.addActionListener(this);
		btnCancelCreateHero.addActionListener(this);
		heroConboBox.addActionListener(this);
	}

	private void cardGame() {
		clearFrame("Game", 500, 440);

		JPanel panel = (JPanel)frame.getContentPane();
		JScrollPane scrollPane = new JScrollPane();

		JLabel imgPlayer = new JLabel();
		msgGame.setText("Welcome to Swingy!");
		imgPlayer.setIcon(Main.currentHero.getIcon(150));

		panel.add(scrollPane);

		panel.add(btnNorth);
		panel.add(btnEast);
		panel.add(btnSouth);
		panel.add(btnWest);

		panel.add(btnFight);
		panel.add(btnRun);
	
		panel.add(Main.currentHero.getNameLabel());
		panel.add(Main.currentHero.getClassNameLabel());
		panel.add(Main.currentHero.getAttackLabel());
		panel.add(Main.currentHero.getDefenseLabel());
		panel.add(Main.currentHero.getHitPointLabel());
		panel.add(Main.currentHero.getWeaponLabel());
		panel.add(Main.currentHero.getHelmLabel());
		panel.add(Main.currentHero.getArmorLabel());
		panel.add(Main.currentHero.getLevelLabel());
		panel.add(Main.currentHero.getXpLabel());
		panel.add(Main.currentHero.getPointLabel());
		panel.add(imgPlayer);

		panel.add(msgGame);

		Main.currentHero.getNameLabel().setBounds(10, 10, 200, 30);
		Main.currentHero.getClassNameLabel().setBounds(10, 30, 200, 30);
		Main.currentHero.getAttackLabel().setBounds(10, 50, 200, 30);
		Main.currentHero.getDefenseLabel().setBounds(10, 70, 200, 30);
		Main.currentHero.getHitPointLabel().setBounds(10, 90, 200, 30);
		Main.currentHero.getWeaponLabel().setBounds(10, 110, 200, 30);
		Main.currentHero.getArmorLabel().setBounds(10, 130, 200, 30);
		Main.currentHero.getHelmLabel().setBounds(10, 150, 200, 30);
		Main.currentHero.getLevelLabel().setBounds(10, 170, 200, 30);
		Main.currentHero.getXpLabel().setBounds(10, 190, 200, 30);
		Main.currentHero.getPointLabel().setBounds(10, 210, 200, 30);
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

		Main.enemyPosition = MapGame.generateEnemys(Main.currentHero.getSizeMap());
	}

	private void updatePosition(int x, int y, int sizeMap) {
		int newX;
		int newY;

		if (y >= 0 && y < sizeMap)
			newY = y;
		else
			newY = (int)Main.currentHero.getPoint().getY();
		if (x >= 0 && x < sizeMap)
			newX = x;
		else
			newX = (int)Main.currentHero.getPoint().getX();
		Main.currentHero.setPoint(newX, newY);
		msgGame.setText("Your move to (" + (int)(Main.currentHero.getPoint().getX()) + "," + (int)(Main.currentHero.getPoint().getY()) + ")");
	}

	private void checkIsEnemyPosition() {
		int i = 0;

		for (Point cordonate : Main.enemyPosition) {
			if (cordonate.equals(Main.currentHero.getPoint())) {
				btnNorth.setEnabled(false);
				btnSouth.setEnabled(false);
				btnWest.setEnabled(false);
				btnEast.setEnabled(false);

				btnFight.setEnabled(true);
				btnRun.setEnabled(true);

				Main.currentEnemy = HeroFactory.randomHero(Main.currentHero.getXp());
				msgGame.setText(
					Main.currentEnemy.getName()
					+ " lvl " + Main.currentEnemy.getLevel()
					+ " type " + Main.currentEnemy.getClassName()
					+ " wants to fight!"
				);
				Main.enemyPosition.remove(i);
				if (Main.enemyPosition.size() == 0)
					Main.enemyPosition = MapGame.generateEnemys(
											Main.currentHero.getSizeMap());
				break ;
			}
			i++;
		}
	}

	private void createItemFrame(final Artefacs item) {
		JFrame itemFrame = new JFrame("Drop item!");
		JPanel panel = (JPanel)itemFrame.getContentPane();
		JLabel msgFrame = new JLabel();
		JButton btnEquip = new JButton("Equip");
		JLabel actualItem = new JLabel();
		JLabel newItem = new JLabel();
		JLabel imgEnemy = new JLabel();
		
		itemFrame.setLayout(null);
		itemFrame.setVisible(true);
		itemFrame.setSize(600, 200);
		itemFrame.setResizable(false);

		centerFrame(itemFrame);

		panel.add(msgFrame);
		panel.add(btnEquip);
		panel.add(actualItem);
		panel.add(newItem);
		panel.add(imgEnemy);

		imgEnemy.setIcon(Main.currentEnemy.getIcon(100));

		String typeItem = item.getType();

		msgFrame.setText(Main.currentEnemy.getName() + " lvl " + Main.currentEnemy.getLevel() + " is dead dying he dropped " + typeItem);

		switch (typeItem) {
			case "weapon":
				actualItem.setText("Actual " + Main.currentHero.getWeaponLabel().getText());
				break;
			case "armor":
				actualItem.setText("Actual " + Main.currentHero.getArmorLabel().getText());
				break;
			case "helm":
				actualItem.setText("Actual " + Main.currentHero.getHelmLabel().getText());
				break;
		}

		newItem.setText("New item: " + item.getName() + " (" + df.format(item.getValue()) + ")");

		msgFrame.setBounds(10, 10, 390, 30);
		actualItem.setBounds(10, 40, 390, 30);
		newItem.setBounds(10, 70, 390, 30);
		btnEquip.setBounds(250, 130, 100, 30);
		imgEnemy.setBounds(490, 10, 100, 100);

		btnEquip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
        		JFrame frame = (JFrame) SwingUtilities.getRoot(component);
				frame.dispose();
				Main.currentHero.setArtefac(item);
			}
		});
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
			int sizeMap = Main.currentHero.getSizeMap();
			Main.currentHero.setPoint(sizeMap / 2, sizeMap / 2);
			cardGame();
		} else if (e.getSource() == heroConboBox) {
			String item = heroConboBox.getSelectedItem().toString();
			Hero heroTmp = HeroFactory.newHero(item, "tmp", 0, 0);
			usingImgHero.setIcon(heroTmp.getIcon(200));
		} else if (e.getSource() == btnNorth) {
			updatePosition(
				(int)Main.currentHero.getPoint().getX(),
				(int)Main.currentHero.getPoint().getY() - 1,
				Main.currentHero.getSizeMap()
			);
			checkIsEnemyPosition();
		} else if (e.getSource() == btnSouth) {
			updatePosition(
				(int)Main.currentHero.getPoint().getX(),
				(int)Main.currentHero.getPoint().getY() + 1,
				Main.currentHero.getSizeMap()
			);
			checkIsEnemyPosition();
		} else if (e.getSource() == btnWest) {
			updatePosition(
				(int)Main.currentHero.getPoint().getX() - 1,
				(int)Main.currentHero.getPoint().getY(),
				Main.currentHero.getSizeMap()
			);
			checkIsEnemyPosition();
		} else if (e.getSource() == btnEast) {
			updatePosition(
				(int)Main.currentHero.getPoint().getX() + 1,
				(int)Main.currentHero.getPoint().getY(),
				Main.currentHero.getSizeMap()
			);
			checkIsEnemyPosition();
		} else if (e.getSource() == btnRun) {
			if (Simulator.run()) {
				btnRun.setEnabled(false);
				btnFight.setEnabled(false);

				btnNorth.setEnabled(true);
				btnSouth.setEnabled(true);
				btnWest.setEnabled(true);
				btnEast.setEnabled(true);

				msgGame.setText("Run is success !");
			} else {
				msgGame.setText("Run is Fail !");
				btnRun.setEnabled(false);
			}
		} else if (e.getSource() == btnFight) {
			btnRun.setEnabled(false);
			btnFight.setEnabled(false);

			if (Simulator.figth(Main.currentHero, Main.currentEnemy)) {
				double xpWin = (Math.pow(Main.currentHero.getLevel(), 5)
								* Math.pow(Main.currentEnemy.getLevel(), 15));
				if (xpWin <= 100)
					xpWin += 100;
				msgGame.setText(
					"You won your fight ✅ + "
					+ df.format(xpWin) + "xp"
				);

				Main.currentHero.addXp(xpWin);

				btnNorth.setEnabled(true);
				btnSouth.setEnabled(true);
				btnWest.setEnabled(true);
				btnEast.setEnabled(true);

				Artefacs dropArmor = Main.currentEnemy.getArmor();
				Artefacs dropWeapon = Main.currentEnemy.getWeapon();
				Artefacs dropHelm = Main.currentEnemy.getHelm();

				if (dropArmor != null)
					createItemFrame(dropArmor);
				if (dropWeapon != null)
					createItemFrame(dropWeapon);
				if (dropHelm != null)
					createItemFrame(dropHelm);
			} else {
				msgGame.setText("You lost your fight ❌ respawn middle !");
				Main.enemyPosition = MapGame.generateEnemys(Main.currentHero.getSizeMap());
				Main.currentHero.setPoint(Main.currentHero.getSizeMap() / 2, Main.currentHero.getSizeMap() / 2);
				btnNorth.setEnabled(true);
				btnSouth.setEnabled(true);
				btnWest.setEnabled(true);
				btnEast.setEnabled(true);
				btnFight.setEnabled(false);
				btnRun.setEnabled(false);
			}
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
			Main.currentHero = hero;
			usingImgHero.setIcon(hero.getIcon(150));
		}
	}

}
