package actions;
import characters.Character;
import rooms.Room;
import util.Direction;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * the action Move
 */
public class Move extends Action {
	
	private Direction chosenDirection;
	private static final Move INSTANCE = new Move();
	
	/**
	 * Private constructor for the singleton
	 */
	private Move() {}
	
	/**
	 * @return the unique instance of action move
	 */
	public static Move getInstance() {
		return Move.INSTANCE;
	}

	/**
	 * @return the chosenDirection
	 */
	public Direction getChosenDirection() {
		return chosenDirection;
	}

	/**
	 * Set to null chosenDirection attribute
	 */
	public void resetChosenDirection() {
		this.chosenDirection = null;
	}

	/**
	 * @param r room to test
	 * @return false if there is one or many monsters in the room, true if not
	 */
	@Override
	public boolean isPossible(Room r) {
		return !r.hasMonsters();
	}

	/**
	 * @param c character who move
	 * @param r room where the character is before the move 
	 * Move the character to an other room
	 */
	@Override
	public void execute(Character c, Room r) {
		Direction chosenDirection = selectFromMenu(r.getAvailableDirections(), "Select a direction to move to:");
		System.out.println("---> You moved to the " + chosenDirection);
		this.chosenDirection = chosenDirection;
	}
	
	@Override
	public String toString() {
		return "Move";
	}

}
