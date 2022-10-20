package main.java.hero.heros;

import main.java.hero.AbstractHero;

public class Knight extends AbstractHero {
	public Knight(String name, int lvl, double xp) {
		super(name,
				"Knight",
				1.3,
				0.1,
				1.1,
				lvl,
				xp,
				3.1,
				4.34,
				3.22);
	}

	public Knight(Knight knight) {
		super (knight);
	}
}
