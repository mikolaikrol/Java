package rooms;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * an ExitRoom class, rooms which means the end of the game
 */
public class ExitRoom extends Room {

	public ExitRoom() {
		super();
	}

	@Override
	public boolean isExit() {
		return true;
	}
	
}
