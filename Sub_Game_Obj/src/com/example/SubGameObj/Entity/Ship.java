package com.example.SubGameObj.Entity;

import com.example.SubGameObj.GameMap;
import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Utils.ObjectListener;
import com.example.SubGameObj.Utils.Position;
import com.example.SubGameObj.Utils.ShipController;

public abstract class Ship implements ShipController {

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
		if (this.mDestination != null && !this.mPosition.equals(mDestination)) {
			this.getPosition().moveToward(this.mDestination, 30);	//TODO: the '30' is the speed at which the ship will move
		}
	}
	
	
	/**
	 * This method is a hook for the AI to know of a specific position on the map.
	 * @param pos
	 */
	public void notifyOfPosition (Position pos) {}
	
	/**
	 * Determines whether or not the ship should react to the event, as determined by the distance between the event and the ship.
	 * @param event
	 * @return Object (Position if SonarPing, Health if Explosion) or null if distance is greater than the events radius
	 */
	
	public void receiveDamage (int damage) {
		this.getHealth().reduceHealth(damage);
		if (this.isDestroyed()) {
			this.listener.removeShip(this);
		}
	}
	
	public boolean isDestroyed() {
		return this.getHealth().isDestroyed();
	}

	@Override
	public void setDestination(Position destination) {
		this.mDestination = destination;
	}

	@Override
	public void setHealth(Health health) {
		this.mHealth = health;
	}

	@Override
	public Health getHealth() {
		return this.mHealth;
	}

	@Override
	public void setPosition(Position pos) {
		this.mPosition = pos;
	}

	@Override
	public Position getPosition() {
		return this.mPosition;
	}
}
