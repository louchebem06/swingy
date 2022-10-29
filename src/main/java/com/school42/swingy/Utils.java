package com.school42.swingy;

import java.util.*;
import java.awt.Point;

import com.school42.swingy.hero.*;
import com.school42.swingy.window.Game;

public class Utils {

	static public Vector<String> getClassHero() {
		Vector<String> vectorClassHero = new Vector<>();
		vectorClassHero.add("Demon");
		vectorClassHero.add("Druid");
		vectorClassHero.add("Hunter");
		vectorClassHero.add("Knight");
		vectorClassHero.add("Mage");
		vectorClassHero.add("Monk");
		vectorClassHero.add("Paladin");
		vectorClassHero.add("Priest");
		vectorClassHero.add("Rogue");
		vectorClassHero.add("Shaman");
		vectorClassHero.add("Warlock");
		vectorClassHero.add("Warrior");
		return (vectorClassHero);
	}

	static public void checkArg(String [] av) throws Exception {
		int len = av.length;
		if (len < 1)
			throw new Exception("Not enough argument");
		else if (len > 1)
			throw new Exception("Too much argument");
		String arg = av[0];
		if (arg.equalsIgnoreCase("gui")
			|| arg.equalsIgnoreCase("console"))
		{
			return ;
		}
		throw new Exception(arg + " is not valid");
	}

	static public boolean addHero(Vector<Hero> vectorHero, String heroName,
									String className, Vector<String> classHero)
	{
		if (heroName.length() == 0)
			return (false);
		for (String heroClass : classHero) {
			if (heroClass.equals(className)) {
				int lvl = 0;
				double xp = 0;
				Hero hero = HeroFactory.newHero(className, heroName, lvl, xp);
				if (hero != null) {
					hero.insert();
					vectorHero.add(hero);
					return (true);
				} else {
					System.out.println("Error: generation enemy");
					System.exit(1);
				}
			}
		}
		return (false);
	}

	static public boolean heroMove(String move) {
		Hero hero = Main.getCurrentHero();
		int x = -1;
		int y = -1;
		switch (move.toLowerCase()) {
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
			return (false);
		Game.write("Your move to (" + x + ", " + y + ")");
		hero.setPoint(x, y);
		Game.updateMap(x, y);
		return (true);
	}

	public static void resetPositionPlayer() {
		Hero hero = Main.getCurrentHero();
		int x = Main.getSizeMap() / 2;
		int y = Main.getSizeMap() / 2;
		hero.setPoint(x, y);
		Game.updateMap(x, y);
		Game.write("You position is reset");
	}

	public static boolean figth(Hero a, Hero b) {
		String damage;
		while (a.isAlive() && b.isAlive()) {
			if (Math.random() > 0.5) {
				damage = a.attack(b);
				if (Main.isConsole())
					System.out.println(a.getName() + " influge " + damage + " degats to " + b.getName());
				else
					Game.write(a.getName() + " influge " + damage + " degats to " + b.getName());
			} else {
				damage = b.attack(a);
				if (Main.isConsole())
					System.out.println(b.getName() + " influge " + damage + " degats to " + a.getName());
				else
					Game.write(b.getName() + " influge " + damage + " degats to " + a.getName());
			}
		}
		if (a.isAlive()) {
			double xpWin = (a.getLevel() + 1) * 5 + (b.getLevel() + 1) * 100;
			Main.getCurrentHero().addXp(xpWin);
			if (Main.isConsole())
				System.out.println("Your win " + xpWin + " xp");
			else
				Game.write("Your win " + xpWin + " xp");
		} else {
			if (Main.isConsole())
				System.out.println("You lose fight");
			else
				Game.write("You lose fight");
		}
		return (a.isAlive());
	}

	public static Boolean run() {
		boolean isRun = Math.random() > 0.5;
		Game.write("Your run: " + isRun);
		return (isRun);
	}

	private static int getNbEnemy(int sizeMap) {
		int nbCase = sizeMap * sizeMap;
		return ((int)(((double)nbCase / (double)100) * (double)20));
	}

	public static Vector<Point> generateEnemysPos(int sizeMap) {
		int nbEnemy = getNbEnemy(sizeMap);
		Vector<Point> enemys = new Vector<>();

		for (int i = 0; i < nbEnemy; i++)
			enemys.add(new Point((int)(Math.random() * sizeMap), (int)(Math.random() * sizeMap)));
		return (enemys);
	}

	static public void setupGame() {
		Main.setSizeMap(Main.getCurrentHero().getSizeMap());
		Main.setAllEnemy(generateEnemysPos(Main.getSizeMap()));
		Main.getCurrentHero().setPoint(Main.getSizeMap() / 2, Main.getSizeMap() / 2);
		Game.clear();
	}

	static public boolean checkIsEnemyPosition() {
		int i = 0;
		for (Hero enemy : Main.getAllEnemy()) {
			if (enemy.getPoint().equals(Main.getCurrentHero().getPoint())) {
				Main.setCurrentEnemy(enemy);
				Main.getAllEnemy().remove(i);
				Game.write("Enemy found");
				return (true);
			}
			i++;
		}
		return (false);
	}

}
