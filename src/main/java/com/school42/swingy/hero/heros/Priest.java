package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Priest extends AbstractHero implements Hero {
	public Priest(String name, int lvl, double xp) {
		super(name,
				"Priest",
				0.5,
				0.2,
				1.0,
				lvl,
				xp,
				10.5,
				4.0,
				1.0);
	}

	public Priest clone() {
		Priest hero = new Priest(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
