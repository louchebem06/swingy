package com.school42.swingy.hero;

import com.school42.swingy.hero.heros.*;

public class HeroFactory {
	public static Hero newHero(String type, String name, int lvl, double xp) {
		switch(type) {
			case "Demon":
				return (new Demon(name, lvl, xp));
			case "Druid":
				return (new Druid(name, lvl, xp));
			case "Hunter":
				return (new Hunter(name, lvl, xp));
			case "Knigth":
				return (new Knight(name, lvl, xp));
			case "Mage":
				return (new Mage(name, lvl, xp));
			case "Monk":
				return (new Monk(name, lvl, xp));
			case "Paladin":
				return (new Paladin(name, lvl, xp));
			case "Priest":
				return (new Priest(name, lvl, xp));
			case "Rogue":
				return (new Rogue(name, lvl, xp));
			case "Shaman":
				return (new Shaman(name, lvl, xp));
			case "Warlock":
				return (new Warlock(name, lvl, xp));
			case "Warrior":
				return (new Warrior(name, lvl, xp));
		}
		return (null);
	}
}
