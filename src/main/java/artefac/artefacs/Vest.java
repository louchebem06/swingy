package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Vest extends AbstractArtefacs {
	public Vest(double value) {
		super("armor", "Vest", value);
	}

	public Vest(Vest vest) {
		super(vest);
	}
}
