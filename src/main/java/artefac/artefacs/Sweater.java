package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Sweater extends AbstractArtefacs {
	public Sweater(double value) {
		super("armor", "Sweater", value);
	}

	public Sweater(Sweater sweater) {
		super(sweater);
	}
}
