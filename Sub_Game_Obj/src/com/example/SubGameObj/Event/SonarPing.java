package com.example.SubGameObj.Event;

import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

/**
 * This class represents a 'Ping' of active sonar by a ship.
 * @author anshirtz
 *
 */
public class SonarPing extends Event <Position> {
	
	private Ship shipWhoCreatedPing = null;

	public SonarPing(Position pos) {
		super(pos);
		new Sound(pos);
	}

	/**
	 * This method will return the position of the ship that is responding to this event.
	 * @param Ship - the ship that is responding to the event.
	 * @author anshirtz
	 */
	@Override
	public void eventAction (Ship ship) {
		super.eventAction(ship);
		shipWhoCreatedPing.notifyOfPosition(ship.getPosition());		
	}
}
