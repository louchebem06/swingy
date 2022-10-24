package com.school42.swingy.window;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JFrame;

public abstract class AbstractWindow extends JFrame {

	private static Vector<AbstractWindow> _windows = new Vector<AbstractWindow>();

	public AbstractWindow(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setResizable(false);
		setLayout(null);
		_windows.add(this);
	}

	public void disposeAll() {
		while (_windows.size() > 0) {
			_windows.get(0).dispose();
			_windows.remove(0);
		}
	}

	protected void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(
			dim.width / 2 - getSize().width / 2,
			dim.height / 2 - getSize().height / 2
		);
	}

	protected void centerScreenDown() {
		centerScreen();
		setLocation(getLocation().x, getLocation().y + getHeight() / 2);
	}

	protected void placeRight(Point pos, Dimension dim) {
		setLocation((int)(pos.getX() + dim.getWidth()), (int)pos.getY());
	}

	protected void placeRightUp(Point pos, Dimension dim) {
		placeRight(pos, dim);
		setLocation(getLocation().x, getLocation().y - getHeight() / 2);
	}

	protected void placeLeft(Point pos, Dimension dim) {
		setLocation((int)(pos.getX() - getSize().getWidth()), (int)pos.getY());
	}

	protected void placeLeftUp(Point pos, Dimension dim) {
		placeLeft(pos, dim);
		setLocation(getLocation().x, getLocation().y - getHeight() / 2);
	}

	protected void placeLeftLeftUp(Point pos, Dimension dim) {
		placeLeftUp(pos, dim);
		setLocation(getLocation().x - getWidth() + 100, getLocation().y);
	}

	protected void placeUp(Point pos, Dimension dim) {
		setLocation((int)pos.getX(), (int)(pos.getY() - getSize().getHeight()));
	}

	protected void placeHere(Point pos) {
		setLocation((int)pos.getX(), (int)pos.getY());
	}

	protected Point getPoint() { return (getLocation()); }

	protected Dimension getDimension() { return (getSize()); }

}
