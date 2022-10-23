package com.school42.swingy;

import java.util.*;
import java.awt.Point;

import com.school42.swingy.hero.*;

public class Main {
	
	static public Vector<String> classHero;
	static public Vector<Hero> heros;
	static public Hero currentHero;
	static public Window window;
	static public Vector<Point> enemyPosition;
	static public Hero currentEnemy;

	public static void main(String av[]) {
		try {
			classHero = com.school42.swingy.Utils.getClassHero();
			heros = new Vector<Hero>();
			com.school42.swingy.database.Utils.readAllHero(heros);
			enemyPosition = new Vector<Point>();
			window = new Window(heros, classHero);
			com.school42.swingy.Utils.checkArg(av);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
