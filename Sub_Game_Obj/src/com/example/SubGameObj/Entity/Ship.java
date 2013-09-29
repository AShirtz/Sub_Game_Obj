package com.example.SubGameObj.Entity;

import com.example.SubGameObj.Event.Event;
import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Utils.Position;

public abstract class Ship {

	private Position mPosition = null;
	private Health mHealth = null;
	
	/**
	 * Determines whether or not the ship should react to the event, as determined by the distance between the event and the ship.
	 * @param event
	 * @return Object (Position if SonarPing, Health if Explosion) or null if distance is greater than the events radius
	 */
	public Object respondToEvent(Event event) {
		if (this.getPosition().distanceToPos(event.getPosition()) < event.getRadius()) {
			return event.eventAction(this);
		}
		return null;
	}
	
	public Health receiveDamage (int damage) {
		this.getmHealth().reduceHealth(damage);
		return this.getmHealth();
	}
	
	public boolean isDestroyed() {
		return Health.isDestroyed(this.getmHealth());
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
}
