package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.*;

public class Knight extends AbstractHero implements Hero {
	public Knight(String name, int lvl, double xp) {
		super(name,
				"Knight",
				1.3,
				0.1,
				1.1,
				lvl,
				xp,
				3.1,
				4.34,
				3.22);
	}

	public Knight clone() {
		Knight hero = new Knight(this.getName(), this.getLevel(), this.getXp());
		hero.setArtefac(getArmor(), true);
		hero.setArtefac(getWeapon(), true);
		hero.setArtefac(getHelm(), true);
		return (hero);
	}
}
