package com.example.SubGameObj.Utils;

public interface ShipController extends ObjectController {
	public void onTurn();
	public void setDestination(Position destination);
	public void setHealth(Health health);
	public Health getHealth();
	public void setPosition(Position pos);
	public Position getPosition();
	public void receiveDamage(int damage);
}
