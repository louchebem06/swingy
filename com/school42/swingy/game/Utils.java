package com.school42.swingy.game;

import java.util.*;

import com.school42.swingy.hero.*;

import java.io.*;

public class Utils {

	static public Vector<String> getClassHero() {
		Vector<String> classHeros = new Vector<String>();
		File f = new File("./com/school42/swingy/hero/heros");
        String[] names = f.list();
        for (String name : names) {
			String ext = name.substring(name.length() - 5);
            if (!ext.equals(".java"))
				continue ;
			String className = name.substring(0, name.length() - 5);
			classHeros.add(className);
        }
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
			Game.window.mainMenu();
		}
		else
			throw new Exception(arg + " is not valid");
	}

	static public boolean addHero(String heroName, String className) {
		if (heroName.length() == 0)
			return (false);
		for (String heroClass : Game.classHero) {
			if (heroClass == className) {
				Hero hero = HeroFactory.newHero(className, heroName, 0, 0);
				Game.heros.add(hero);
				return (true);
			}
		}
		return (false);
	}
}
