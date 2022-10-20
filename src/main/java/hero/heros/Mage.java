package main.java.hero.heros;

import main.java.hero.AbstractHero;

public class Mage extends AbstractHero {
	public Mage(String name, int lvl, double xp) {
		super(name,
				"Mage",
				1.5,
				1.2,
				2.0,
				lvl,
				xp,
				15.5,
				3.8,
				3.0);
	}

	public Mage(Mage mage) {
		super (mage);
	}
}
