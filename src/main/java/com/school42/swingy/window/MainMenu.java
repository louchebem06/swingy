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

	private JButton _btnNewHero = new JButton("New Hero");
	private JButton _btnLoadHero = new JButton("Load Hero");
	private JPanel _panel = (JPanel)getContentPane();
	private JScrollPane _scrollPane = new JScrollPane();
	private JLabel _heroLabel = new JLabel("HEROS");
	private JList<Hero> _heroList = new JList<Hero>();
	private JLabel _nameLabel = new JLabel();
	private JLabel _classLabel = new JLabel();
	private JLabel _levelLabel = new JLabel();
	private JLabel _xpLabel = new JLabel();
	private JLabel _attackLabel = new JLabel();
	private JLabel _defenceLabel = new JLabel();
	private JLabel _hitPointLabel = new JLabel();
	private JLabel _weaponLabel = new JLabel();
	private JLabel _armorLabel = new JLabel();
	private JLabel _helmLabel = new JLabel();
	private JLabel _iconLabel = new JLabel();

	public MainMenu() {
		super("Main Menu", 430, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerScreen();

		_panel.add(_btnNewHero);
		_panel.add(_btnLoadHero);
		_panel.add(_heroLabel);
		_panel.add(_scrollPane);
		_panel.add(_nameLabel);
		_panel.add(_classLabel);
		_panel.add(_levelLabel);
		_panel.add(_xpLabel);
		_panel.add(_attackLabel);
		_panel.add(_defenceLabel);
		_panel.add(_hitPointLabel);
		_panel.add(_weaponLabel);
		_panel.add(_armorLabel);
		_panel.add(_helmLabel);
		_panel.add(_iconLabel);

		_heroList.setListData(Main.getHeros());
		_heroList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_scrollPane.setViewportView(_heroList);

		_btnLoadHero.setEnabled(false);

		_btnNewHero.setBounds(0, 0, 100, 30);
		_btnLoadHero.setBounds(100, 0, 100, 30);
		_heroLabel.setBounds(90, 22, 200, 50);
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
		_heroList.addListSelectionListener(this);

		windowEvent();

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
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _btnNewHero) {
			new CreateHero(getPoint(), getDimension(), _btnNewHero, _scrollPane);
		}
		else if (e.getSource() == _btnLoadHero) {
			CreateHero.closeIfOpen();
			Utils.setupGame();
			new Game();
			dispose();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == _heroList && !e.getValueIsAdjusting()) {
			Hero hero = _heroList.getSelectedValue();
			
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

			_btnLoadHero.setEnabled(true);

			Main.setCurrentHero(hero);
		}
	}

}
