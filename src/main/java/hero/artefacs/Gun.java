package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Gun extends AbstractArtefacs {
	public Gun(double value) {
		super("weapon", "Gun", value);
	}

	public Gun(Gun gun) {
		super(gun);
	}
}
