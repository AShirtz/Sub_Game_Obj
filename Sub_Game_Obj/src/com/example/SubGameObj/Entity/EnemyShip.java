package com.example.SubGameObj.Entity;

import com.example.SubGameObj.ObjectDrawer;
import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Weapon.DepthCharge;
import com.example.SubGameObj.Weapon.Weapon;

public class EnemyShip extends Ship {
	
	private static final int enemyShipDefaultHealth = 20;
	
	public EnemyShip () {
		super();
		this.setHealth(Health.fullHealth(enemyShipDefaultHealth));
	}

	public EnemyShip(int xPos, int yPos) {
		super(xPos, yPos);
		this.setHealth(Health.fullHealth(enemyShipDefaultHealth));
	}
	
	public Weapon fireWeapon() {
		return new DepthCharge(this.getPosition().clone(), 10, this); 	//TODO: this is for simple testing purposes, the second int is the timer.
	}

	@Override
	public void onDraw(ObjectDrawer objectDrawer) {
		objectDrawer.drawEnemyShip(this.getPosition());
	}

}
