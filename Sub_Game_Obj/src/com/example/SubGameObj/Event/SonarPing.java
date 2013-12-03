package com.example.SubGameObj.Event;

import com.example.SubGameObj.ObjectDrawer;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

/**
 * This class represents a 'Ping' of active sonar by a ship.
 * @author anshirtz
 *
 */
public class SonarPing extends Event {
	

	public SonarPing(Position pos, Ship creatorShip) {
		super(pos, creatorShip);
		new Sound(pos, creatorShip);
	}

	/**
	 * This method notifies the ship that was 'hit' with the sonar ping and creates a Sound object as though the ship
	 * that was 'hit' created it. This allows the ship that created the SonarPing to react to the Sound.
	 * @param Ship - the ship that is responding to the event.
	 * @author anshirtz
	 */
	@Override
	public void eventAction (Ship ship) {
		if (this.shouldAffectShip(ship)) {
			ship.notifyOfEvent(this);
			new Sound(ship.getPosition(), ship);
		}
	}

	@Override
	public void onDraw(ObjectDrawer canvasObj) {
		canvasObj.drawSonarPing(this.getPosition());
	}
}
