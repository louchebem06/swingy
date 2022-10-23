package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Knife extends AbstractArtefacs {
	public Knife(double value) {
		super("weapon", "Knife", value);
	}

	public Knife(Knife knife) {
		super(knife);
	}
}
