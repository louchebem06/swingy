package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Monk extends AbstractHero implements Hero {
	public Monk(String name, int lvl, double xp) {
		super(name,
				"Monk",
				0.4,
				0.1,
				0.2,
				lvl,
				xp,
				4.0,
				3.9,
				8.8);
	}

	public Monk clone() {
		Monk hero = new Monk(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
