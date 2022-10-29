package com.school42.swingy;

import java.util.*;
import java.awt.Point;

import com.school42.swingy.console.ConsoleGame;
import com.school42.swingy.hero.*;
import com.school42.swingy.window.*;

public class Main {
	
	final static private Vector<String> _classHero = com.school42.swingy.Utils.getClassHero();
	final static private Vector<Hero> _vectorHero = new Vector<>();
	final static private Vector<Hero> _vectorEnemy = new Vector<>();
	static private Hero _currentHero = null;
	static private Hero _currentEnemy = null;
	static private int sizeMap = 0;
	static private boolean console = false;

	public static Vector<String> getClassHero() { return (_classHero); }

	public static Vector<Hero> getAllHero() { return (_vectorHero); }

	public static Vector<Hero> getAllEnemy() { return (_vectorEnemy); }

	public static void setAllEnemy(Vector<Point> pos) {
		for (Point p : pos) {
			Hero en = HeroFactory.randomHero(_currentHero.getXp());
			en.setPoint((int)p.getX(), (int)p.getY());
			_vectorEnemy.add(en);
		}
	}

	public static void setConsole() { console = true; }

	public static boolean isConsole() { return (console); }

	public static void setCurrentEnemy(Hero enemy) { _currentEnemy = enemy; }
	
	public static Hero getCurrentEnemy() { return (_currentEnemy); }

	public static Hero getCurrentHero() { return (_currentHero); }

	public static void setCurrentHero(Hero hero) { _currentHero = hero; }

	public static void setSizeMap(int size) { sizeMap = size; }

	public static int getSizeMap() { return (sizeMap); }

	public static void main(String [] av) {
		try {
			com.school42.swingy.database.Utils.addAllHero(_vectorHero);
			com.school42.swingy.Utils.checkArg(av);
			if (av[0].equalsIgnoreCase("gui"))
				new MainMenu();
			else if (av[0].equalsIgnoreCase("console"))
				new ConsoleGame();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
	}

}
