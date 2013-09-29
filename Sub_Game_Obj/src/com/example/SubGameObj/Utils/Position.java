package com.example.SubGameObj.Utils;

public class Position {

	private int posX;
	private int posY;
	
	public Position (int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(Position.class)) {
			if (((Position)obj).getX() == this.getX() && ((Position)obj).getY() == this.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public double distanceToPos(Position otherPos) {
		return (this.equals(otherPos)) ? 0.0 : Math.sqrt(((this.getX() - otherPos.getX()) * (this.getX() - otherPos.getX())) + ((this.getY() - otherPos.getY()) * (this.getY() - otherPos.getY())));
	}

	public int getX() {
		return posX;
	}

	public void setX(int posX) {
		this.posX = posX;
	}

	public int getY() {
		return posY;
	}

	public void setY(int posY) {
		this.posY = posY;
	}
}
