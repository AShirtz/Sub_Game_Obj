package com.example.SubGameObj.Entity;

import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Utils.Position;
import com.example.SubGameObj.Weapon.Torpedo;

public class Submarine extends Ship {

	private static final int submarineDefaultHealth = 100;
	
	public Submarine(int xPos, int yPos) {
		super(xPos, yPos);
		this.setmHealth(Health.fullHealth(submarineDefaultHealth));
	}
	
	public void fireTorpedo (Position destination) {
		new Torpedo(this.getPosition(), destination);
	}

}
