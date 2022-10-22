package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Cap extends AbstractArtefacs {
	public Cap(double value) {
		super("helm", "Cap", value);
	}

	public Cap(Cap cap) {
		super(cap);
	}
}
