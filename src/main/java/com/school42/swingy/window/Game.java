package com.school42.swingy.window;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.school42.swingy.Main;
import com.school42.swingy.Utils;

/*
 * Bug after add player
 */

public class Game extends AbstractWindow implements ActionListener {

	private JButton _item = new JButton("Item");
	private JButton _stat = new JButton("Stat");
	private JButton _card = new JButton("Map");
	private JButton _event = new JButton("Event");
	private static JButton _north = new JButton("North");
	private static JButton _south = new JButton("South");
	private static JButton _west = new JButton("West");
	private static JButton _east = new JButton("East");
	private JPanel _panel = (JPanel)getContentPane();
	private JSeparator _separator = new JSeparator();
	private AbstractWidgetWindow _itemWindow = null;
	private AbstractWidgetWindow _statWindow = null;
	private AbstractWidgetWindow _cardWindow = null;
	private AbstractWidgetWindow _eventWindow = null;

	public Game() {
		super("Game", 200, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerScreenDown();
		_itemWindow = new Item(getPoint(), getDimension());
		_statWindow = new Stat(getPoint(), getDimension());
		_cardWindow = new Card(getPoint(), getDimension());
		_eventWindow = new Event(getPoint(), getDimension());

		_panel.add(_item);
		_panel.add(_stat);
		_panel.add(_card);
		_panel.add(_event);
		_panel.add(_north);
		_panel.add(_south);
		_panel.add(_west);
		_panel.add(_east);
		_panel.add(_separator);

		_item.setBounds(0, 0, 100, 40);
		_stat.setBounds(100, 0, 100, 40);
		_event.setBounds(0, 40, 100, 40);
		_card.setBounds(100, 40, 100, 40);

		_separator.setOrientation(SwingConstants.HORIZONTAL);
		_separator.setBounds(0, 85, 200, 10);

		_north.setBounds(0, 100, 200, 40);
		_south.setBounds(0, 180, 200, 40);
		_west.setBounds(0, 140, 100, 40);
		_east.setBounds(100, 140, 100, 40);

		_item.addActionListener(this);
		_stat.addActionListener(this);
		_card.addActionListener(this);
		_event.addActionListener(this);
		_north.addActionListener(this);
		_south.addActionListener(this);
		_west.addActionListener(this);
		_east.addActionListener(this);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _item) {
			_itemWindow.toggleVisibility();
		} else if (e.getSource() == _stat) {
			_statWindow.toggleVisibility();
		} else if (e.getSource() == _card) {
			_cardWindow.toggleVisibility();
		} else if (e.getSource() == _event) {
			_eventWindow.toggleVisibility();
		} else if (e.getSource() == _north) {
			Utils.moveHero("north");
			fight();
		} else if (e.getSource() == _south) {
			Utils.moveHero("south");
			fight();
		} else if (e.getSource() == _west) {
			Utils.moveHero("west");
			fight();
		} else if (e.getSource() == _east) {
			Utils.moveHero("east");
			fight();
		}
	}
	
}
