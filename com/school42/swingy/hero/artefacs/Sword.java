package com.school42.swingy.hero.artefacs;

import com.school42.swingy.hero.AbstractArtefacs;

public class Sword extends AbstractArtefacs {
	public Sword() {
		super("weapon", "Sword", 5.0);
	}

	public Sword(Sword sword) {
		super(sword);
	}
}
