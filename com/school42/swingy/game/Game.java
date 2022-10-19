package com.school42.swingy.game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.school42.swingy.hero.*;

public class Game {
	
	private JFrame frameMain = new JFrame("Swingy");
	private JFrame frameNewHero = new JFrame("New Hero");
	private JButton btnNewHero = new JButton("New Hero");
	private JButton btnCreateHero = new JButton("Create");
	private JTextField inputNameHero = new JTextField();
	private String classHero[] = {"Leprechaun", "Orc"};
	private JComboBox heroConboBox = new JComboBox(classHero);
	private Vector<Hero> heros = new Vector<Hero>();

	public Game() {}

	private void checkArg(String av[]) {
		int len = av.length;
		if (len != 1)
			System.exit(1);
		String arg = av[0];
		if (!arg.equals("gui"))
			System.exit(1);
	}

	private void mainFrame() {
		frameMain.setSize(500, 500);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().add(btnNewHero);
		frameMain.setLayout(null);
		frameMain.setVisible(true);

		btnNewHero.setBounds(0, 0, 95, 30);
	}

	private void newHeroFrame() {
		JLabel nameLabel = new JLabel("Name:");
		JLabel classNameLabel = new JLabel("Class:");
		JPanel panel = (JPanel)frameNewHero.getContentPane();

		frameNewHero.setSize(400, 200);
		panel.add(btnCreateHero);
		panel.add(nameLabel);
		panel.add(inputNameHero);
		panel.add(heroConboBox);
		panel.add(classNameLabel);
		frameNewHero.setVisible(true);
		frameNewHero.setLayout(null);

		nameLabel.setBounds(10, 10, 80, 30);
		inputNameHero.setBounds(90, 10, 300, 30);

		classNameLabel.setBounds(10, 60, 80, 30);
		heroConboBox.setBounds(90, 60, 300, 30);

		btnCreateHero.setBounds(150, 130, 100, 30);

		btnCreateHero.addActionListener(new CreateHeroListener());
	}

	class CreateHeroListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = inputNameHero.getText();
			String className = (String)heroConboBox.getSelectedItem();
			if (name.length() == 0)
				return ;
			Hero hero = HeroFactory.newHero(className, name);
			heros.add(hero);
			System.out.println("Create Hero: " + hero);
		}
	}

	public static void main(String av[]) {
		Game main = new Game();
		main.checkArg(av);
		main.mainFrame();
		main.newHeroFrame();
	}

}
