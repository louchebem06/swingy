package com.school42.swingy;

import java.util.*;

import com.school42.swingy.hero.*;
import com.school42.swingy.window.*;

public class Main {
	
	static private Vector<String> _classHero = com.school42.swingy.Utils.getClassHero();
	static private Vector<Hero> _heros = new Vector<Hero>();
	static private Vector<Hero> _enemys = new Vector<Hero>();
	static private Hero _currentHero = null;

	public static Vector<String> getClassHero() { return (_classHero); }

	public static Vector<Hero> getHeros() { return (_heros); }

	public static Vector<Hero> getEnemys() { return (_enemys); }

	public static Hero getCurrentHero() { return (_currentHero); }

	public static void setCurrentHero(Hero hero) { _currentHero = hero; }

	public static void main(String av[]) {
		try {
			com.school42.swingy.database.Utils.addAllHero(_heros);
			com.school42.swingy.Utils.checkArg(av);
			if (av[0].toLowerCase().equals("gui"))
				new MainMenu();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
