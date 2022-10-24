package com.school42.swingy.window;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.school42.swingy.Main;
import com.school42.swingy.artefac.Artefacs;
import com.school42.swingy.hero.Hero;

public class DropItem extends AbstractWindow implements ActionListener {

	private JButton _equiped = new JButton("Equiped");
	private JLabel _myItem = new JLabel();
	private JLabel _enemyItem = new JLabel();
	private JPanel _panel = (JPanel)getContentPane();
	private Artefacs _item = null;
	
	public DropItem(Artefacs item, Hero enemy) {
		super("Drop Item", 350, 190);
		centerScreen();
		if (item == null) {
			dispose();
			return ;
		}

		_item = item;

		switch (item.getType()) {
			case "weapon":
				_myItem.setText("Actual " + Main.getCurrentHero().getWeaponLabel().getText());
				_enemyItem.setText("New " + enemy.getWeaponLabel().getText());
				break ;
			case "armor":
				_myItem.setText("Actual " + Main.getCurrentHero().getArmorLabel().getText());
				_enemyItem.setText("New " + enemy.getArmorLabel().getText());
				break ;
			case "helm":
				_myItem.setText("Actual " + Main.getCurrentHero().getHelmLabel().getText());
				_enemyItem.setText("New " + enemy.getHelmLabel().getText());
				break ;
		}

		_panel.add(_myItem);
		_panel.add(_enemyItem);
		_panel.add(_equiped);

		_myItem.setBounds(10, 10, 330, 40);
		_enemyItem.setBounds(10, 50, 330, 40);
		_equiped.setBounds(10, 90, 330, 40);

		_equiped.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _equiped) {
			Main.getCurrentHero().setArtefac(_item);
			dispose();
		}
	}

}
