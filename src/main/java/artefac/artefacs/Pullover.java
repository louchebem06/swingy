package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Pullover extends AbstractArtefacs {
	public Pullover(double value) {
		super("armor", "Pullover", value);
	}

	public Pullover(Pullover pullover) {
		super(pullover);
	}
}
