package characters;

import items.GoldPurse;
import items.Item;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * a Monster class
 */
public class Monster extends Character {

	public Monster(int healthPoints, int strengthPoints, int gold, String name) throws CharacterHasWrongStrengthOrHealthException {
		super(healthPoints, strengthPoints,gold, name);
	}
	
	@Override
	public void deathEffect(Room r) throws BadParametersForThisItemException {
		super.deathEffect(r);
		Item droppedItem = new GoldPurse(this.goldCarried);
		r.getItems().add(droppedItem);
		r.getMonsters().remove(this);
		System.out.println("It dropped "+droppedItem);
	}

}
