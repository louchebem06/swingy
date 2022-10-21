package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Vest extends AbstractArtefacs {
	public Vest(double value) {
		super("armor", "Vest", value);
	}

	public Vest(Vest vest) {
		super(vest);
	}
}
