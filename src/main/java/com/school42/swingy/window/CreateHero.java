package com.school42.swingy.window;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.*;

import com.school42.swingy.Main;
import com.school42.swingy.Utils;
import com.school42.swingy.hero.Hero;
import com.school42.swingy.hero.HeroFactory;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateHero extends AbstractWindow implements ActionListener {
	
	private static boolean _open = false;
	private static JButton _btnNewHero = null;
	private static CreateHero _frame = null;
	private JPanel _panel = (JPanel)getContentPane();
	private JButton _btnCreateHero = new JButton("Create Hero");
	private JLabel _nameLabel = new JLabel("Name");
	private JTextField _inputNameHero = new JTextField();
	private JComboBox<String> _heroConboBox = new JComboBox<String>(Main.getClassHero());
	private JLabel _classLabel = new JLabel("Class");
	private JLabel _imgClass = new JLabel();
	private Hero _hero = null;
	private JLabel _attackLabel = new JLabel();
	private JLabel _defenseLabel = new JLabel();
	private JLabel _hitPointsLabel = new JLabel();
	private static MainMenu _mainMenu = null;

	public CreateHero(MainMenu mainMenu, JButton btnNewHero)
	{
		super("Create Hero", 400, 250);
		mainMenu.setVisible(false);
		centerScreen();
		_open = true;
		_frame = this;
		_mainMenu = mainMenu;
		_btnNewHero = btnNewHero;
		_btnNewHero.setEnabled(false);
		_btnCreateHero.setEnabled(false);
		windowEvent();

		_panel.add(_nameLabel);
		_panel.add(_inputNameHero);
		_panel.add(_heroConboBox);
		_panel.add(_classLabel);
		_panel.add(_imgClass);
		_panel.add(_btnCreateHero);
		_panel.add(_attackLabel);
		_panel.add(_defenseLabel);
		_panel.add(_hitPointsLabel);

		_nameLabel.setBounds(10, 10, 100, 30);
		_classLabel.setBounds(10, 40, 100, 30);
		_inputNameHero.setBounds(60, 10, 330, 30);
		_heroConboBox.setBounds(60, 40, 330, 30);
		_btnCreateHero.setBounds(150, 80, 100, 30);

		_attackLabel.setBounds(120, 115, 280, 30);
		_defenseLabel.setBounds(120, 145, 280, 30);
		_hitPointsLabel.setBounds(120, 175, 280, 30);
		_imgClass.setBounds(10, 110, 100, 100);

		updateDataHero();

		_heroConboBox.addActionListener(this);
		_btnCreateHero.addActionListener(this);

		_inputNameHero.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				JTextField text = (JTextField)e.getSource();
				String tmp = text.getText();
				_btnCreateHero.setEnabled(!(tmp.length() == 0));
			}
		});

		setVisible(true);
	}

	private void updateDataHero() {
		String item = _heroConboBox.getSelectedItem().toString();

		_hero = HeroFactory.newHero(item, item, 0, 0);
		_imgClass.setIcon(_hero.getIcon(100));
		_attackLabel.setText(_hero.getAttackLabel().getText());
		_defenseLabel.setText(_hero.getDefenseLabel().getText());
		_hitPointsLabel.setText(_hero.getHitPointLabel().getText());
	}

	private void windowEvent() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { close(); }
		});
	}

	public static void closeIfOpen() {
		if (_open)
			close();
	}

	public static void iconifiedIfOpen() {
		if (_open)
			_frame.setState(ICONIFIED);
	}

	public static void deiconifiedIfOpen() {
		if (_open)
			_frame.setState(NORMAL);
	}

	private static void close() {
		_open = false;
		_btnNewHero.setEnabled(true);
		_frame.dispose();
		_mainMenu.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _heroConboBox) {
			updateDataHero();
		} else if (e.getSource() == _btnCreateHero) {
			String name = _inputNameHero.getText();
			String heroClass = _heroConboBox.getSelectedItem().toString();
			Utils.addHero(Main.getAllHero(), name, heroClass, Main.getClassHero());
			MainMenu.updateJList();
			close();
		}
	}

}
