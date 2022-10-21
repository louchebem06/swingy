package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Sweater extends AbstractArtefacs {
	public Sweater(double value) {
		super("armor", "Sweater", value);
	}

	public Sweater(Sweater sweater) {
		super(sweater);
	}
}
