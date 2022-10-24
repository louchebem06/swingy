package com.school42.swingy.window;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class AbstractWindow extends JFrame {

	protected void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(
			dim.width / 2 - getSize().width / 2,
			dim.height / 2 - getSize().height / 2
		);
	}

	protected void placeRight(Point pos, Dimension dim) {
		setLocation((int)(pos.getX() + dim.getWidth()), (int)pos.getY());
	}

	protected void placeHere(Point pos) {
		setLocation((int)pos.getX(), (int)pos.getY());
	}

	protected Point getPoint() { return (new Point(getX(), getY())); }

	protected Dimension getDimension() {
		return (new Dimension(getWidth(), getHeight()));
	}

	public AbstractWindow(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setResizable(false);
		setLayout(null);
	}

}
