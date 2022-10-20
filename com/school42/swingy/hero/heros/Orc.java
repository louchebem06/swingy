package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Orc extends AbstractHero {
	public Orc(String name, int lvl, double xp) {
		super(name,
				"Orc",
				5.0,
				3.0,
				2.0,
				lvl,
				xp,
				0.34,
				12.3,
				123);
	}

	public Orc(Orc orc) {
		super (orc);
	}

}
