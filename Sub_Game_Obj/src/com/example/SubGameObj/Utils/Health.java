package com.example.SubGameObj.Utils;

/**
 * This class represents the health of a Ship entity, designed to be replaced later if need be.
 * @author anshirtz
 *
 */
public class Health {

	private int health;
	private static final int defaultHealth = 20;
	
	public static Health fullHealth() {
		return new Health(defaultHealth);
	}
	
	public static Health fullHealth(int setHealth) {
		return new Health(setHealth);
	}
	
	public static boolean isDestroyed(Health health) {
		return (health.getHealth() <= 0) ? true : false;		//TODO: this method is implementation specific to the int model of health
	}
	
	public void reduceHealth (int value) {
		this.health -= value;
	}
	
	private Health(int health) {
		this.setHealth(health);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}
