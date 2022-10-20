package com.school42.swingy.simulator;

import com.school42.swingy.hero.Hero;

public class Simulator {
	static double aAttack,  aDefense, aHP;
	static double bAttack, bDefense, bHP;

	private static void attack(double aaAttack, double aaDefense, double aaHP,
								double bbAttack, double bbDefense, double bbHP,
								boolean first)
	{
		if (aaAttack < bbDefense)
			bbHP -= 0.01;
		else
			bbHP -= (aaAttack - bbDefense);
		if (bbHP > 0.0) {
			if (bbAttack < aaDefense)
				aaHP -= 0.01;
			else
				aaHP -= (bbAttack - aaDefense);
		}

		if (first) {
			aAttack = aaAttack;
			aDefense = aaDefense;
			aHP = aaHP;
			bAttack = bbAttack;
			bDefense = bbDefense;
			bHP = bbHP;
		} else {
			bAttack = aaAttack;
			bDefense = aaDefense;
			bHP = aaHP;
			aAttack = bbAttack;
			aDefense = bbDefense;
			aHP = bbHP;
		}
	}
	
	// Return true if A Win and return false if A Loose
	public static Boolean figth(Hero a, Hero b) {
		aAttack = a.getAttack();
		aDefense = a.getDefense();
		aHP = a.getHitPoint();
		bAttack = b.getAttack();
		bDefense = b.getDefense();
		bHP = b.getHitPoint();

		boolean first = run();
		while (true) {
			if (first) {
				attack(aAttack, aDefense, aHP, bAttack, bDefense, bHP, first);
			} else {
				attack(bAttack, bDefense, bHP, aAttack, aDefense, aHP, first);
			}
			if (aHP <= 0.0 || bHP <= 0.0)
				break ;
		}
		return (aHP > bHP);
	}

	// Run is possible
	public static Boolean run() {
		return (Math.random() >= 0.5);
	}

}
