package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Paladin extends AbstractHero {
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

	public Paladin(Paladin paladin) {
		super (paladin);
	}
}
