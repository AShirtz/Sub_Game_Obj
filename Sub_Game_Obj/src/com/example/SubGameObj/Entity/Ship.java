package com.example.SubGameObj.Entity;

import com.example.SubGameObj.GameMap;
import com.example.SubGameObj.Event.Event;
import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Utils.ObjectListener;
import com.example.SubGameObj.Utils.Position;

public abstract class Ship {

	private Position mPosition = null;
	private Health mHealth = null;
	private Position mDestination = null;
	
	private ObjectListener listener = null;
	
	public Ship(int xPos, int yPos) {
		this.setPosition(new Position(xPos, yPos));
		this.listener = GameMap.getInstance();
		this.listener.createShip(this);
	}
	
	public void onTurn () {
		System.out.print("Ship: " + this.toString() + " onTurn.\n");	//TODO: Just for testing, will be abstract
		if (!this.mPosition.equals(mDestination)) {
			this.setPosition(mPosition.moveToward(mDestination, 10));	//TODO: the '10' is the speed at which the ship will move
			System.out.print("Position: " + this.getPosition().getX() + ", " + this.getPosition().getY() + "\n");
		}
	}
	
	/**
	 * Determines whether or not the ship should react to the event, as determined by the distance between the event and the ship.
	 * @param event
	 * @return Object (Position if SonarPing, Health if Explosion) or null if distance is greater than the events radius
	 */
	public Object respondToEvent(Event event) {
		if (this.getPosition().distanceToPos(event.getPosition()) < event.getRadius()) {
			System.out.print("Ship: " + this.toString() + " responding to Event: " + event.toString() + "\n");
			return event.eventAction(this);
		}
		return null;
	}
	
	public Health receiveDamage (int damage) {
		this.getmHealth().reduceHealth(damage);
		if (this.isDestroyed()) {
			this.listener.removeShip(this);
			System.out.print("Removing Ship: " + this.toString() + "\n");
		}
		return this.getmHealth();
	}
	
	public boolean isDestroyed() {
		return this.getmHealth().isDestroyed();
	}

	public Position getPosition() {
		return mPosition;
	}

	public void setPosition(Position mPosition) {
		this.mPosition = mPosition;
	}
	
	public Health getmHealth() {
		return mHealth;
	}

	public void setmHealth(Health mHealth) {
		this.mHealth = mHealth;
	}

	public Position getDestination() {
		return mDestination;
	}

	public void setDestination(Position mDestination) {
		this.mDestination = mDestination;
	}
}
