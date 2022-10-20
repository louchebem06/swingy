package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Monk extends AbstractHero {
	public Monk(String name, int lvl, double xp) {
		super(name,
				"Monk",
				0.4,
				0.1,
				0.2,
				lvl,
				xp,
				4.6,
				4.9,
				4.8);
	}

	public Monk(Monk monk) {
		super (monk);
	}
}
