package com.example.SubGameObj;

// This is Dan
import java.util.Date;
import java.util.Random;

import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Entity.Submarine;
import com.example.SubGameObj.Utils.Position;

public class GameController<T extends EnemyShip, S extends Submarine> {
	
	private static GameController instance = null;
	
	private Class <T> mEnemyShipClass = null;
	private Class <S> mSubClass = null;
	
	private GameMap gameMap = null;
	private GamePointer pointer = null;
	
	public static GameController getInstance (Class<?> enemyClass, Class<?> subClass) {
		if (instance == null) {
			instance = new GameController(enemyClass, subClass);
		}
		return instance;
	}

	private GameController (Class<T> enemyClass, Class<S> subClass) {
		this.gameMap = GameMap.getInstance();
		this.mEnemyShipClass = enemyClass;
		this.mSubClass = subClass;
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
		try {
			mSubClass.newInstance().setPosition(new Position(xPos, yPos));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void createEnemyShip() {
		Random rand = new Random(new Date().getTime());
		int xPos = rand.nextInt(gameMap.xSize);
		int yPos = rand.nextInt(gameMap.ySize);
		createEnemyShip(xPos, yPos);
	}
	
	public void createEnemyShip(int xPos, int yPos) {
		try {
			mEnemyShipClass.newInstance().setPosition(new Position(xPos, yPos));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void drawGame () {
		this.gameMap.drawMap(null);
	}
	
	public static void destroyGame () {
		instance = null;
		GameMap.destroyGame();
	}
}
