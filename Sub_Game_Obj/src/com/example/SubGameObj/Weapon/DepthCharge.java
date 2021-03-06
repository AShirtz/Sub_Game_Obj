package com.example.SubGameObj.Weapon;

import com.example.SubGameObj.ObjectDrawer;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

public class DepthCharge extends Weapon {

	private int timeToDetonation;
	
	public DepthCharge (Position pos, int timeToDetonation, Ship creatorShip) {
		super(creatorShip);
		this.setPosition(pos);
		this.timeToDetonation = timeToDetonation;
	}
	
	public int getTimeToDetonate () {
		return this.timeToDetonation;
	}
	
	@Override
	public void onTurn () {
		if (--this.timeToDetonation == 0) {
			this.detonate();
		}
	}

	@Override
	public void onDraw(ObjectDrawer canvasObj) {
		canvasObj.drawDepthCharge(this);
	}
}
