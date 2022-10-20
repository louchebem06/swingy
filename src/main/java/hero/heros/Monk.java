package main.java.hero.heros;

import main.java.hero.AbstractHero;

public class Monk extends AbstractHero {
	public Monk(String name, int lvl, double xp) {
		super(name,
				"Monk",
				0.4,
				0.1,
				0.2,
				lvl,
				xp,
				4.0,
				3.9,
				8.8);
	}

	public Monk(Monk monk) {
		super (monk);
	}
}
