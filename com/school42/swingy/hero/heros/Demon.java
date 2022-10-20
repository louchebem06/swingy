package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Demon extends AbstractHero {
	public Demon(String name, int lvl, double xp) {
		super(name,
				"Demon",
				0.5,
				0.2,
				1.0,
				lvl,
				xp,
				3.5,
				5.8,
				2.0);
	}

	public Demon(Demon demon) {
		super (demon);
	}
}
