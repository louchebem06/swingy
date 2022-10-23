package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Hunter extends AbstractHero implements Hero {
	public Hunter(String name, int lvl, double xp) {
		super(name,
				"Hunter",
				0.2,
				0.5,
				0.9,
				lvl,
				xp,
				5.8,
				5.5,
				5.1);
	}

	public Hunter clone() {
		Hunter hero = new Hunter(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
