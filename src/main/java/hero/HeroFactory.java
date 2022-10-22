package main.java.hero;

import main.java.hero.heros.*;

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

	private static String randomPseudo() {
		String pseudos [] = {
			"BurgerMamba", "PorteGama", "BloodNova", "SniperRaptor",
			"LuckDiabete", "PaperMoi", "BadTruck", "OneWar", "FireCloud",
			"SkyOne", "WolfWar", "SwordFr", "JackpotGodzilla", "RiverPrincess",
			"SunriseFreedom", "ShieldFire", "PredatorBlue", "OxygeneShadow",
			"GiveupPandora", "DocteurSnake", "GamerAura", "BeauGiveup",
			"DelaMilo", "PosePython"
		};
		int random = (int)(Math.random() * pseudos.length);
		return (pseudos[random]);
	}

	private static String randomType() {
		String types [] = {
			"Demon", "Druid", "Hunter", "Knigth", "Mage", "Monk", "Paladin",
			"Priest", "Rogue", "Shaman", "Warlock", "Warrior"
		};
		int random = (int)(Math.random() * types.length);
		return (types[random]);
	}

	private static double randomXp(double xpHero) {
		if (xpHero == 0)
			xpHero = 50;
		return (Math.random() * (xpHero * 2));
	}

	public static Hero randomHero(double xpHero) {
		Hero enemy = newHero(randomType(), randomPseudo(), 0, randomXp(xpHero));
		if (Math.random() > 0.8)
			enemy.setWeapon(ArtefacsFactory.randomWeapon(enemy.getAttack()));
		if (Math.random() > 0.8)
			enemy.setArmor(ArtefacsFactory.randomArmor(enemy.getDefense()));
		if (Math.random() > 0.8)
			enemy.setHelm(ArtefacsFactory.randomHelm(enemy.getHitPoint()));
		return (enemy);
	}
}
