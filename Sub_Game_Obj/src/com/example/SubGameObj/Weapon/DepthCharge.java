package com.example.SubGameObj.Weapon;

import com.example.SubGameObj.Event.Explosion;
import com.example.SubGameObj.Utils.Position;

public class DepthCharge extends Weapon {

	private int timeToDetonation;
	
	public DepthCharge (Position pos, int timeToDetonation) {
		super();
		this.setPosition(pos);
		this.timeToDetonation = timeToDetonation;
	}
	
	@Override
	public void onTurn () {
		if (--this.timeToDetonation == 0) {
			this.listener.removeWeapon(this);
			new Explosion(this.getPosition());
		}
	}
}
