package com.school42.swingy.artefac.artefacs;

import com.school42.swingy.artefac.AbstractArtefacs;

public class Pullover extends AbstractArtefacs {
	public Pullover(double value) {
		super("armor", "Pullover", value);
	}

	public Pullover(Pullover pullover) {
		super(pullover);
	}
}
