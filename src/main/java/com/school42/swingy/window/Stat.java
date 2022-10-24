package com.school42.swingy.window;

import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.school42.swingy.Main;

import java.awt.Dimension;

public class Stat extends AbstractWidgetWindow {

	private JPanel _panel = (JPanel)getContentPane();
	private JSeparator _separator = new JSeparator();
	private JLabel _nameLabel = Main.getCurrentHero().getNameLabel();
	private JLabel _levelLabel = Main.getCurrentHero().getLevelLabel();
	private JLabel _xpLabel = Main.getCurrentHero().getXpLabel();
	private JLabel _attackLabel = Main.getCurrentHero().getAttackLabel();
	private JLabel _defenseLabel = Main.getCurrentHero().getDefenseLabel();
	private JLabel _hitPointLabel = Main.getCurrentHero().getHitPointLabel();
	private JLabel _imgLabel = new JLabel();
	private JLabel _pointLabel = Main.getCurrentHero().getPointLabel();

	public Stat(Point pos, Dimension size) {
		super("Stat", 200, 500);
		placeLeftUp(pos, size);

		_imgLabel.setIcon(Main.getCurrentHero().getIcon(100));

		_panel.add(_imgLabel);
		_panel.add(_nameLabel);
		_panel.add(_levelLabel);
		_panel.add(_xpLabel);
		_panel.add(_attackLabel);
		_panel.add(_defenseLabel);
		_panel.add(_hitPointLabel);
		_panel.add(_separator);
		_panel.add(_pointLabel);

		_separator.setOrientation(SwingConstants.HORIZONTAL);

		_imgLabel.setBounds(10, 10, 100, 100);
		_nameLabel.setBounds(10, 120, 190, 40);
		_levelLabel.setBounds(10, 160, 190, 40);
		_xpLabel.setBounds(10, 200, 190, 40);
		_attackLabel.setBounds(10, 240, 190, 40);
		_defenseLabel.setBounds(10, 280, 190, 40);
		_hitPointLabel.setBounds(10, 320, 190, 40);
		_separator.setBounds(10, 370, 180, 10);
		_pointLabel.setBounds(10, 390, 190, 40);
		
		setVisible(true);
	}
	
}
