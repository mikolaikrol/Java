package actions;

import characters.Character;
import characters.Monster;
import rooms.Room;
import util.BadParametersForThisItemException;


/**
 * @author Bart Sébastien and Krol Mikolaï
 * the action Attack
 */
public class Attack extends Action {
	
	private static final Attack INSTANCE = new Attack();
	
	/**
	 * Private constructor for the singleton
	 */
	private Attack() {};
	
	/**
	 * @return the unique instance of action attack
	 */
	public static Attack getInstance() {
		return Attack.INSTANCE;
	}

	/**
	 * @param r room to test
	 * @return true if there is one or many monsters in the room, false if not
	 */
	@Override
	public boolean isPossible(Room r) {
		return r.hasMonsters();
	}

	/**
	 * Attack a target, and the target replies if it is not dead
	 * @param c character who execute the attack
	 * @param r room where the attack take place 
	 * @throws BadParametersForThisItemException if monster drop a wrong item
	 */
	@Override
	public void execute(Character c, Room r) throws BadParametersForThisItemException {
		Monster target = selectFromMenu(r.getMonsters(), "Select the monster you want to attack:");
		c.battleOneRound(target, r);
	}
	
	@Override
	public String toString() {
		return "Attack";
	}

}
