package com.example.SubGameObj.Entity;

import com.example.SubGameObj.Utils.Health;

public class EnemyShip extends Ship {
	
	private static final int enemyShipDefaultHealth = 20;

	public EnemyShip() {
		this.setmHealth(Health.fullHealth(enemyShipDefaultHealth));
	}
	
}
