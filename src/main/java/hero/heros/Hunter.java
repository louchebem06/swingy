package main.java.hero.heros;

import main.java.hero.AbstractHero;

public class Hunter extends AbstractHero {
	public Hunter(String name, int lvl, double xp) {
		super(name,
				"Hunter",
				0.2,
				0.5,
				0.9,
				lvl,
				xp,
				5.8,
				5.5,
				5.1);
	}

	public Hunter(Hunter hunter) {
		super (hunter);
	}
}
