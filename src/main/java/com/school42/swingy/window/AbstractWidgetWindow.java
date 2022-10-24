package com.school42.swingy.window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class AbstractWidgetWindow extends AbstractWindow {

	protected AbstractWidgetWindow _frame = null;
	protected boolean _open = false;

	public AbstractWidgetWindow(String title, int width, int height) {
		super(title, width, height);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		_frame = this;
		eventWindow();
	}

	private void eventWindow() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				_open = false;
			}
		});
	}

	public void toggleVisibility() {
		_open = !_open;
		_frame.setVisible(_open);
	}

	public void setActive() {
		toFront();
	}
	
}
