package com.example.SubGameObj.Utils;

import com.example.SubGameObj.GameMap;

public class Position implements Cloneable {

	private int posX;
	private int posY;
	
	public Position (int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Position clone () {
		Position result = null;
		try {
			result =  (Position) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return result;
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
	
	public void moveToward (Position dest, int speed) {
		if (!this.equals(dest)) {
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
			this.setX(this.getX() + newX);
			this.setY(this.getY() + newY);
		}
	}
	
	public double distanceToPos(Position otherPos) {
		return (this.equals(otherPos)) ? 0.0 : Math.sqrt(((this.getX() - otherPos.getX()) * (this.getX() - otherPos.getX())) + ((this.getY() - otherPos.getY()) * (this.getY() - otherPos.getY())));
	}

	public int getX() {
		return posX;
	}

	public void setX(int posX) {
		if (posX > GameMap.xSize) {
			this.posX = GameMap.xSize;
		} else {
			this.posX = posX;
		}
	}

	public int getY() {
		return posY;
	}

	public void setY(int posY) {
		if (posY > GameMap.ySize) {
			this.posY = GameMap.ySize;
		} else {
			this.posY = posY;
		}
	}
	
	@Override
	public String toString() {
		String result = "";
		result += this.posX;
		result += ", ";
		result += this.posY;
		return result;
	}
}
