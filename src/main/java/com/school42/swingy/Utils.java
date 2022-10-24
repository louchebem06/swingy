package com.school42.swingy;

import java.util.*;

import com.school42.swingy.hero.*;
import com.school42.swingy.window.DropItem;
import com.school42.swingy.window.Fight;
import com.school42.swingy.window.MainMenu;

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
}
