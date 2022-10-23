package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Gun extends AbstractArtefacs {
	public Gun(double value) {
		super("weapon", "Gun", value);
	}

	public Gun(Gun gun) {
		super(gun);
	}
}
