package com.school42.swingy;

import java.util.Vector;
import java.awt.Point;

public class MapGame {

	private static int getNbEnemy(int sizeMap) {
		int nbCase = sizeMap * sizeMap;
		return ((int)(((double)(double)nbCase / (double)100) * (double)20));
	}

	public static Vector<Point> generateEnemys(int sizeMap) {
		int nbEnemy = getNbEnemy(sizeMap);
		Vector<Point> enemys = new Vector<Point>();

		for (int i = 0; i < nbEnemy; i++)
			enemys.add(new Point((int)(Math.random() * sizeMap), (int)(Math.random() * sizeMap)));
		return (enemys);
	}

}
