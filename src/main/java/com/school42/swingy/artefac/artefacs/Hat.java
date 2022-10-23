package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Hat extends AbstractArtefacs {
	public Hat(double value) {
		super("helm", "Hat", value);
	}

	public Hat(Hat hat) {
		super(hat);
	}
}
