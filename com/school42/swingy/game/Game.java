package com.school42.swingy.game;

import java.util.Scanner;
import java.util.logging.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import com.school42.swingy.hero.Hero;
import com.school42.swingy.hero.HeroFactory;

public class Game {
	private static String _mode;
	private static Hero _hero;
	private static String[] _heroClass = {
		"Orc",
		"Leprechaun"
	};

	private static String _launchMode(String av[]) throws Exception {
		if (av.length != 1)
			throw new Exception("Please input console or gui");
		if (av[0].equals("console") || av[0].equals("gui"))
			return (av[0]);
		throw new Exception(av[0] + " != console or gui");
	}

	public static void main(String argv[]) {
		try {
			_mode = _launchMode(argv);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		_game();
	}

	private static void _printHeroClass() {
		for (String hero : _heroClass)
			System.out.print(hero + " | ");
	}

	private static Boolean _validClassName(String className) {
		for (String hero : _heroClass)
			if (className.equals(hero))
				return (true);
		return (false);
	}

	private static void _newHeroCLI() {
		String className = null;
		String name = null;

		Scanner sc = new Scanner(System.in);
		while (className == null || !_validClassName(className)) {
			_printHeroClass();
			System.out.print("\nPlease input class: ");
			className = sc.nextLine();
		}
		while (name == null || name.length() == 0) {
			System.out.print("Please input name: ");
			name = sc.nextLine();
		}
		sc.close();
		_hero = HeroFactory.heroFactory(className, name);
	}

	private static void _newHeroGUI() {
		JFrame window = new JFrame();
		window.setTitle("Create new hero");  
		window.setSize(500, 150);

		window.setLayout(new GridLayout(3, 2));

		JPanel panel = (JPanel) window.getContentPane();

		JLabel labelClass = new JLabel("Select class: ");
		panel.add(labelClass);

		JComboBox<String> classList = new JComboBox<String>(_heroClass);
		panel.add(classList);

		JLabel labelName = new JLabel("Please input name hero: ");
		panel.add(labelName);

		JTextField nameArea = new JTextField();
		panel.add(nameArea);

		JButton validBtn = new JButton("Create");
		panel.add(validBtn);

		window.setVisible(true);

		// WindowListener we = new WindowListener() {
		// 	@Override
		// 	public void windowOpened(WindowEvent e) {
		// 		System.out.println("Open");
		// 	}

		// 	@Override
		// 	public void windowClosing(WindowEvent e) {
		// 		System.out.println("Closing");
		// 	}

		// 	@Override
		// 	public void windowClosed(WindowEvent e) {
		// 		System.out.println("close");
		// 	}

		// 	@Override
		// 	public void windowDeactivated(WindowEvent e) {
		// 		System.out.println("Deactivate");
		// 	}

		// 	@Override
		// 	public void windowIconified(WindowEvent e) {
		// 		// TODO Auto-generated method stub
				
		// 	}

		// 	@Override
		// 	public void windowDeiconified(WindowEvent e) {
		// 		// TODO Auto-generated method stub
				
		// 	}

		// 	@Override
		// 	public void windowActivated(WindowEvent e) {
		// 		// TODO Auto-generated method stub
				
		// 	}
		// };

		// window.addWindowListener(we);
	}

	private static void _newHero() {
		if (_mode.equals("console"))
			_newHeroCLI();
		else if (_mode.equals("gui"))
			_newHeroGUI();
	}

	private static void _heroView() {
		_newHero();
	}

	private static void _game() {
		_heroView();
		System.out.println(_hero);
		// while (true) {
		// }
	}

}
