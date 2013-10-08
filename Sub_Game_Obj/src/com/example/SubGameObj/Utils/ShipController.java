package com.example.SubGameObj.Utils;

public interface ShipController {
	public void setDestination(Position destination);
	public void setHealth(Health health);
	public Health getHealth();
	public void setPosition(Position pos);
	public Position getPosition();
}
