package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Mage extends AbstractHero {
	public Mage(String name, int lvl, double xp) {
		super(name,
				"Mage",
				1.5,
				1.2,
				2.0,
				lvl,
				xp,
				3.5,
				3.8,
				3.0);
	}

	public Mage(Mage mage) {
		super (mage);
	}
}
