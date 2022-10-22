package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Lighter extends AbstractArtefacs {
	public Lighter(double value) {
		super("weapon", "Lighter", value);
	}

	public Lighter(Lighter lighter) {
		super(lighter);
	}
}
