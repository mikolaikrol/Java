package CharactersTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import characters.Character;
import characters.Monster;
import items.GoldPurse;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;

public class MonsterTest extends CharactersTest {

	@Override
	protected Character createCharacter(int healthPoints, int strengthPoints, int gold, String name) throws CharacterHasWrongStrengthOrHealthException {
		return new Monster(healthPoints, strengthPoints, gold, name);
	}
	
	@Test
	public void testDeathEffect() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException {
		Room r = new Room();
		Monster monster = new Monster(10, 0, 20, "monster");
		int monsterGold = monster.getGoldCarried();
		GoldPurse droppedItem = new GoldPurse(monsterGold);
		this.character.battleUntilDeath(monster, r);
		assertTrue(monster.isDead());
		assertTrue(r.getItems().contains(droppedItem));
	}

}
