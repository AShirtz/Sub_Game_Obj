package com.example.SubGameObj.Weapon;

import com.example.SubGameObj.ObjectDrawer;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

public class Torpedo extends Weapon {

	private Position destination = null;
	
	public Torpedo (Position pos, Position dest, Ship creatorShip) {
		super(creatorShip);
		this.setPosition(pos);
		this.destination = dest;
	}

	@Override
	public void onTurn() {
		this.getPosition().moveToward(destination, 30);		//TODO: the '30' is speed, just for testing
		if (this.getPosition().equals(destination)) {
			this.detonate();
		}
	}

	@Override
	public void onDraw(ObjectDrawer canvasObj) {
		canvasObj.drawTorpedo(this.getPosition());
	}
	
}
