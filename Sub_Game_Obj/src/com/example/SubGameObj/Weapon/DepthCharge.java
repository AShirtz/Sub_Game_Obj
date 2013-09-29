package com.example.SubGameObj.Weapon;

import com.example.SubGameObj.Event.Event;
import com.example.SubGameObj.Event.Explosion;
import com.example.SubGameObj.Utils.Position;

public class DepthCharge extends Weapon {

	private int timeToDetonation;
	
	public DepthCharge (Position pos, int timeToDetonation) {
		this.setPosition(pos);
		this.timeToDetonation = timeToDetonation;
	}
	
	public Event onTurn () {
		return (--this.timeToDetonation <= 0) ? new Explosion(this.getPosition()) : null;
	}
}
