package com.school42.swingy.hero;

import com.school42.swingy.hero.heros.*;

public class HeroFactory {
	public static Hero newHero(String type, String name, int lvl, double xp) {
		switch(type) {
			case "Leprechaun":
				return (new Leprechaun(name, lvl, xp));
			case "Orc":
				return (new Orc(name, lvl, xp));
		}
		return (null);
	}
}
