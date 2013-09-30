package com.example.SubGameObj.Weapon;

import com.example.SubGameObj.GameMap;
import com.example.SubGameObj.Event.Event;
import com.example.SubGameObj.Utils.ObjectListener;
import com.example.SubGameObj.Utils.Position;

public abstract class Weapon {

	private Position mPosition = null;
	protected ObjectListener listener = null;
	
	public Weapon() {
		this.listener = GameMap.getInstance();
		this.listener.createWeapon(this);
	}

	public Position getPosition() {
		return mPosition;
	}

	public void setPosition(Position mPosition) {
		this.mPosition = mPosition;
	}
	
	public abstract Event onTurn ();
}
