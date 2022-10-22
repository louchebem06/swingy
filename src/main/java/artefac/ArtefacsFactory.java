package main.java.artefac;

import main.java.artefac.artefacs.*;

public class ArtefacsFactory {
	public static Artefacs newArtefacs(String type, double value) {
		switch (type) {
			case "Sword":
				return (new Sword(value));
			case "Lighter":
				return (new Lighter(value));
			case "Gun":
				return (new Gun(value));
			case "Knife":
				return (new Knife(value));
			case "Shield":
				return (new Shield(value));
			case "Sweater":
				return (new Sweater(value));
			case "Pullover":
				return (new Pullover(value));
			case "Vest":
				return (new Vest(value));
			case "Cap":
				return (new Cap(value));
			case "Hat":
				return (new Hat(value));
			case "Bonnet":
				return (new Bonnet(value));
		}
		return (null);
	}

	private static Artefacs random(String items[], double maxRand) {
		int rand = (int)(Math.random() * items.length);
		double value = Math.random() * maxRand;

		return (newArtefacs(items[rand], value));
	}

	public static Artefacs randomWeapon(double maxRand) {
		String types [] = {"Sword", "Lighter", "Gun", "Knife"};
		
		return (random(types, maxRand));
	}

	public static Artefacs randomArmor(double maxRand) {
		String types [] = {"Shield", "Sweater", "Pullover", "Vest"};
		
		return (random(types, maxRand));
	}

	public static Artefacs randomHelm(double maxRand) {
		String types [] = {"Cap", "Hat", "Bonnet"};
		
		return (random(types, maxRand));
	}
}
