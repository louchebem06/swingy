package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Druid extends AbstractHero implements Hero {
	public Druid(String name, int lvl, double xp) {
		super(name,
				"Druid",
				0.6,
				0.1,
				1.1,
				lvl,
				xp,
				4.3,
				4.3,
				3.3);
	}

	public Druid clone() {
		Druid hero = new Druid(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
