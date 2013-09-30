package com.example.SubGameObj.Event;

import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Utils.Position;

/**
 * This class represents an explosion caused by the detonation of either a torpedo or depth charge.
 * @author anshirtz
 *
 */
public class Explosion extends Event <Health>{
	
	public Explosion(Position pos) {
		super(pos);
		new Sound(pos);
	}

	/**
	 * Returns the Health of the ship responding to this event.
	 * @param Ship - The ship responding to this event.
	 * @return Integer - The health of the ship.
	 * @author anshirtz
	 */
	@Override
	public Health eventAction(Ship ship) {
		return ship.receiveDamage(10);	//TODO: the '10' is currently arbitrary, make it a variable
	}
}
