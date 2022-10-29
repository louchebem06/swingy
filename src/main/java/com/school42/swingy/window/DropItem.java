package com.school42.swingy.window;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.school42.swingy.Main;
import com.school42.swingy.artefac.*;
import com.school42.swingy.hero.Hero;

public class DropItem extends AbstractWindow implements ActionListener {

	final private JButton _equiped = new JButton("Equiped");
	private Artefac _item = null;
	
	public DropItem(Artefac item, Hero enemy) {
		super("Drop Item", 350, 190);
		centerScreen();
		if (item == null) {
			dispose();
			return ;
		}

		JLabel myItem = new JLabel();
		JLabel enemyItem = new JLabel();
		JPanel panel = (JPanel)getContentPane();

		_item = item;

		switch (item.getType()) {
			case "weapon":
				myItem.setText("Actual " + Main.getCurrentHero().getWeaponLabel().getText());
				enemyItem.setText("New " + enemy.getWeaponLabel().getText());
				break ;
			case "armor":
				myItem.setText("Actual " + Main.getCurrentHero().getArmorLabel().getText());
				enemyItem.setText("New " + enemy.getArmorLabel().getText());
				break ;
			case "helm":
				myItem.setText("Actual " + Main.getCurrentHero().getHelmLabel().getText());
				enemyItem.setText("New " + enemy.getHelmLabel().getText());
				break ;
		}

		panel.add(myItem);
		panel.add(enemyItem);
		panel.add(_equiped);

		myItem.setBounds(10, 10, 330, 40);
		enemyItem.setBounds(10, 50, 330, 40);
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
