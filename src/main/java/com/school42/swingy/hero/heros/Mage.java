package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Mage extends AbstractHero implements Hero {
	public Mage(String name, int lvl, double xp) {
		super(name,
				"Mage",
				1.5,
				1.2,
				2.0,
				lvl,
				xp,
				15.5,
				3.8,
				3.0);
	}

	public Mage clone() {
		Mage hero = new Mage(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
