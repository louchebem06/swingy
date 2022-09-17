package com.school42.swingy.hero.heros;

import com.school42.swingy.hero.AbstractHero;

public class Orc extends AbstractHero {
	public Orc(String name) {
		super(name, "Orc", 5.0, 3.0, 2.0);
	}

	public Orc(Orc orc) {
		super (orc);
	}
}
