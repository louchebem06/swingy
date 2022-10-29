package com.school42.swingy.window;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.school42.swingy.Main;
import com.school42.swingy.Utils;
import com.school42.swingy.hero.Hero;

public class Fight extends AbstractWindow implements ActionListener{

	final private JButton _fight = new JButton("Fight");
	final private JButton _run = new JButton("Run");
	final private Hero _a, _b;
	
	public Fight(Hero a, Hero b) {
		super("Fight", 500, 500);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		centerScreen();

		JLabel imgA = new JLabel();
		JLabel imgB = new JLabel();
		JLabel nameA = new JLabel();
		JLabel nameB = new JLabel();
		JLabel levelA = new JLabel();
		JLabel levelB = new JLabel();
		JLabel hpA = new JLabel();
		JLabel hpB = new JLabel();
		JLabel attackA = new JLabel();
		JLabel attackB = new JLabel();
		JLabel defenseA = new JLabel();
		JLabel defenseB = new JLabel();
		JPanel panel = (JPanel)getContentPane();

		_a = a.clone();
		_b = b.clone();
		
		imgA.setIcon(a.getIcon(200));
		imgB.setIcon(b.getIcon(200));
		nameA.setText(a.getNameLabel().getText());
		nameB.setText(b.getNameLabel().getText());
		levelA.setText(a.getLevelLabel().getText());
		levelB.setText(b.getLevelLabel().getText());
		hpA.setText(a.getHitPointLabel().getText());
		hpB.setText(b.getHitPointLabel().getText());
		attackA.setText(a.getAttackLabel().getText());
		attackB.setText(b.getAttackLabel().getText());
		defenseA.setText(a.getDefenseLabel().getText());
		defenseB.setText(b.getDefenseLabel().getText());

		panel.add(imgA);
		panel.add(imgB);
		panel.add(nameA);
		panel.add(nameB);
		panel.add(levelA);
		panel.add(levelB);
		panel.add(hpA);
		panel.add(hpB);
		panel.add(attackA);
		panel.add(attackB);
		panel.add(defenseA);
		panel.add(defenseB);
		panel.add(_fight);
		panel.add(_run);

		imgA.setBounds(30, 30, 200, 200);
		imgB.setBounds(270, 30, 200, 200);
		nameA.setBounds(30, 250, 200, 20);
		nameB.setBounds(270, 250, 200, 20);
		levelA.setBounds(30, 270, 200, 20);
		levelB.setBounds(270, 270, 200, 20);
		hpA.setBounds(30, 290, 200, 20);
		hpB.setBounds(270, 290, 200, 20);
		attackA.setBounds(30, 310, 200, 20);
		attackB.setBounds(270, 310, 200, 20);
		defenseA.setBounds(30, 330, 200, 20);
		defenseB.setBounds(270, 330, 200, 20);
		_fight.setBounds(50, 400, 200, 50);
		_run.setBounds(250, 400, 200, 50);

		_fight.addActionListener(this);
		_run.addActionListener(this);

		setVisible(true);
	}

	private void close() {
		Main.setCurrentEnemy(null);
		Game.setBtn(true);
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _fight) {
			if (Utils.figth(_a, _b)) {
				new DropItem(_b.getWeapon(), _b.clone());
				new DropItem(_b.getArmor(), _b.clone());
				new DropItem(_b.getHelm(), _b.clone());
			} else {
				Utils.resetPositionPlayer();
			}
			close();
		}
		else if (e.getSource() == _run) {
			if (!Utils.run())
				_run.setEnabled(false);
			else
				close();
		}
	}

}
