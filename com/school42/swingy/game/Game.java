package com.school42.swingy.game;

import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.*;

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

	private static void _newHero() {
		String className = null, name = null;

		if (_mode.equals("console")) {
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
		} else if (_mode.equals("gui")) {
			JFrame window = new JFrame("Create Hero");  
			JPanel panel = new JPanel();
			JLabel labelClass = new JLabel("Select class: ");
			JLabel labelName = new JLabel("Please input name hero: ");
			JButton validBtn = new JButton("Create");
			JComboBox classList = new JComboBox(_heroClass);
			JTextField nameArea = new JTextField();
			nameArea.setSize(new Dimension(250, 30));
			panel.add(labelClass);
			panel.add(classList);
			panel.add(labelName);
			panel.add(nameArea);
			panel.add(validBtn);
			window.add(panel);
			window.setSize(250, 250);
			window.setVisible(true);
		}
		_hero = HeroFactory.heroFactory(className, name);
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
