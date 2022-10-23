package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Vest extends AbstractArtefacs {
	public Vest(double value) {
		super("armor", "Vest", value);
	}

	public Vest(Vest vest) {
		super(vest);
	}
}
