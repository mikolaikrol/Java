package ActionsTest;

import static org.junit.Assert.*;

import actions.Action;
import actions.Move;
import characters.Player;
import rooms.Room;
import util.CharacterHasWrongStrengthOrHealthException;
import util.Direction;

public class MoveTest extends ActionTest {

	@Override
	protected Action createAction() {
		return Move.getInstance();
	}

	@Override
	public void testIsPossibleReturnsTrue() {
		assertTrue(this.theAction.isPossible(this.emptyRoom));
	}

	@Override
	public void testIsPossibleReturnsFalse() {
		assertFalse(this.theAction.isPossible(this.ItemAndMonsterRoom));
	}

	@Override
	public void testExecuteWorksWell() throws CharacterHasWrongStrengthOrHealthException { // on verifie qu'on a bien choisi la direction, et que player a bien bougé
		MyMockMove mockMove = new MyMockMove();
		Player player = new Player(100, 10, "Mito");
		mockMove.execute(player, this.emptyRoom, Direction.EAST);
		Direction d = this.emptyRoom.getAvailableDirections().get(0);
		assertSame(mockMove.getChosenDirection(), d);
	}
	
	
	// MOCK MOVE pour tester sans inputs, on passe en parametre de execute ce qu'on est censé récupérer avec selectFromList avec l'input
	public class MyMockMove{
		
		public MyMockMove() {};
		
		private Direction chosenDirection;
		
		public void execute(Player p, Room m, Direction d) {
			Direction chosenDirection = d;
			System.out.println("---> You moved to the " + chosenDirection);
			this.chosenDirection = chosenDirection;
		}
		
		public Direction getChosenDirection() {
			return chosenDirection;
		}
	}

}
