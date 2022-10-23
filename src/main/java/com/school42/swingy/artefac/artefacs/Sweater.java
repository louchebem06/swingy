package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Sweater extends AbstractArtefacs {
	public Sweater(double value) {
		super("armor", "Sweater", value);
	}

	public Sweater(Sweater sweater) {
		super(sweater);
	}
}
