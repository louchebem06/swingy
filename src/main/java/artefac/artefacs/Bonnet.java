package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Bonnet extends AbstractArtefacs {
	public Bonnet(double value) {
		super("helm", "Bonnet", value);
	}

	public Bonnet(Bonnet bonnet) {
		super(bonnet);
	}
}
