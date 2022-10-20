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
				10.5,
				4.0,
				1.0);
	}

	public Priest(Priest priest) {
		super (priest);
	}
}
