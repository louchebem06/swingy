package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Pullover extends AbstractArtefacs {
	public Pullover(double value) {
		super("armor", "Pullover", value);
	}

	public Pullover(Pullover pullover) {
		super(pullover);
	}
}
