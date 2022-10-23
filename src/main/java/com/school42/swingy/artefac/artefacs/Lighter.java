package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Lighter extends AbstractArtefacs {
	public Lighter(double value) {
		super("weapon", "Lighter", value);
	}

	public Lighter(Lighter lighter) {
		super(lighter);
	}
}
