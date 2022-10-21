package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Hat extends AbstractArtefacs {
	public Hat(double value) {
		super("helm", "Hat", value);
	}

	public Hat(Hat hat) {
		super(hat);
	}
}
