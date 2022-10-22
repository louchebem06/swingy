package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Knife extends AbstractArtefacs {
	public Knife(double value) {
		super("weapon", "Knife", value);
	}

	public Knife(Knife knife) {
		super(knife);
	}
}
