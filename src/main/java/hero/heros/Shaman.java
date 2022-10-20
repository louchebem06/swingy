package main.java.hero.heros;

import main.java.hero.AbstractHero;

public class Shaman extends AbstractHero {
	public Shaman(String name, int lvl, double xp) {
		super(name,
				"Shaman",
				1.0,
				1.0,
				1.0,
				lvl,
				xp,
				6.0,
				6.0,
				6.0);
	}

	public Shaman(Shaman shaman) {
		super (shaman);
	}
}
