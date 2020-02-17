package actions;
import characters.Character;
import rooms.Room;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * the action Look
 */
public class Look extends Action {
	
	private static final Look INSTANCE = new Look();
	
	/**
	 * Private constructor for the singleton
	 */
	private Look() {}
	
	/**
	 * @return the unique instance of action look
	 */
	public static Look getInstance() {
		return Look.INSTANCE;
	}

	/**
	 * @param r room to test
	 * @return always true
	 */
	@Override
	public boolean isPossible(Room r) {
		return true; // The look method is always possible
	}
	
	/**
	 * @param c character who look
	 * @param r room to look in 
	 * Display the description of the room
	 */
	@Override
	public void execute(Character c, Room r) {
		r.description();
	}
	
	@Override
	public String toString() {
		return "Look";
	}

}
