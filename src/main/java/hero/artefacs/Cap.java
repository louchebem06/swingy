package main.java.hero.artefacs;

import main.java.hero.AbstractArtefacs;

public class Cap extends AbstractArtefacs {
	public Cap(double value) {
		super("helm", "Cap", value);
	}

	public Cap(Cap cap) {
		super(cap);
	}
}
