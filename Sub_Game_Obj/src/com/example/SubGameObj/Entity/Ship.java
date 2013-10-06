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
		System.out.print("Ship: " + this.toString() + " onTurn.\n");	//TODO: Just for testing, may be abstract
		if (this.mDestination != null && !this.mPosition.equals(mDestination)) {
			this.setPosition(mPosition.moveToward(mDestination, 30));	//TODO: the '30' is the speed at which the ship will move
			System.out.print("Position: " + this.getPosition().getX() + ", " + this.getPosition().getY() + "\n");
		}
	}
	
	
	/**
	 * This method is a hook for the AI to know of a specific position on the map.
	 * @param pos
	 */
	public void notifyOfPosition (Position pos) {
		
	}
	
	/**
	 * Determines whether or not the ship should react to the event, as determined by the distance between the event and the ship.
	 * @param event
	 * @return Object (Position if SonarPing, Health if Explosion) or null if distance is greater than the events radius
	 */
	
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
