package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Rogue extends AbstractHero {
	public Rogue(String name, int lvl, double xp) {
		super(name,
				"Rogue",
				1.0,
				0.2,
				0.5,
				lvl,
				xp,
				2.0,
				4.43,
				7.5);
	}

	public Rogue(Rogue rogue) {
		super (rogue);
	}
}
