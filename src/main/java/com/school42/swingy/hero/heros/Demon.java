package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Demon extends AbstractHero implements Hero {
	public Demon(String name, int lvl, double xp) {
		super(name,
				"Demon",
				0.5,
				0.2,
				1.0,
				lvl,
				xp,
				3.5,
				5.8,
				2.0);
	}

	public Hero clone() {
		Demon hero = new Demon(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
