package com.example.SubGameObj.Weapon;

import com.example.SubGameObj.Event.Event;
import com.example.SubGameObj.Utils.Position;

public abstract class Weapon {

	private Position mPosition = null;

	public Position getPosition() {
		return mPosition;
	}

	public void setPosition(Position mPosition) {
		this.mPosition = mPosition;
	}
	
	public abstract Event onTurn ();
}
