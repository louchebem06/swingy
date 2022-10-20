package com.school42.swingy.hero;

import com.school42.swingy.hero.artefacs.*;

public class ArtefacsFactory {
	public static Artefacs newArtefacs(String type, double value) {
		switch (type) {
			case "Sword":
				return (new Sword(value));
		}
		return (null);
	}

	private static Artefacs random(String items[], double maxRand) {
		int rand = (int)(Math.random() * items.length);
		double value = Math.random() * maxRand;

		return (newArtefacs(items[rand], value));
	}

	public static Artefacs randomWeapon(double maxRand) {
		String types [] = {"Sword"};
		
		return (random(types, maxRand));
	}

	public static Artefacs randomArmor(double maxRand) {
		String types [] = {};
		
		return (random(types, maxRand));
	}

	public static Artefacs randomHelm(double maxRand) {
		String types [] = {};
		
		return (random(types, maxRand));
	}
}
