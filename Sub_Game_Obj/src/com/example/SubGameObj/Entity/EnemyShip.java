package com.example.SubGameObj.Entity;

import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Weapon.DepthCharge;
import com.example.SubGameObj.Weapon.Weapon;

public class EnemyShip extends Ship {
	
	private static final int enemyShipDefaultHealth = 20;

	public EnemyShip(int xPos, int yPos) {
		super(xPos, yPos);
		this.setmHealth(Health.fullHealth(enemyShipDefaultHealth));
	}
	
	public Weapon fireWeapon() {
		return new DepthCharge(this.getPosition(), 10); 		//TODO: this is for simple testing purposes, the second int is the timer.
	}
}
