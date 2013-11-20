package com.example.SubGameObj.Event;

import com.example.SubGameObj.GameMap;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.ObjectController;
import com.example.SubGameObj.Utils.ObjectListener;
import com.example.SubGameObj.Utils.Position;


public abstract class Event implements ObjectController {

	private static final int defaultRadius = 50;
	
	private Position mPosition = null;
	private int radius;
	protected Ship creatorShip = null;
	
	private ObjectListener listener = null;
	
	public Event (Position pos, Ship creatorShip) {
		this.setPosition(pos);
		this.setRadius(defaultRadius);
		this.listener = GameMap.getInstance();
		this.listener.createEvent(this);
		this.creatorShip = creatorShip;
	}

	public Position getPosition() {
		return mPosition;
	}

	public void setPosition(Position mPosition) {
		this.mPosition = mPosition;
	}
	
	/**
	 * @param Ship - The ship responding to the Event.
	 * @author anshirtz
	 */
	public void eventAction (Ship ship) {
		if (ship == this.creatorShip && this.radius < this.getPosition().distanceToPos(ship.getPosition())) {
			ship.notifyOfEvent(this);
			return;		//This return statement is to stop the event from acting upon ships outside it's radius
		}
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
