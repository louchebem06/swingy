package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Shield extends AbstractArtefacs {
	public Shield(double value) {
		super("armor", "Shield", value);
	}

	public Shield(Shield shield) {
		super(shield);
	}
}
