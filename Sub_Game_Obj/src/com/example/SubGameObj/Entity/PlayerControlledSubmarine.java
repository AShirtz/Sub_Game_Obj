package com.example.SubGameObj.Entity;

import com.example.SubGameObj.Utils.Health;
import com.example.SubGameObj.Utils.PlayerController;
import com.example.SubGameObj.Utils.Position;

public class PlayerControlledSubmarine extends Submarine implements PlayerController {

	public PlayerControlledSubmarine(int xPos, int yPos) {
		super(xPos, yPos);
	}

	public void setHealth(Health health) {
		this.setHealth(health);
	}

	public Health getHealth() {
		return this.getHealth();
	}

	public void fireTorpedo(Position destination) {
		super.fireTorpedo(destination);
	}

}
