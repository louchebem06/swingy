package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Lighter extends AbstractArtefacs {
	public Lighter(double value) {
		super("weapon", "Lighter", value);
	}

	public Lighter(Lighter lighter) {
		super(lighter);
	}
}
