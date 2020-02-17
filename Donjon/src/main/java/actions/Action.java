package actions;
import java.util.List;

import characters.Character;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.Input;


/**
 * @author Bart Sébastien and Krol Mikolaï
 * Class to manage the player's actions (abstract)
 */
public abstract class Action {
		
	/**
	 * @param r room to test
	 * @return true if the action is possible, false otherwise
	 */
	public abstract boolean isPossible(Room r);
	
	/**
	 * Do the action
	 * @param c character who execute the action
	 * @param r room where the action take place
	 * @throws BadParametersForThisItemException if bad item
	 */
	public abstract void execute(Character c, Room r) throws BadParametersForThisItemException;
	
	// test: fonction paramétrée pour choisir un elem T parmi une liste de T
	/**
	 * @param <T> a type parameter
	 * @param theList The list of element we want to pick in
	 * @param selectMsg a message to print before showing the menu
	 * @return an object from the list
	 */
	public static <T> T selectFromMenu(List<T> theList, String selectMsg) {
		int size = theList.size();
		int i = 0;
		System.out.println(selectMsg);
		for (T elem : theList) {
			System.out.println(i + ": " + elem);
			i++;
		}
		int n = Input.readInt(size);
		return theList.get(n);
	}

}
