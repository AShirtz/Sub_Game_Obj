package com.example.SubGameObj.Weapon;

import com.example.SubGameObj.GameMap;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Event.Explosion;
import com.example.SubGameObj.Utils.ObjectController;
import com.example.SubGameObj.Utils.ObjectListener;
import com.example.SubGameObj.Utils.Position;

public abstract class Weapon implements ObjectController {

	private Position mPosition = null;
	protected ObjectListener listener = null;
	private Ship creatorShip = null;
	
	public Weapon(Ship creatorShip) {
		this.listener = GameMap.getInstance();
		this.listener.createWeapon(this);
		this.creatorShip = creatorShip;
	}

	public Position getPosition() {
		return mPosition;
	}

	public void setPosition(Position mPosition) {
		this.mPosition = mPosition;
	}
	
	public abstract void onTurn ();
	
	public void detonate () {
		new Explosion(this.getPosition(), creatorShip);
		this.listener.removeWeapon(this);
	}
}
