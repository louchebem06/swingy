package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Knife extends AbstractArtefacs {
	public Knife(double value) {
		super("weapon", "Knife", value);
	}

	public Knife(Knife knife) {
		super(knife);
	}
}
