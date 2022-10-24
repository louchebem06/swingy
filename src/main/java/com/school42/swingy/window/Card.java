package com.school42.swingy.window;

import java.awt.Point;

import javax.swing.JPanel;

import java.awt.Dimension;

public class Card extends AbstractWidgetWindow {

	private JPanel _panel = (JPanel)getContentPane();
	
	public Card(Point pos, Dimension size) {
		super("Card", 500, 500);
		placeRightUp(pos, size);

		setVisible(true);
	}

}
