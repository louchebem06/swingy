package com.school42.swingy.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
	
	private JFrame frameMain = new JFrame("Swingy");
	private JFrame frameNewHero = new JFrame("New Hero");
	private JButton btnNewHero = new JButton("New Hero");
	private JButton btnCreateHero = new JButton("Create");

	public Game() {}

	private void checkArg(String av[]) {
		int len = av.length;
		if (len != 1)
			System.exit(1);
		String arg = av[0];
		if (!arg.equals("gui"))
			System.exit(1);
	}

	private void mainWindow() {
		frameMain.setSize(500, 500);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().add(btnNewHero);
		frameMain.setVisible(true);

		btnNewHero.setBounds(0, 0, 95, 30);
		btnNewHero.addActionListener(new NewHeroActionListener());
	}

	class NewHeroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frameNewHero.setVisible(true);
		}
	}

	private void newHeroWindow() {
		frameNewHero.setSize(500, 500);
		frameNewHero.getContentPane().add(btnCreateHero);

		btnCreateHero.setBounds(0, 0, 95, 30);
	}

	public static void main(String av[]) {
		Game main = new Game();
		main.checkArg(av);
		main.mainWindow();
		main.newHeroWindow();
	}

}
