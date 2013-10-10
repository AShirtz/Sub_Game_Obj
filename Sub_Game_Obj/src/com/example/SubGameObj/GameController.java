package com.example.SubGameObj;

// This is Dan
import java.util.Date;
import java.util.Random;

import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.PlayerControlledSubmarine;
import com.example.SubGameObj.Entity.Submarine;

public class GameController {

	private GameMap gameMap = null;
	private GamePointer pointer = null;
	
	public GameMap getGameMap() {
		return gameMap;
	}
	public void setpointer(GamePointer gamepointer){
		if (pointer.getSelected() == PlayerControlledSubmarine.getInstance()) {
			//TODO: enter movement commands
		} 
		else {
			pointer = gamepointer;
		} 
	} 

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public GameController() {
		gameMap = GameMap.getInstance();
	}
	
	public void onTurn() {
		this.gameMap.onTurn();
	}
	
	public void createPlayerSub () {
		Random rand = new Random(new Date().getTime());
		int xPos = rand.nextInt(gameMap.xSize);
		int yPos = rand.nextInt(gameMap.ySize);
	}
	
	public void createPlayerSub (int x, int y) {
		new Submarine(x, y);
	}
	
	public void createEnemyShip() {
		Random rand = new Random(new Date().getTime());
		int xPos = rand.nextInt(gameMap.xSize);
		int yPos = rand.nextInt(gameMap.ySize);
		createEnemyShip(xPos, yPos);
	}
	
	public void createEnemyShip(int xPos, int yPos) {
		new EnemyShip(xPos, yPos);
	}
}
