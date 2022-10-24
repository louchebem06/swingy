package com.school42.swingy;

import java.util.*;
import java.awt.Point;

import com.school42.swingy.hero.*;
import com.school42.swingy.window.*;

public class Main {
	
	static private Vector<String> _classHero = com.school42.swingy.Utils.getClassHero();
	static private Vector<Hero> _heros = new Vector<Hero>();
	static private Vector<Hero> _enemys = new Vector<Hero>();
	static private Hero _currentHero = null;
	static private Hero _currentEnemy = null;
	static private int sizeMap = 0;

	public static Vector<String> getClassHero() { return (_classHero); }

	public static Vector<Hero> getHeros() { return (_heros); }

	public static Vector<Hero> getEnemys() { return (_enemys); }

	public static void setEnemys(Vector<Point> pos) {
		for (Point p : pos) {
			Hero en = HeroFactory.randomHero(_currentHero.getXp());
			en.setPoint((int)p.getX(), (int)p.getY());
			_enemys.add(en);
		}
	}

	public static void setCurrentEnemy(Hero enemy) { _currentEnemy = enemy; }
	
	public static Hero getCurrentEnemy() { return (_currentEnemy); }

	public static Hero getCurrentHero() { return (_currentHero); }

	public static void setCurrentHero(Hero hero) { _currentHero = hero; }

	public static void setSizeMap(int size) { sizeMap = size; }

	public static int getSizeMap() { return (sizeMap); }

	public static void main(String av[]) {
		try {
			com.school42.swingy.database.Utils.addAllHero(_heros);
			com.school42.swingy.Utils.checkArg(av);
			if (av[0].toLowerCase().equals("gui"))
				new MainMenu();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
	}

}
