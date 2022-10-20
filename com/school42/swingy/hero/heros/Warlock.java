package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Warlock extends AbstractHero {
	public Warlock(String name, int lvl, double xp) {
		super(name,
				"Warlock",
				1.5,
				2.2,
				2.0,
				lvl,
				xp,
				0.5,
				4.8,
				3.0);
	}

	public Warlock(Warlock warlock) {
		super (warlock);
	}
}
