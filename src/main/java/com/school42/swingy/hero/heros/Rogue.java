package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Rogue extends AbstractHero implements Hero {
	public Rogue(String name, int lvl, double xp) {
		super(name,
				"Rogue",
				1.0,
				0.2,
				0.5,
				lvl,
				xp,
				2.0,
				4.43,
				7.5);
	}

	public Rogue clone() {
		Rogue hero = new Rogue(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
