package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Warrior extends AbstractHero implements Hero {
	public Warrior(String name, int lvl, double xp) {
		super(name,
				"Warrior",
				3.5,
				3.2,
				3.0,
				lvl,
				xp,
				2.5,
				2.8,
				3.0);
	}

	public Warrior clone() {
		Warrior hero = new Warrior(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
