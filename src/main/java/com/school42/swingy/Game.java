package com.school42.swingy;

import java.util.*;

import com.school42.swingy.hero.*;

public class Game {
	
	static public Vector<String> classHero;
	static public Vector<Hero> heros;
	static public Hero currentHero;
	static public Window window;
	static public Cordonate position;
	static public Vector<Cordonate> enemyPosition;
	static public Hero currentEnemy;

	public static void main(String av[]) {
		try {
			classHero = com.school42.swingy.Utils.getClassHero();
			heros = new Vector<Hero>();
			com.school42.swingy.database.Utils.readAllHero(heros);
			position = new Cordonate();
			enemyPosition = new Vector<Cordonate>();
			window = new Window(heros, classHero);
			com.school42.swingy.Utils.checkArg(av);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
