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

	static protected JPanel panel = null;
	private MainMenu _mainMenuWindow = null;
	static protected JTextArea _textArea = null;
	static protected JScrollPane _scrollPane = null;
	static private long line = 0;
	static public JScrollPane scrollPane = new JScrollPane();

	public Game(MainMenu mainMenu) {
		super("Game", 890, 500);
		panel = _panel;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerScreen();
		_mainMenuWindow = mainMenu;

		addTextArea();
		addBtn();
		addPlayerInfo();
		updateMap();
		setListener();
		setBtnPosition();
		setPlayerInfoPosition();

		createSeparator(SwingConstants.VERTICAL, new Point(415, 0), 500);

		setVisible(true);
	}

	protected void finalize() {
		panel = null;
		_mainMenuWindow = null;
		_textArea = null;
		_scrollPane = null;
		scrollPane = new JScrollPane();
		removeListener();
		line = 0;
		dispose();
	}

	static public void updateMap() {
		updateMap((int)Main.getCurrentHero().getPoint().getX(), (int)Main.getCurrentHero().getPoint().getY());
	}

	static public void updateMap(int x, int y) {
		if (panel == null)
			return ;
		JTable table = new JTable(Main.getSizeMap(), Main.getSizeMap());
		table.setRowHeight(10);
		table.setTableHeader(null);
		table.setEnabled(false);
		table.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		for (int i = 0; i < Main.getSizeMap(); i++)
			table.getColumnModel().getColumn(i).setPreferredWidth(10);
		table.setValueAt("X", y, x);
		scrollPane.setViewportView(table);
		panel.add(scrollPane);
		scrollPane.setBounds(430, 12, 450, 450);
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

	private void removeListener() {
		_north.removeActionListener(this);
		_south.removeActionListener(this);
		_west.removeActionListener(this);
		_east.removeActionListener(this);
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
		write("You win !");
		_mainMenuWindow.setVisible(true);
		finalize();
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
