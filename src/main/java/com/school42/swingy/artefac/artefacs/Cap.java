package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Cap extends AbstractArtefacs {
	public Cap(double value) {
		super("helm", "Cap", value);
	}

	public Cap(Cap cap) {
		super(cap);
	}
}
