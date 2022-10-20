package com.school42.swingy.hero.artefacs;

import com.school42.swingy.hero.AbstractArtefacs;

public class Sword extends AbstractArtefacs {
	public Sword(double value) {
		super("weapon", "Sword", value);
	}

	public Sword(Sword sword) {
		super(sword);
	}
}
