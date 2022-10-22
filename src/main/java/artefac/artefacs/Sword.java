package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Sword extends AbstractArtefacs {
	public Sword(double value) {
		super("weapon", "Sword", value);
	}

	public Sword(Sword sword) {
		super(sword);
	}
}
