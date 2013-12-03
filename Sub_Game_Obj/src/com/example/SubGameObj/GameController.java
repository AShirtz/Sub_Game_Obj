package com.example.SubGameObj;

import java.util.Date;
import java.util.Random;

import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Submarine;
import com.example.SubGameObj.Utils.Position;

public class GameController {
	
	private static GameController instance = null;
	
	private ObjectDrawer mObjectDrawer = null;
	
	private GameMap gameMap = null;
	private Submarine playerSub = null;
	
	public static GameController getInstance (ObjectDrawer objectDrawer, int width, int height) {
		if (instance == null) {
			instance = new GameController(objectDrawer, width, height);
		}
		return instance;
	}

	private GameController (ObjectDrawer objectDrawer, int width, int height) {
		this.gameMap = GameMap.createInstance(width, height);
		this.mObjectDrawer = objectDrawer;
	}
	
	public GameMap getGameMap() {
		return gameMap;
	}
	
	public void setPointer(Position pos){
		GamePointer gamePointer = new GamePointer();
		gamePointer.setPosition(pos);
		gamePointer.setSelected(this.gameMap.getShipAtPosition(pos));
		if (gamePointer.getSelected() != null && gamePointer.getSelected().getClass().equals(EnemyShip.class)) {
			this.playerSub.fireTorpedo(gamePointer.getSelected().getPosition());
		} 
		else {
			this.playerSub.setDestination(gamePointer.getPosition());
		} 
	}
	
	public void createPlayerSub () {
		this.playerSub = new Submarine();
		this.playerSub.setPosition(new Position(this.gameMap.xSize /2, this.gameMap.ySize /2));
	}
	
	public Submarine getPlayerSub () {
		return this.playerSub;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public void onTurn() {
		this.createEnemies();
		this.gameMap.onTurn();
	}
	
	private void createEnemies() {
		if (this.gameMap.getmActiveShips().size() <= 6) {	//This means that there will be 5 EnemyShips and the 1 playerSub
			Random rand = new Random(new Date().getTime());
			for (int n = rand.nextInt(7); n > 0; n--) {
				this.createEnemyShip();
			}
		}
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
		try {
			mObjectDrawer.prepareDrawer();
			this.gameMap.drawMap(mObjectDrawer);
		} finally {
			mObjectDrawer.postChanges();

		}
	}
	
	public static void destroyGame () {
		instance = null;
		GameMap.destroyGame();
	}
}
