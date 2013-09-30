package com.example.SubGameObj.Entity;

import com.example.SubGameObj.Utils.Health;

public class Submarine extends Ship {

	private static final int submarineDefaultHealth = 100;
	
	public Submarine(int xPos, int yPos) {
		super(xPos, yPos);
		this.setmHealth(Health.fullHealth(submarineDefaultHealth));
	}

}
