package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Bonnet extends AbstractArtefacs {
	public Bonnet(double value) {
		super("helm", "Bonnet", value);
	}

	public Bonnet(Bonnet bonnet) {
		super(bonnet);
	}
}
