package com.school42.swingy.window;

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
	final private JButton _btnCreateHero = new JButton("Create Hero");
	final private JTextField _inputNameHero = new JTextField();
	final private JComboBox<String> _heroConboBox = new JComboBox<>(Main.getClassHero());
	final private JLabel _imgClass = new JLabel();
	final private JLabel _attackLabel = new JLabel();
	final private JLabel _defenseLabel = new JLabel();
	final private JLabel _hitPointsLabel = new JLabel();
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

		JPanel panel = (JPanel)getContentPane();
		JLabel nameLabel = new JLabel("Name");
		JLabel classLabel = new JLabel("Class");

		panel.add(nameLabel);
		panel.add(_inputNameHero);
		panel.add(_heroConboBox);
		panel.add(classLabel);
		panel.add(_imgClass);
		panel.add(_btnCreateHero);
		panel.add(_attackLabel);
		panel.add(_defenseLabel);
		panel.add(_hitPointsLabel);

		nameLabel.setBounds(10, 10, 100, 30);
		classLabel.setBounds(10, 40, 100, 30);
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
		if (item == null)
			return ;
		Hero hero = HeroFactory.newHero(item, item, 0, 0);
		if (hero == null)
			return ;
		_imgClass.setIcon(hero.getIcon(100));
		_attackLabel.setText(hero.getAttackLabel().getText());
		_defenseLabel.setText(hero.getDefenseLabel().getText());
		_hitPointsLabel.setText(hero.getHitPointLabel().getText());
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
