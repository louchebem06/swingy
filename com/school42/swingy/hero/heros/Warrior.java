package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Warrior extends AbstractHero {
	public Warrior(String name, int lvl, double xp) {
		super(name,
				"Warrior",
				3.5,
				3.2,
				3.0,
				lvl,
				xp,
				2.5,
				2.8,
				3.0);
	}

	public Warrior(Warrior warrior) {
		super (warrior);
	}
}
