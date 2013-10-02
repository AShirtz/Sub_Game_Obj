import java.util.Set;

import com.example.SubGameObj.GameController;
import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

public class TestCases {

	
	public static void main(String... args) {
		GameController controller = new GameController();
		controller.createEnemyShip(500,500);
		//controller.createEnemyShip(500,500);
		Set <Ship> ships = controller.getGameMap().getmActiveShips();
		for (Ship ship : ships) {
			if (ship.getClass().equals(EnemyShip.class)) {
				((EnemyShip)ship).fireWeapon();
			}
		}
		for (int i = 0; i <= 20; i++) {
			controller.onTurn();
		}
	}
}


/*
TODO:
1. Do the movement thing, make ships have a destination, and make them move towards their destination every turn
2. Ships respond to Events accordingly, REDO


DONE: 
1. make sure the onTurn() method is correctly making it to the right objects
2. make it that Events are removed after one turn of being active
3. have weapons be removed after they are detonated

5. Whenever a Ship, Event, or Weapon is created it is registered with the GameMap singleton
6. Have explosions reduce the health of the ship caught in them
7. have ships with no health be removed from game
*/