package com.school42.swingy.window;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.school42.swingy.Main;
import com.school42.swingy.Utils;

public class Game extends AbstractWindow implements ActionListener {

	static protected JButton _north = new JButton("North");
	static protected JButton _south = new JButton("South");
	static protected JButton _west = new JButton("West");
	static protected JButton _east = new JButton("East");
	protected JPanel _panel = (JPanel)getContentPane();
	private MainMenu _mainMenuWindow = null;
	static protected JTextArea _textArea = null;
	static protected JScrollPane _scrollPane = null;
	static private long line = 0;
	// for card
	protected JScrollPane _paneCard = new JScrollPane();
	protected DefaultTableModel _model = new DefaultTableModel();
	protected String [][] _map = new String [Main.getSizeMap()][Main.getSizeMap()];
	protected JTable _table = new JTable(_model);
	// end for card

	public Game(MainMenu mainMenu) {
		super("Game", 890, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerScreen();
		_mainMenuWindow = mainMenu;

		addTextArea();
		addBtn();
		addPlayerInfo();
		addCard();
		setListener();
		setBtnPosition();
		setPlayerInfoPosition();

		createSeparator(SwingConstants.VERTICAL, new Point(415, 0), 500);

		setVisible(true);
	}

	private void addCard() {
		_panel.add(_paneCard);
//		_table.setTableHeader(null);
		for (int i = 0; i < Main.getSizeMap(); i++) {
			_model.addColumn(i);
		}
		for (int i = 0; i < Main.getSizeMap(); i++) {
			_table.getColumnModel().getColumn(i).setPreferredWidth(100);
			_model.addRow(_map[i]);
		}
		_paneCard.setLayout(null);
		_table.setEnabled(false);
		_table.setRowHeight(100);
//		_paneCard.setViewportView(_table);
		_table.setBounds(0, 0, Main.getSizeMap() * 100, Main.getSizeMap() * 100);
		_paneCard.setBounds(430, 12, 450, 450);
	}

	static public void clear() {
		if (_scrollPane != null) {
			_scrollPane = new JScrollPane();
			_textArea = new JTextArea();
			line = 0;
		}
	}

	private void addTextArea() {
		_scrollPane = new JScrollPane();
		_textArea = new JTextArea();
		_panel.add(_scrollPane);
		_scrollPane.setViewportView(_textArea);
		_textArea.setEditable(false);
		_scrollPane.setBounds(212, 10, 200, 330);
	}

	static public void write(String msg) {
		if (_textArea != null) {
			if (line != 0)
				_textArea.append("\n");
			_textArea.append(msg);
			line++;
		}
	}

	private void setPlayerInfoPosition() {
		Main.getCurrentHero().getNameLabel().setBounds(10, 10, 200, 30);
		Main.getCurrentHero().getClassNameLabel().setBounds(10, 40, 200, 30);
		Main.getCurrentHero().getLevelLabel().setBounds(10, 70, 200, 30);
		Main.getCurrentHero().getXpLabel().setBounds(10, 100, 200, 30);

		createSeparator(SwingConstants.HORIZONTAL, new Point(0, 130), 205);

		Main.getCurrentHero().getAttackLabel().setBounds(10, 140, 200, 30);
		Main.getCurrentHero().getDefenseLabel().setBounds(10, 170, 200, 30);
		Main.getCurrentHero().getHitPointLabel().setBounds(10, 200, 200, 30);

		createSeparator(SwingConstants.HORIZONTAL, new Point(0, 230), 205);

		Main.getCurrentHero().getWeaponLabel().setBounds(10, 240, 200, 30);
		Main.getCurrentHero().getArmorLabel().setBounds(10, 270, 200, 30);
		Main.getCurrentHero().getHelmLabel().setBounds(10, 300, 200, 30);

		createSeparator(SwingConstants.HORIZONTAL, new Point(0, 330), 205);

		Main.getCurrentHero().getPointLabel().setBounds(10, 340, 200, 30);

		createSeparator(SwingConstants.VERTICAL, new Point(200, 0), 500);
	}

	private void setBtnPosition() {
		_north.setBounds(210, 350, 200, 40);
		_west.setBounds(210, 390, 100, 40);
		_east.setBounds(310, 390, 100, 40);
		_south.setBounds(210, 430, 200, 40);
	}

	private void setListener() {
		_north.addActionListener(this);
		_south.addActionListener(this);
		_west.addActionListener(this);
		_east.addActionListener(this);
	}

	private void addBtn() {
		_panel.add(_north);
		_panel.add(_south);
		_panel.add(_west);
		_panel.add(_east);
	}

	private void addPlayerInfo() {
		_panel.add(Main.getCurrentHero().getNameLabel());
		_panel.add(Main.getCurrentHero().getClassNameLabel());
		_panel.add(Main.getCurrentHero().getAttackLabel());
		_panel.add(Main.getCurrentHero().getDefenseLabel());
		_panel.add(Main.getCurrentHero().getHitPointLabel());
		_panel.add(Main.getCurrentHero().getXpLabel());
		_panel.add(Main.getCurrentHero().getPointLabel());
		_panel.add(Main.getCurrentHero().getWeaponLabel());
		_panel.add(Main.getCurrentHero().getArmorLabel());
		_panel.add(Main.getCurrentHero().getHelmLabel());
		_panel.add(Main.getCurrentHero().getLevelLabel());
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
//		setVisible(false);
//		_mainMenuWindow.setVisible(true);
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
