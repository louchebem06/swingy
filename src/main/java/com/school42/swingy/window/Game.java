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
	private Item _itemWindow = null;
	private Stat _statWindow = null;
	private Card _cardWindow = null;
	private Event _eventWindow = null;
	private MainMenu _mainMenuWindow = null;
	private Boolean _refresh = false;

	public Game(MainMenu mainMenu) {
		super("Game", 200, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerScreenDown();
		_itemWindow = new Item(getPoint(), getDimension());
		_statWindow = new Stat(getPoint(), getDimension());
		_cardWindow = new Card(getPoint(), getDimension());
		_eventWindow = new Event(getPoint(), getDimension());
		_mainMenuWindow = mainMenu;

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

		eventWindow();

		setVisible(true);
	}

	public static void setBtn(boolean state) {
		_north.setEnabled(state);
		_south.setEnabled(state);
		_west.setEnabled(state);
		_east.setEnabled(state);
	}

	private void eventWindow() {
		this.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				if (_refresh) {
					if (!_itemWindow.isShowing())
						_itemWindow.setVisible(true);
					if (!_cardWindow.isShowing())
						_cardWindow.setVisible(true);
					if (!_statWindow.isShowing())
						_statWindow.setVisible(true);
					if (!_eventWindow.isShowing())
						_eventWindow.setVisible(true);
					_cardWindow.newGame();
					_refresh = false;
				}
			}
		});
	}

	private void fight() {
		_cardWindow.update();
		if (!Utils.checkIsEnemyPosition())
			return ;
		setBtn(false);
		new Fight(Main.getCurrentHero(), Main.getCurrentEnemy(), _cardWindow);
	}

	private void endGame() {
		setVisible(false);
		_itemWindow.setVisible(false);
		_cardWindow.setVisible(false);
		_statWindow.setVisible(false);
		_eventWindow.setVisible(false);
		_mainMenuWindow.setVisible(true);
		_refresh = true;
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
