package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Shield extends AbstractArtefacs {
	public Shield(double value) {
		super("armor", "Shield", value);
	}

	public Shield(Shield shield) {
		super(shield);
	}
}
