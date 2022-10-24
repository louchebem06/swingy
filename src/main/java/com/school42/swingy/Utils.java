package com.school42.swingy;

import java.util.*;
import java.awt.Point;

import com.school42.swingy.hero.*;

public class Utils {

	static public Vector<String> getClassHero() {
		Vector<String> classHeros = new Vector<String>();
		classHeros.add("Demon");
		classHeros.add("Druid");
		classHeros.add("Hunter");
		classHeros.add("Knight");
		classHeros.add("Mage");
		classHeros.add("Monk");
		classHeros.add("Paladin");
		classHeros.add("Priest");
		classHeros.add("Rogue");
		classHeros.add("Shaman");
		classHeros.add("Warlock");
		classHeros.add("Warrior");
		return (classHeros);
	}

	static public void checkArg(String av[]) throws Exception {
		int len = av.length;
		if (len < 1)
			throw new Exception("Not enough argument");
		else if (len > 1)
			throw new Exception("Too much argument");
		String arg = av[0];
		if (arg.toLowerCase().equals("gui")
			|| arg.toLowerCase().equals("console"))
		{
			return ;
		}
		throw new Exception(arg + " is not valid");
	}

	static public boolean addHero(Vector<Hero> heros, String heroName,
									String className, Vector<String> classHero)
	{
		if (heroName.length() == 0)
			return (false);
		for (String heroClass : classHero) {
			if (heroClass == className) {
				int lvl = 0;
				double xp = 0;
				Hero hero = HeroFactory.newHero(className, heroName, lvl, xp);
				hero.insert();
				heros.add(hero);
				return (true);
			}
		}
		return (false);
	}

	static public void moveHero(String move) {
		Hero hero = Main.getCurrentHero();
		int x = -1;
		int y = -1;
		move = move.toLowerCase();
		switch (move) {
			case "north":
				x = (int)hero.getPoint().getX();
				y = (int)(hero.getPoint().getY()) - 1;
				break;
			case "south":
				x = (int)hero.getPoint().getX();
				y = (int)(hero.getPoint().getY()) + 1;
				break;
			case "east":
				x = (int)(hero.getPoint().getX()) + 1;
				y = (int)hero.getPoint().getY();
				break;
			case "west":
				x = (int)(hero.getPoint().getX()) - 1;
				y = (int)hero.getPoint().getY();
				break;
		}
		if (x < 0 || y < 0 || x >= Main.getSizeMap() || y >= Main.getSizeMap())
			return ;
		System.out.println("Your move to (" + x + ", " + y + ")");
		hero.setPoint(x, y);
	}

	public static boolean figth(Hero a, Hero b) {
		String damage = null;
		while (a.isAlive() && b.isAlive()) {
			if (Math.random() > 0.5) {
				damage = a.attack(b);
				System.out.println(a.getName() + " influge " + damage + " degats to " + b.getName());
			}
			else {
				damage = b.attack(a);
				System.out.println(b.getName() + " influge " + damage + " degats to " + a.getName());
			}
			System.out.println("\n" + a.getName() + " : " + a.getHitPoint() + " hp");
			System.out.println(b.getName() + " : " + b.getHitPoint() + " hp\n");
		}
		System.out.println("Your fight: " + a.isAlive());
		if (a.isAlive()) {
			double xpWin = (a.getLevel() + 1) * 5 + (b.getLevel() + 1) * 100;
			Main.getCurrentHero().addXp(xpWin);
			System.out.println("You win " + xpWin + "xp");
		}
		return (a.isAlive());
	}

	public static void resetPositionPlayer() {
		Hero hero = Main.getCurrentHero();
		int x = (int)(Math.random() * Main.getSizeMap());
		int y = (int)(Math.random() * Main.getSizeMap());
		hero.setPoint(x, y);
		System.out.println("Your are reset Position");
	}

	public static Boolean run() {
		boolean isRun = Math.random() > 0.5;
		System.out.println("Your run: " + isRun);
		return (isRun);
	}

	private static int getNbEnemy(int sizeMap) {
		int nbCase = sizeMap * sizeMap;
		return ((int)(((double)(double)nbCase / (double)100) * (double)20));
	}

	public static Vector<Point> generateEnemysPos(int sizeMap) {
		int nbEnemy = getNbEnemy(sizeMap);
		Vector<Point> enemys = new Vector<Point>();

		for (int i = 0; i < nbEnemy; i++)
			enemys.add(new Point((int)(Math.random() * sizeMap), (int)(Math.random() * sizeMap)));
		return (enemys);
	}

	static public void setupGame() {
		Main.setSizeMap(Main.getCurrentHero().getSizeMap());
		Main.setEnemys(generateEnemysPos(Main.getSizeMap()));
	}

	static public boolean checkIsEnemyPosition() {
		int i = 0;
		for (Hero enemy : Main.getEnemys()) {
			if (enemy.getPoint().equals(Main.getCurrentHero().getPoint())) {
				Main.setCurrentEnemy(enemy);
				Main.getEnemys().remove(i);
				System.out.println("Enemy found");
				return (true);
			}
			i++;
		}
		return (false);
	}

}
