package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Leprechaun extends AbstractHero {
	public Leprechaun(String name, int lvl, double xp) {
		super(name,
				"Leprechaun",
				3.0,
				5.0,
				6.0,
				lvl,
				xp,
				0.75,
				11.50,
				3.21);
	}

	public Leprechaun(Leprechaun leprechaun) {
		super (leprechaun);
	}
}
