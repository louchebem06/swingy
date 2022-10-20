package main;

import java.util.*;

import main.java.hero.*;

public class Game {
	
	static public Vector<String> classHero;
	static public Vector<Hero> heros;
	static public Hero currentHero;
	static public Window window;

	public Game() {
		classHero = Utils.getClassHero();
		heros = new Vector<Hero>();
		window = new Window(heros, classHero);
	}

	public static void main(String av[]) {
		new Game();
		try {
			Utils.checkArg(av);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
