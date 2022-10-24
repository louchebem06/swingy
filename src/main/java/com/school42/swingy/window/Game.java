package com.school42.swingy.window;

import java.awt.Point;

public class Game extends AbstractWindow {

	public Game(Point point) {
		super("Game", 500, 440);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		placeHere(point);

		setVisible(true);
	}
	
}
