package com.example.SubGameObj.Entity;

import com.example.SubGameObj.Utils.Health;

public class Submarine extends Ship {

	private static final int submarineDefaultHealth = 100;
	
	public Submarine() {
		this.setmHealth(Health.fullHealth(submarineDefaultHealth));
	}

}
