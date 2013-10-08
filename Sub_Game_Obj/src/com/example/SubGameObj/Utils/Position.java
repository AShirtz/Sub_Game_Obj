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
	
	public Position moveToward (Position dest, int speed) {
		if (this.equals(dest)) {
			return this;
		}
		Position result = null;
		double ratio;
		if (speed < this.distanceToPos(dest)) {
			ratio = (speed / this.distanceToPos(dest));
		} else {
			ratio = 1.0;
		}
		int deltaX = (dest.getX() - this.getX());
		int deltaY = (dest.getY() - this.getY());
		int newX = (int) Math.round(ratio * deltaX);
		int newY = (int) Math.round(ratio * deltaY);
		result = new Position ((this.getX() + newX), (this.getY() + newY));
		return result;
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
