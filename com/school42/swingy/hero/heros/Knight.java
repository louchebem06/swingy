package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Knight extends AbstractHero {
	public Knight(String name, int lvl, double xp) {
		super(name,
				"Knight",
				1.3,
				0.1,
				1.1,
				lvl,
				xp,
				3.7,
				4.9,
				3.9);
	}

	public Knight(Knight knight) {
		super (knight);
	}
}
