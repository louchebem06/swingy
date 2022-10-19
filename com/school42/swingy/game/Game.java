package com.school42.swingy.game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.school42.swingy.hero.*;

public class Game {
	
	private JFrame frame = new JFrame();
	private JButton btnNewHero = new JButton("New Hero");
	private JButton btnCreateHero = new JButton("Create");
	private JButton btnCancelCreateHero = new JButton("Cancel");
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
		if (arg.equals("gui")) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainMenu();
		}
		else
			System.exit(1);
	}

	private void clearFrame(String title, int width, int height) {
		frame.getContentPane().removeAll();
 		frame.repaint();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setTitle(title);
		frame.setLayout(null);
	}

	private void mainMenu() {
		System.out.println("NB Heros: " + heros.size());

		clearFrame("Main menu", 500, 500);
		frame.getContentPane().add(btnNewHero);

		btnNewHero.setBounds(0, 0, 95, 30);
		btnNewHero.addActionListener(new toCreateHero());
	}

	class toCreateHero implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			createHero();
		}
	}

	private void createHero() {
		clearFrame("Create Hero", 400, 200);

		JLabel nameLabel = new JLabel("Name:");
		JLabel classNameLabel = new JLabel("Class:");
		JPanel panel = (JPanel)frame.getContentPane();

		panel.add(btnCreateHero);
		panel.add(nameLabel);
		panel.add(inputNameHero);
		panel.add(heroConboBox);
		panel.add(classNameLabel);
		panel.add(btnCancelCreateHero);

		nameLabel.setBounds(10, 10, 80, 30);
		inputNameHero.setBounds(90, 10, 300, 30);

		classNameLabel.setBounds(10, 60, 80, 30);
		heroConboBox.setBounds(90, 60, 300, 30);

		btnCreateHero.setBounds(75, 130, 100, 30);
		btnCancelCreateHero.setBounds(215, 130, 100, 30);

		// btnCreateHero.setEnabled(false);
		btnCreateHero.addActionListener(new CreateHeroListener());
		btnCancelCreateHero.addActionListener(new CancelCreateHeroListener());
	}

	class CreateHeroListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = inputNameHero.getText();
			if (name.length() == 0)
				return ;
			String className = (String)heroConboBox.getSelectedItem();
			Hero hero = HeroFactory.newHero(className, name);
			heros.add(hero);
			System.out.println("Create Hero: " + hero);
			inputNameHero.setText("");
			mainMenu();
		}
	}

	class CancelCreateHeroListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mainMenu();
		}
	}

	public static void main(String av[]) {
		Game main = new Game();
		main.checkArg(av);
	}

}
