package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Warlock extends AbstractHero implements Hero {
	public Warlock(String name, int lvl, double xp) {
		super(name,
				"Warlock",
				1.5,
				2.2,
				2.0,
				lvl,
				xp,
				0.5,
				4.8,
				3.0);
	}

	public Warlock clone() {
		Warlock hero = new Warlock(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
