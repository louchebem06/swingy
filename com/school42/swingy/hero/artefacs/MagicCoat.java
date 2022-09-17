package com.school42.swingy.hero.artefacs;

import com.school42.swingy.hero.AbstractArtefacs;

public class MagicCoat extends AbstractArtefacs {
	public MagicCoat() {
		super("armor", "MagicCoat", 12.0);
	}

	public MagicCoat(MagicCoat magiccoat) {
		super(magiccoat);
	}
}
