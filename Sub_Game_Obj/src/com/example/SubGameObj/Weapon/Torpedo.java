package com.example.SubGameObj.Weapon;

import com.example.SubGameObj.Event.Event;
import com.example.SubGameObj.Event.Explosion;
import com.example.SubGameObj.Utils.Position;

public class Torpedo extends Weapon {

	private Position destination = null;
	
	public Torpedo (Position pos, Position dest) {
		super();
		this.setPosition(pos);
		this.destination = dest;
	}

	@Override
	public Event onTurn() {
		return (this.getPosition().equals(this.destination)) ? new Explosion(this.getPosition()) : null;
	}
	
}
