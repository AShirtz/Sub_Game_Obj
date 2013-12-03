package com.example.SubGameObj.Utils;

import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Event.Event;
import com.example.SubGameObj.Weapon.Weapon;

public interface ObjectListener {
	public void createEvent (Event event);
	public void createShip (Ship ship);
	public void removeShip (Ship ship);
	public void createWeapon (Weapon weapon);
	public void removeWeapon (Weapon weapon);
}
