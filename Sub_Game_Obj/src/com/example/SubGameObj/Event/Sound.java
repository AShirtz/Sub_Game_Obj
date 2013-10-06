package com.example.SubGameObj.Event;

import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

/**
 * This class represents a sound, by engine or explosion or the like, detectable by all ships.
 * @author anshirtz
 *
 */
public class Sound extends Event<Position> {

	public Sound(Position pos) {
		super(pos);
	}
	
	@Override
	public void eventAction (Ship ship) {
		super.eventAction(ship);
		ship.notifyOfPosition(this.getPosition());
	}
}
