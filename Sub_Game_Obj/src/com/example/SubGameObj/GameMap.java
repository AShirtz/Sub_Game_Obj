package com.example.SubGameObj;


import java.util.HashSet;
import java.util.Set;

import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Event.Event;
import com.example.SubGameObj.Utils.ObjectListener;
import com.example.SubGameObj.Utils.Position;
import com.example.SubGameObj.Weapon.Weapon;


/**
 * This class represents the Map on which Ships and Events occur.
 * This is also the entry point for the onTurn method and holds the set of ships and events.
 * Generic T holds the Object type that will be the canvas for drawing.
 * @author anshirtz
 *
 */
public class GameMap implements ObjectListener {
	
	private Set <Ship> mActiveShips = null;
	private Set <Weapon> mWeaponsActive = null;
	private Set <Event> mCurrentEvents = null;
	
	private Set <Ship> shipsToRemove = null;
	private Set <Weapon> weaponsToRemove = null;
	
	public static int xSize = 0;
	public static int ySize = 0;
	
	public static GameMap instance = null;
	
	public static GameMap getInstance () {
		return instance;
	}
	
	public static GameMap createInstance(int width, int height) {
		if (instance == null) {
			instance = new GameMap(width, height);
		}
		return instance;
	}
	
	protected static void destroyGame () {
		instance = null;
	}
	
	private GameMap (int width, int height) {
		GameMap.xSize = width;
		GameMap.ySize = height;
		this.mActiveShips = new HashSet<Ship>();
		this.mCurrentEvents = new HashSet<Event>();
		this.mWeaponsActive = new HashSet<Weapon>();
		this.shipsToRemove = new HashSet<Ship>();
		this.weaponsToRemove = new HashSet<Weapon>();
	}
	
	protected void onTurn () {
		synchronized (this) {
			this.purgeSets();
			this.weaponOnTurn();
			this.shipOnTurn();
			this.eventActions();
		}
	}

	private void purgeSets() {
		this.mCurrentEvents.removeAll(mCurrentEvents);
		this.mActiveShips.removeAll(shipsToRemove);
		this.mWeaponsActive.removeAll(weaponsToRemove);
		this.shipsToRemove.removeAll(shipsToRemove);
		this.weaponsToRemove.removeAll(weaponsToRemove);
	}
	
	private void eventActions() {
		for (Event event : this.mCurrentEvents) {
			for (Ship ship : this.mActiveShips) {
				event.eventAction(ship);
			}
		}
	}

	private void weaponOnTurn() {
		for (Weapon weapon : this.mWeaponsActive) {
			weapon.onTurn();
		}
	}
	
	private void shipOnTurn() {
		for (Ship ship : this.mActiveShips) {
			ship.onTurn();
		}
	}
	
	protected void drawMap(ObjectDrawer objectDrawer) {
		objectDrawer.drawMap();
		for (Ship ship : this.getmActiveShips()) {
			ship.onDraw(objectDrawer);
		}
		for (Weapon weapon : this.getmWeaponsActive()) {
			weapon.onDraw(objectDrawer);
		}
		for (Event event : this.getmCurrentEvents()) {
			event.onDraw(objectDrawer);
		}
	}
	
	public Ship getShipAtPosition (Position pos) {
		Ship result = null;
		for (Ship ship : this.mActiveShips) {
			if (ship.getPosition().distanceToPos(pos) <= 20) {
				result = ship;
			}
		}
		return result;
	}
	
	/*
	 *********************
	 * Getters & Setters *
	 *********************
	 */
	
	public Set<Ship> getmActiveShips() {
		return mActiveShips;
	}

	public void setmActiveShips(Set<Ship> mActiveShips) {
		this.mActiveShips = mActiveShips;
	}

	public Set<Weapon> getmWeaponsActive() {
		return mWeaponsActive;
	}

	public void setmWeaponsActive(Set<Weapon> mWeaponsActive) {
		this.mWeaponsActive = mWeaponsActive;
	}

	public Set<Event> getmCurrentEvents() {
		return mCurrentEvents;
	}

	public void setmCurrentEvents(Set<Event> mCurrentEvents) {
		this.mCurrentEvents = mCurrentEvents;
	}
	
	/*
	 **************************
	 * ObjectListener Methods *
	 **************************
	 */
	
	@Override
	public void createShip(Ship ship) {
		synchronized (this) {
			this.mActiveShips.add(ship);
		}
	}
	
	@Override
	public void removeShip(Ship ship) {
		synchronized (this) {
			this.shipsToRemove.add(ship);
		}
	}

	@Override
	public void createEvent(Event event) {
		synchronized (this) {
			this.mCurrentEvents.add(event);
		}
	}

	@Override
	public void createWeapon(Weapon weapon) {
		synchronized (this) {
			this.mWeaponsActive.add(weapon);
		}
	}

	@Override
	public void removeWeapon(Weapon weapon) {
		synchronized (this) {
			this.weaponsToRemove.add(weapon);
		}
	}

}
