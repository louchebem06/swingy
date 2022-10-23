package com.school42.swingy;

import com.school42.swingy.hero.*;

public class Simulator {
	static double aAttack,  aDefense, aHP;
	static double bAttack, bDefense, bHP;
	
	public static Boolean figth(Hero a, Hero b) {
		while (a.isAlive() && b.isAlive()) {
			if (run()) {
				String damage = a.attack(b);
			} else {
				String damage = b.attack(a);
			}
		}
		return (a.isAlive());
	}

	public static Boolean run() {
		return (Math.random() > 0.5);
	}

}
