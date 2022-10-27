package com.school42.swingy.window;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.*;

public abstract class AbstractWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public AbstractWindow(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setResizable(false);
		setLayout(null);
	}

	protected void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(
			dim.width / 2 - getSize().width / 2,
			dim.height / 2 - getSize().height / 2
		);
	}

	protected void createSeparator(int sens, Point pos, int width) {
		JSeparator separator = new JSeparator();
		getContentPane().add(separator);
		separator.setOrientation(sens);
		if (sens == SwingConstants.HORIZONTAL) {
			separator.setBounds((int)pos.getX(), (int)pos.getY(), width, 10);
		} else {
			separator.setBounds((int)pos.getX(), (int)pos.getY(), 100, width);
		}
	}

}
