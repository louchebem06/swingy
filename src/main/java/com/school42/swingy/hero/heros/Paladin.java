package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Paladin extends AbstractHero implements Hero {
	public Paladin(String name, int lvl, double xp) {
		super(name,
				"Paladin",
				0.1,
				0.1,
				0.1,
				lvl,
				xp,
				4.9,
				3.9,
				4.9);
	}

	public Paladin clone() {
		Paladin hero = new Paladin(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
