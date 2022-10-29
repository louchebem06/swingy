package com.school42.swingy.window;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;

import com.school42.swingy.Main;
import com.school42.swingy.Utils;
import com.school42.swingy.hero.Hero;

public class MainMenu
			extends AbstractWindow
			implements ListSelectionListener, ActionListener
{

	final private JButton _btnNewHero = new JButton("New Hero");
	final private JButton _btnLoadHero = new JButton("Load Hero");
	final private static JScrollPane _scrollPane = new JScrollPane();

	final private static JList<Hero> _heroList = new JList<>();
	final private JLabel _nameLabel = new JLabel();
	final private JLabel _classLabel = new JLabel();
	final private JLabel _levelLabel = new JLabel();
	final private JLabel _xpLabel = new JLabel();
	final private JLabel _attackLabel = new JLabel();
	final private JLabel _defenceLabel = new JLabel();
	final private JLabel _hitPointLabel = new JLabel();
	final private JLabel _weaponLabel = new JLabel();
	final private JLabel _armorLabel = new JLabel();
	final private JLabel _helmLabel = new JLabel();
	final private JLabel _iconLabel = new JLabel();
	private static MainMenu _me = null;

	public MainMenu() {
		super("Main Menu", 430, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerScreen();

		JPanel panel = (JPanel)getContentPane();
		JLabel heroLabel = new JLabel("Hero list");

		panel.add(_btnNewHero);
		panel.add(_btnLoadHero);
		panel.add(heroLabel);
		panel.add(_scrollPane);
		panel.add(_nameLabel);
		panel.add(_classLabel);
		panel.add(_levelLabel);
		panel.add(_xpLabel);
		panel.add(_attackLabel);
		panel.add(_defenceLabel);
		panel.add(_hitPointLabel);
		panel.add(_weaponLabel);
		panel.add(_armorLabel);
		panel.add(_helmLabel);
		panel.add(_iconLabel);

		_btnLoadHero.setEnabled(false);

		_btnNewHero.setBounds(0, 0, 100, 30);
		_btnLoadHero.setBounds(100, 0, 100, 30);
		heroLabel.setBounds(90, 22, 200, 50);
		_scrollPane.setBounds(10, 60, 200, 400);
		_nameLabel.setBounds(220, 40, 200, 50);
		_classLabel.setBounds(220, 60, 200, 50);
		_levelLabel.setBounds(220, 80, 200, 50);
		_xpLabel.setBounds(220, 100, 200, 50);
		_attackLabel.setBounds(220, 120, 200, 50);
		_defenceLabel.setBounds(220, 140, 200, 50);
		_hitPointLabel.setBounds(220, 160, 200, 50);
		_weaponLabel.setBounds(220, 180, 200, 50);
		_armorLabel.setBounds(220, 200, 200, 50);
		_helmLabel.setBounds(220, 220, 200, 50);
		_iconLabel.setBounds(220, 260, 200, 200);

		_btnNewHero.addActionListener(this);
		_btnLoadHero.addActionListener(this);

		windowEvent();

		_me = this;

		updateJList();

		setVisible(true);
	}

	private void windowEvent() {
		this.addWindowListener(new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				CreateHero.iconifiedIfOpen();
			}
			public void windowDeiconified(WindowEvent e) {
				CreateHero.deiconifiedIfOpen();
			}
			public void windowActivated(WindowEvent e) {
				Hero hero = _heroList.getSelectedValue();
				if (hero != null)
					updateLabel(hero);
			}
		});
	}

	public static void updateJList() {
		_heroList.setListData(Main.getAllHero());
		_heroList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_scrollPane.setViewportView(_heroList);

		_heroList.addListSelectionListener(_me);
	}

	private void updateLabel(Hero hero) {
		_nameLabel.setText(hero.getNameLabel().getText());
		_classLabel.setText(hero.getClassNameLabel().getText());
		_levelLabel.setText(hero.getLevelLabel().getText());
		_xpLabel.setText(hero.getXpLabel().getText());
		_attackLabel.setText(hero.getAttackLabel().getText());
		_defenceLabel.setText(hero.getDefenseLabel().getText());
		_hitPointLabel.setText(hero.getHitPointLabel().getText());
		_weaponLabel.setText(hero.getWeaponLabel().getText());
		_armorLabel.setText(hero.getArmorLabel().getText());
		_helmLabel.setText(hero.getHelmLabel().getText());
		_iconLabel.setIcon(hero.getIcon(200));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _btnNewHero) {
			new CreateHero(this, _btnNewHero);
		}
		else if (e.getSource() == _btnLoadHero) {
			CreateHero.closeIfOpen();
			Utils.setupGame();
			new Game(this);
			setVisible(false);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == _heroList && !e.getValueIsAdjusting()) {
			try {
				Hero hero = _heroList.getSelectedValue();

				updateLabel(hero);

				_btnLoadHero.setEnabled(true);

				Main.setCurrentHero(hero);
			} catch (Exception er) { /* ignored */}
		}
	}

}
