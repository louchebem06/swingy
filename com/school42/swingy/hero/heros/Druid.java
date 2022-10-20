package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Druid extends AbstractHero {
	public Druid(String name, int lvl, double xp) {
		super(name,
				"Druid",
				0.6,
				0.1,
				1.1,
				lvl,
				xp,
				4.4,
				4.9,
				3.9);
	}

	public Druid(Druid druid) {
		super (druid);
	}
}
