package com.school42.swingy;

import java.util.*;

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
		if (arg.equals("gui")) {
			Main.window.mainMenu();
		}
		else
			throw new Exception(arg + " is not valid");
	}

	static public boolean addHero(String heroName, String className) {
		if (heroName.length() == 0)
			return (false);
		for (String heroClass : Main.classHero) {
			if (heroClass == className) {
				Hero hero = HeroFactory.newHero(className, heroName, 0, 0);
				hero.insert();
				Main.heros.add(hero);
				return (true);
			}
		}
		return (false);
	}
}
