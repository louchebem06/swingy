package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Shaman extends AbstractHero {
	public Shaman(String name, int lvl, double xp) {
		super(name,
				"Shaman",
				1.0,
				1.0,
				1.0,
				lvl,
				xp,
				4.0,
				4.0,
				4.0);
	}

	public Shaman(Shaman shaman) {
		super (shaman);
	}
}
