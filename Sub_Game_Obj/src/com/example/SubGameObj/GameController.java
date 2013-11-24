package com.example.SubGameObj;

// This is Dan
import java.util.Date;
import java.util.Random;

import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Entity.Submarine;
import com.example.SubGameObj.Utils.Position;

public class GameController {
	
	private static GameController instance = null;
	
	private ObjectDrawer mObjectDrawer = null;
	
	private GameMap gameMap = null;
	private GamePointer pointer = null;
	
	public static GameController getInstance (ObjectDrawer objectDrawer) {
		if (instance == null) {
			instance = new GameController(objectDrawer);
		}
		return instance;
	}

	private GameController (ObjectDrawer objectDrawer) {
		this.gameMap = GameMap.getInstance();
		this.mObjectDrawer = objectDrawer;
	}
	
	public GameMap getGameMap() {
		return gameMap;
	}
	
	public void setpointer(GamePointer gamepointer){
		if (pointer.getSelected() == null) {
			//TODO: enter movement commands
		} 
		else {
			pointer = gamepointer;
		} 
	} 

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public void onTurn() {
		this.gameMap.onTurn();
	}
	
	public void createSubmarine () {
		Random rand = new Random(new Date().getTime());
		int xPos = rand.nextInt(gameMap.xSize);
		int yPos = rand.nextInt(gameMap.ySize);
		createSubmarine(xPos, yPos);
	}
	
	public void createSubmarine (int xPos, int yPos) {
		new Submarine().setPosition(new Position(xPos, yPos));
	}
	
	public void createEnemyShip() {
		Random rand = new Random(new Date().getTime());
		int xPos = rand.nextInt(gameMap.xSize);
		int yPos = rand.nextInt(gameMap.ySize);
		createEnemyShip(xPos, yPos);
	}
	
	public void createEnemyShip(int xPos, int yPos) {
		new EnemyShip().setPosition(new Position(xPos, yPos));
	}
	
	public void drawGame () {
		mObjectDrawer.prepareDrawer();
		this.gameMap.drawMap(mObjectDrawer);
		mObjectDrawer.postChanges();
	}
	
	public static void destroyGame () {
		instance = null;
		GameMap.destroyGame();
	}
}
