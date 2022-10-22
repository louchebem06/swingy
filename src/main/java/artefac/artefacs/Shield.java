package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Shield extends AbstractArtefacs {
	public Shield(double value) {
		super("armor", "Shield", value);
	}

	public Shield(Shield shield) {
		super(shield);
	}
}
