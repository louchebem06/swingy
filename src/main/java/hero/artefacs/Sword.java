package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Sword extends AbstractArtefacs {
	public Sword(double value) {
		super("weapon", "Sword", value);
	}

	public Sword(Sword sword) {
		super(sword);
	}
}
