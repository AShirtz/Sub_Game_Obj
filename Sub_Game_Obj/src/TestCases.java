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
			ship.setDestination(new Position(500, 100));
		}
		for (int i = 0; i <= 50; i++) {
			controller.onTurn();
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
*/