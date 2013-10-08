package com.example.SubGameObj.Event;

import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Utils.Position;

/**
 * This class represents an explosion caused by the detonation of either a torpedo or depth charge.
 * @author anshirtz
 *
 */
public class Explosion extends Event {
	
	private int damage = 10;
	
	public Explosion(Position pos) {
		super(pos);
		new Sound(pos);
	}
	
	/**
	 * Returns the Health of the ship responding to this event.
	 * @param Ship - The ship responding to this event.
	 * @author anshirtz
	 */
	@Override
	public void eventAction (Ship ship) {
		super.eventAction(ship);
		ship.receiveDamage(this.damage);
	}

	@Override
	public void onDraw() {
		// TODO Auto-generated method stub
		
	}
}
