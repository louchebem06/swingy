package main.java;

import java.util.*;

import main.java.hero.*;
import main.java.*;

public class Game {
	
	static public Vector<String> classHero;
	static public Vector<Hero> heros;
	static public Hero currentHero;
	static public Window window;
	static public DataBase db;
	static public Cordonate position;
	static public Vector<Cordonate> enemyPosition;
	static public Hero currentEnemy;

	public static void main(String av[]) {
		try {
			db = new DataBase();
			classHero = Utils.getClassHero();
			heros = new Vector<Hero>();
			db.readAllHero();
			position = new Cordonate();
			enemyPosition = new Vector<Cordonate>();
			window = new Window(heros, classHero);
			Utils.checkArg(av);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
