package com.school42.swingy.window;

import java.awt.event.*;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.school42.swingy.Main;
import com.school42.swingy.Utils;

public class Game extends AbstractWindow implements ActionListener {

	private static JButton _north = new JButton("North");
	private static JButton _south = new JButton("South");
	private static JButton _west = new JButton("West");
	private static JButton _east = new JButton("East");
	private JPanel _panel = (JPanel)getContentPane();
	private MainMenu _mainMenuWindow = null;
	private Boolean _refresh = false;

	public Game(MainMenu mainMenu) {
		super("Game", 1400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerScreen();
		_mainMenuWindow = mainMenu;

		_panel.add(_north);
		_panel.add(_south);
		_panel.add(_west);
		_panel.add(_east);

		_north.addActionListener(this);
		_south.addActionListener(this);
		_west.addActionListener(this);
		_east.addActionListener(this);

		Utils.addLabelPlayerInfo(_panel);

		Main.getCurrentHero().getNameLabel().setBounds(10, 10, 200, 30);
		Main.getCurrentHero().getClassNameLabel().setBounds(10, 40, 200, 30);
		Main.getCurrentHero().getLevelLabel().setBounds(10, 70, 200, 30);
		Main.getCurrentHero().getXpLabel().setBounds(10, 100, 200, 30);

		createSeparator(SwingConstants.HORIZONTAL, new Point(0, 130), 205);

		Main.getCurrentHero().getAttackLabel().setBounds(10, 140, 200, 30);
		Main.getCurrentHero().getDefenseLabel().setBounds(10, 170, 200, 30);
		Main.getCurrentHero().getHitPointLabel().setBounds(10, 200, 200, 30);

		createSeparator(SwingConstants.HORIZONTAL, new Point(0, 250), 205);

		Main.getCurrentHero().getWeaponLabel().setBounds(10, 280, 200, 30);
		Main.getCurrentHero().getArmorLabel().setBounds(10, 310, 200, 30);
		Main.getCurrentHero().getHelmLabel().setBounds(10, 330, 200, 30);

		createSeparator(SwingConstants.HORIZONTAL, new Point(0, 360), 205);

		Main.getCurrentHero().getPointLabel().setBounds(10, 390, 200, 30);

		createSeparator(SwingConstants.VERTICAL, new Point(200, 0), 500);

		_north.setBounds(210, 100, 200, 40);
		_south.setBounds(210, 180, 200, 40);
		_west.setBounds(210, 140, 100, 40);
		_east.setBounds(310, 140, 100, 40);

		setVisible(true);
	}

	public static void setBtn(boolean state) {
		_north.setEnabled(state);
		_south.setEnabled(state);
		_west.setEnabled(state);
		_east.setEnabled(state);
	}

	private void fight() {
		if (!Utils.checkIsEnemyPosition())
			return ;
		setBtn(false);
		new Fight(Main.getCurrentHero(), Main.getCurrentEnemy());
	}

	private void endGame() {
		setVisible(false);
		_mainMenuWindow.setVisible(true);
		_refresh = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _north) {
			if (!Utils.moveHero("north"))
				endGame();
			fight();
		} else if (e.getSource() == _south) {
			if (!Utils.moveHero("south"))
				endGame();
			fight();
		} else if (e.getSource() == _west) {
			if (!Utils.moveHero("west"))
				endGame();
			fight();
		} else if (e.getSource() == _east) {
			if (!Utils.moveHero("east"))
				endGame();
			fight();
		}
	}
	
}
