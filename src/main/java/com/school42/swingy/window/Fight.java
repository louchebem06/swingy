package com.school42.swingy.window;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.school42.swingy.Main;
import com.school42.swingy.Utils;
import com.school42.swingy.hero.Hero;

public class Fight extends AbstractWindow implements ActionListener{

	private JLabel _imgA = new JLabel();
	private JLabel _imgB = new JLabel();
	private JLabel _nameA = new JLabel();
	private JLabel _nameB = new JLabel();
	private JLabel _levelA = new JLabel();
	private JLabel _levelB = new JLabel();
	private JLabel _hpA = new JLabel();
	private JLabel _hpB = new JLabel();
	private JLabel _attackA = new JLabel();
	private JLabel _attackB = new JLabel();
	private JLabel _defenseA = new JLabel();
	private JLabel _defenseB = new JLabel();
	private JButton _fight = new JButton("Fight");
	private JButton _run = new JButton("Run");
	private JPanel _panel = (JPanel)getContentPane();
	private Hero _a = null;
	private Hero _b = null;
	private Card _cardWindow = null;
	
	public Fight(Hero a, Hero b, Card card) {
		super("Fight", 500, 500);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		centerScreen();

		_a = a.clone();
		_b = b.clone();
		_cardWindow = card;
		
		_imgA.setIcon(a.getIcon(200));
		_imgB.setIcon(b.getIcon(200));
		_nameA.setText(a.getNameLabel().getText());
		_nameB.setText(b.getNameLabel().getText());
		_levelA.setText(a.getLevelLabel().getText());
		_levelB.setText(b.getLevelLabel().getText());
		_hpA.setText(a.getHitPointLabel().getText());
		_hpB.setText(b.getHitPointLabel().getText());
		_attackA.setText(a.getAttackLabel().getText());
		_attackB.setText(b.getAttackLabel().getText());
		_defenseA.setText(a.getDefenseLabel().getText());
		_defenseB.setText(b.getDefenseLabel().getText());

		_panel.add(_imgA);
		_panel.add(_imgB);
		_panel.add(_nameA);
		_panel.add(_nameB);
		_panel.add(_levelA);
		_panel.add(_levelB);
		_panel.add(_hpA);
		_panel.add(_hpB);
		_panel.add(_attackA);
		_panel.add(_attackB);
		_panel.add(_defenseA);
		_panel.add(_defenseB);
		_panel.add(_fight);
		_panel.add(_run);

		_imgA.setBounds(30, 30, 200, 200);
		_imgB.setBounds(270, 30, 200, 200);
		_nameA.setBounds(30, 250, 200, 20);
		_nameB.setBounds(270, 250, 200, 20);
		_levelA.setBounds(30, 270, 200, 20);
		_levelB.setBounds(270, 270, 200, 20);
		_hpA.setBounds(30, 290, 200, 20);
		_hpB.setBounds(270, 290, 200, 20);
		_attackA.setBounds(30, 310, 200, 20);
		_attackB.setBounds(270, 310, 200, 20);
		_defenseA.setBounds(30, 330, 200, 20);
		_defenseB.setBounds(270, 330, 200, 20);
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
				_cardWindow.update();
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
