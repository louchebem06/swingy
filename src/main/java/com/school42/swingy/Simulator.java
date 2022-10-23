package com.school42.swingy;

import com.school42.swingy.hero.*;

public class Simulator {
	
	public static Boolean figth(Hero a, Hero b) {
		while (a.isAlive() && b.isAlive()) {
			if (run())
				a.attack(b);
			else
				b.attack(a);
		}
		return (a.isAlive());
	}

	public static Boolean run() {
		return (Math.random() > 0.5);
	}

}
