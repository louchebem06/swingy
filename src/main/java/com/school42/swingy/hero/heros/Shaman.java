package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Shaman extends AbstractHero implements Hero {
	public Shaman(String name, int lvl, double xp) {
		super(name,
				"Shaman",
				1.0,
				1.0,
				1.0,
				lvl,
				xp,
				6.0,
				6.0,
				6.0);
	}

	public Shaman clone() {
		Shaman hero = new Shaman(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
