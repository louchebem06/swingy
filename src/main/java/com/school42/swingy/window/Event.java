package com.school42.swingy.window;

import java.awt.Dimension;
import java.awt.Point;

public class Event extends AbstractWidgetWindow {
	
	public Event(Point pos, Dimension dim) {
		super("Event", 300, 500);
		placeLeftLeftUp(pos, dim);

		setVisible(true);
	}
	
}
