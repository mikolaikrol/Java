package items;

import characters.Player;
import rooms.Room;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * An item interface
 */
public interface Item {
	
	/**
	 * Apply the item's effect to the player
	 * @param p the player who use the item
	 * @param r room where the item is used
	 */
	public void use(Player p, Room r); 
	
}
