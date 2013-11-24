package com.example.SubGameObj.Tests;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

import com.example.SubGameObj.GameController;
import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Entity.Submarine;
import com.example.SubGameObj.Utils.Position;
import com.example.SubGameObj.Weapon.Torpedo;

public class UnitTests {
	
	private static final int defaultNumTests = 10;
	
	public static void main(String... args) {
		runTests(defaultNumTests);
	}
	
	public static void runTests () {
		runTests(defaultNumTests);
	}
	
	public static void runTests (int numOfTests) {
		try {
			//new UnitTests.TestCase.shipMoveTest(numOfTests, numOfTests).runTest();
			//new UnitTests.TestCase.subTorpedoTest(numOfTests, numOfTests).runTest();
			//new UnitTests.TestCase.EnemyShipDepthChargeTest(numOfTests, numOfTests).runTest();
			//new UnitTests.TestCase.MixedTest(numOfTests, numOfTests).runTest();
			new UnitTests.TestCase.DrawTest(numOfTests, numOfTests).runTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static abstract class TestCase implements Callable<Boolean> {
		
		protected int maxNumOfTurns = 0;
		protected int numOfShips = 0;
		protected String name = "";
		
		public TestCase (int maxNumOfTurns, int numOfShips) {
			this.maxNumOfTurns = maxNumOfTurns;
			this.numOfShips = numOfShips;
		}
		
		protected void runTest() throws Exception {
			if (this.call()) {
				System.out.print("Test: " + this.name + " passed\n");
			} else {
				System.out.print("Test: " + this.name + " failed\n");
			}
		}
		
		protected static class shipMoveTest extends TestCase {
			
			public shipMoveTest(int maxNumOfTurns, int numOfShips) {
				super(maxNumOfTurns, numOfShips);
				this.name = "shipMoveTest";
			}

			@Override
			public Boolean call() throws Exception {
				GameController controller = GameController.getInstance(new ObjectDrawerTestImpl());
				Random rand = new Random(new Date().getTime());
				for (int index = 0; index < numOfShips; index++) {
					controller.createEnemyShip();
				}
				Map<Ship, Position> results = new HashMap<Ship, Position>(numOfShips);
				for (Ship ship : controller.getGameMap().getmActiveShips()) {
					Position randDest = new Position(rand.nextInt(controller.getGameMap().xSize), rand.nextInt(controller.getGameMap().ySize));
					ship.setDestination(randDest);
					results.put(ship, randDest);
				}
				for (int index = 0; index < maxNumOfTurns; index++) {
					controller.onTurn();
				}
				for (Map.Entry<Ship, Position> entry : results.entrySet()) {
					if (!entry.getKey().getPosition().equals(entry.getValue())) {
						GameController.destroyGame();
						return false;
					}
				}
				GameController.destroyGame();
				return true;
			}
		}
		
		protected static class subTorpedoTest extends TestCase {

			public subTorpedoTest(int maxNumOfTurns, int numOfShips) {
				super(maxNumOfTurns, numOfShips);
				this.name = "subTorpedoTest";
			}

			@Override
			public Boolean call() throws Exception {
				GameController controller = GameController.getInstance(new ObjectDrawerTestImpl());
				Random rand = new Random(new Date().getTime());
				for (int index = 0; index < numOfShips; index++) {
					controller.createSubmarine();
				}
				for (Ship ship : controller.getGameMap().getmActiveShips()) {
					Position randDest = new Position(rand.nextInt(controller.getGameMap().xSize), rand.nextInt(controller.getGameMap().ySize));
					((Submarine)ship).fireTorpedo(randDest);
				}
				for (int index = 0; index < maxNumOfTurns; index++) {
					controller.onTurn();
				}
				GameController.destroyGame();
				return true;
			}
		}
		
		protected static class EnemyShipDepthChargeTest extends TestCase {		//This test is dependent on the fact that two depth charges will destroy an EnemyShip, if that changes, the test will fail
			
			public EnemyShipDepthChargeTest(int maxNumOfTurns, int numOfShips) {
				super(maxNumOfTurns, numOfShips);
				this.name = "shipDestroyTest";
			}

			@Override
			public Boolean call() throws Exception {
				GameController controller = GameController.getInstance(new ObjectDrawerTestImpl());
				for (int index = 0; index < numOfShips; index++) {
					controller.createEnemyShip();
				}
				for (Ship ship : controller.getGameMap().getmActiveShips()) {
					((EnemyShip)ship).fireWeapon();
					((EnemyShip)ship).fireWeapon();
				}
				for (int index = 0; index < maxNumOfTurns; index++) {
					controller.onTurn();
				}
				for (Ship ship : controller.getGameMap().getmActiveShips()) {
					if (!ship.isDestroyed()) {
						GameController.destroyGame();
						return false;
					}
				}
				GameController.destroyGame();
				return true;
			}
		}
		
		protected static class MixedTest extends TestCase {
			
			public MixedTest(int maxNumOfTurns, int numOfShips) {
				super (maxNumOfTurns, numOfShips);
				this.name = "MixedTest";
			}

			@Override
			public Boolean call() throws Exception {
				GameController controller = GameController.getInstance(new ObjectDrawerTestImpl());
				Random rand = new Random(new Date().getTime());
				for (int index = 0; index < (numOfShips/2); index++) {
					controller.createEnemyShip();
					controller.createSubmarine();
				}
				for (Ship ship : controller.getGameMap().getmActiveShips()) {
					ship.setDestination(new Position(rand.nextInt(controller.getGameMap().xSize), rand.nextInt(controller.getGameMap().ySize)));
					if (ship.getClass().equals(EnemyShip.class)) {
						((EnemyShip)ship).fireWeapon();
					} else if (ship.getClass().equals(Submarine.class)) {
						((Submarine)ship).fireTorpedo(new Position(rand.nextInt(controller.getGameMap().xSize), rand.nextInt(controller.getGameMap().ySize)));
					}
				}
				for (int index = 0; index < maxNumOfTurns; index++) {
					controller.onTurn();
				}
				GameController.destroyGame();
				return true;
			}
		}
		
		protected static class DrawTest extends TestCase {
			
			public DrawTest(int maxNumOfTurns, int numOfShips) {
				super (maxNumOfTurns, numOfShips);
				this.name = "MixedTest";
			}

			@Override
			public Boolean call() throws Exception {
				GameController controller = GameController.getInstance(new ObjectDrawerTestImpl());
				Random rand = new Random(new Date().getTime());
				for (int index = 0; index < (numOfShips/2); index++) {
					controller.createEnemyShip();
					controller.createSubmarine();
				}
				for (Ship ship : controller.getGameMap().getmActiveShips()) {
					ship.setDestination(new Position(rand.nextInt(controller.getGameMap().xSize), rand.nextInt(controller.getGameMap().ySize)));
					if (ship.getClass().equals(EnemyShip.class)) {
						((EnemyShip)ship).fireWeapon();
					} else if (ship.getClass().equals(Submarine.class)) {
						((Submarine)ship).fireTorpedo(new Position(rand.nextInt(controller.getGameMap().xSize), rand.nextInt(controller.getGameMap().ySize)));
					}
				}
				for (int index = 0; index < maxNumOfTurns; index++) {
					controller.onTurn();
					controller.drawGame();
				}
				GameController.destroyGame();
				return true;
			}
		}
	}
	
}


/*
TODO:


DONE: 
1. make sure the onTurn() method is correctly making it to the right objects
2. make it that Events are removed after one turn of being active
3. have weapons be removed after they are detonated
4. Do the movement thing, make ships have a destination, and make them move towards their destination every turn
5. Whenever a Ship, Event, or Weapon is created it is registered with the GameMap singleton
6. Have explosions reduce the health of the ship caught in them
7. have ships with no health be removed from game
8. Ships need a notifyOfPosition(Position) method, this is a hook for the game to feed info to the AI 
9. SonarPing needs to have a reference back to it's ship, then call NotifyOfPosition(Position) method
10. Ships respond to Events accordingly, REDO; ask events to affect ships, 
	that way a 
		Sound can: tell the ship of it's position
		Explosion can: tell the ship to be damaged
		SonarPing can: ask the ship for it's position
11. (FIXED) Error: Ship and the weapons they fired shared the same position object.
12. Add a destroyGame() method to the GameController, that resets the game board.
*/