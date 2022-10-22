package main.java;

import java.util.Vector;

public class MapGame {

	private static int getNbEnemy(int sizeMap) {
		int nbCase = sizeMap * sizeMap;
		return ((int)(((double)(double)nbCase / (double)100) * (double)20));
	}

	public static Vector<Cordonate> generateEnemys(int sizeMap) {
		int nbEnemy = getNbEnemy(sizeMap);
		Vector<Cordonate> enemys = new Vector<Cordonate>();

		for (int i = 0; i < nbEnemy; i++)
			enemys.add(Cordonate.randomCordonate(sizeMap));
		return (enemys);
	}

}
