package Phoebe;

public class Rovers {
	public Rovers(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	private int x = 0;
	private int y = 0;
	private char direction;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

}
