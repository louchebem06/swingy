package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Priest extends AbstractHero {
	public Priest(String name, int lvl, double xp) {
		super(name,
				"Priest",
				0.5,
				0.2,
				1.0,
				lvl,
				xp,
				4.5,
				4.8,
				4.0);
	}

	public Priest(Priest priest) {
		super (priest);
	}
}
