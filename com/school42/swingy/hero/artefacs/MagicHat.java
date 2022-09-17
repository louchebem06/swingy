package com.school42.swingy.hero.artefacs;

import com.school42.swingy.hero.AbstractArtefacs;

public class MagicHat extends AbstractArtefacs {
	public MagicHat() {
		super("helm", "MagicHat", 3.0);
	}

	public MagicHat(MagicHat magichat) {
		super(magichat);
	}
}
