package main.java.artefac.artefacs;

import main.java.artefac.AbstractArtefacs;

public class Gun extends AbstractArtefacs {
	public Gun(double value) {
		super("weapon", "Gun", value);
	}

	public Gun(Gun gun) {
		super(gun);
	}
}
