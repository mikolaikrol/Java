package actions;
import characters.Character;
import characters.Player;
import items.Item;
import rooms.Room;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * the action Use
 */
public class Use extends Action {

	private static final Use INSTANCE = new Use();
	
	/**
	 * Private constructor for the singleton
	 */
	private Use() {}
	
	/**
	 * @return the unique instance of action Use
	 */
	public static Use getInstance() {
		return Use.INSTANCE;
	}
	
	/**
	 * @param r room to test
	 * @return true if there is one or many items in the room, false if not
	 */
	@Override
	public boolean isPossible(Room r) {
		return r.hasItems();
	}
	
	/**
	 * @param c character who use an item
	 * @param r room where the action take place
	 * The player chose an item to use, and the chosen item's effect apply to the player
	 */
	@Override
	public void execute(Character c, Room r) {
		Item toUse = selectFromMenu(r.getItems(), "Select the item you want to use:");
		toUse.use((Player) c, r);
		r.getItems().remove(toUse);
	}
	
	@Override
	public String toString() {
		return "Use";
	}
}
