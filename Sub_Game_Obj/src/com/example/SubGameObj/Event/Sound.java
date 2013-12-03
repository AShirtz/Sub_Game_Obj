package com.example.SubGameObj.Event;

import com.example.SubGameObj.ObjectDrawer;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

/**
 * This class represents a sound, by engine or explosion or the like, detectable by all ships.
 * @author anshirtz
 *
 */
public class Sound extends Event {

	public Sound(Position pos, Ship creatorShip) {
		super(pos, creatorShip);
	}
	
	@Override
	public void eventAction (Ship ship) {
		if (this.shouldAffectShip(ship)) {
			ship.notifyOfEvent(this);
		}
	}

	@Override
	public void onDraw(ObjectDrawer canvasObj) {
		canvasObj.drawSound(this.getPosition());
	}
}
