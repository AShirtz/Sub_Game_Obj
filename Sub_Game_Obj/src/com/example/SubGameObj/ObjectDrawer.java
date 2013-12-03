package com.example.SubGameObj;

import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Submarine;
import com.example.SubGameObj.Event.Explosion;
import com.example.SubGameObj.Utils.Position;
import com.example.SubGameObj.Weapon.DepthCharge;
import com.example.SubGameObj.Weapon.Torpedo;

/**
 * This class holds methods for drawing objects. 
 * @author anshirtz
 *
 */
public abstract class ObjectDrawer {
	
	public abstract void prepareDrawer();
	
	public abstract void postChanges();
	
	public abstract void drawMap();
	
	public abstract void drawSubmarine (Submarine sub);
	
	public abstract void drawEnemyShip (EnemyShip ship);
	
	public abstract void drawTorpedo (Torpedo torpedo);
	
	public abstract void drawDepthCharge (DepthCharge depthCharge);
	
	public abstract void drawExplosion (Explosion expolsion);
	
	public abstract void drawSound (Position pos);
	
	public abstract void drawSonarPing (Position pos);
}
