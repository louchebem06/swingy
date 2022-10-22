package main.java;

public class Cordonate {
	
	private int _x, _y;
	
	public Cordonate() {}
	public Cordonate(int x, int y) {
		_x = x;
		_y = y;
	}
	public Cordonate(Cordonate position) {
		_x = position._x;
		_y = position._y;
	}

	public void setX(int x) { _x = x; }
	public void setY(int y) { _y = y; }

	public int getX() { return (_x); }
	public int getY() { return (_y); }

}
