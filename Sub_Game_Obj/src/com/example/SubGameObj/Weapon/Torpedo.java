package com.example.SubGameObj.Weapon;

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
	public void onTurn() {
		this.setPosition(this.getPosition().moveToward(destination, 30));
		if (this.getPosition().equals(destination)) {
			new Explosion(this.getPosition());
		}
	}
	
}
