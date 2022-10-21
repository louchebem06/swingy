package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Bonnet extends AbstractArtefacs {
	public Bonnet(double value) {
		super("helm", "Bonnet", value);
	}

	public Bonnet(Bonnet bonnet) {
		super(bonnet);
	}
}
