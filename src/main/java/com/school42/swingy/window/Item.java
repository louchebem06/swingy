package com.school42.swingy.window;

import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.school42.swingy.Main;

import java.awt.Dimension;

public class Item extends AbstractWidgetWindow { 

	private JPanel _panel = (JPanel)getContentPane();
	private JLabel _weaponLabel = Main.getCurrentHero().getWeaponLabel();
	private JLabel _armorLabel = Main.getCurrentHero().getArmorLabel();
	private JLabel _helmLabel = Main.getCurrentHero().getHelmLabel();
	
	public Item(Point pos, Dimension size) {
		super("Item", 200, 250);
		placeUp(pos, size);

		_panel.add(_weaponLabel);
		_panel.add(_armorLabel);
		_panel.add(_helmLabel);

		_weaponLabel.setBounds(10, 10, 190, 40);
		_armorLabel.setBounds(10, 50, 190, 40);
		_helmLabel.setBounds(10, 90, 190, 40);

		setVisible(true);
	}

}
