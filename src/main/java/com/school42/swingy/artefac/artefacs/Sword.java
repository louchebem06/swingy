package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Sword extends AbstractArtefacs {
	public Sword(double value) {
		super("weapon", "Sword", value);
	}

	public Sword(Sword sword) {
		super(sword);
	}
}
