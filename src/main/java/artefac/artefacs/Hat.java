package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Hat extends AbstractArtefacs {
	public Hat(double value) {
		super("helm", "Hat", value);
	}

	public Hat(Hat hat) {
		super(hat);
	}
}
