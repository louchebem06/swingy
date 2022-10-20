package main.java.hero.heros;

import main.java.hero.AbstractHero;

public class Druid extends AbstractHero {
	public Druid(String name, int lvl, double xp) {
		super(name,
				"Druid",
				0.6,
				0.1,
				1.1,
				lvl,
				xp,
				4.3,
				4.3,
				3.3);
	}

	public Druid(Druid druid) {
		super (druid);
	}
}
