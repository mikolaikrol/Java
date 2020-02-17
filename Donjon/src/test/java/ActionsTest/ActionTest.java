package ActionsTest;

import org.junit.Before;
import org.junit.Test;

import actions.Action;
import characters.Monster;
import game.AdventureGame;
import items.DirectBonusItem;
import items.GoldPurse;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;
import util.Direction;
import util.DirectionAlreadyAssignedException;

public abstract class ActionTest {
	
	protected abstract Action createAction();
	
	protected Room emptyRoom;
	protected Room ItemAndMonsterRoom;
	protected Action theAction;
	protected Monster monster;
	protected DirectBonusItem goldpurse;
	protected AdventureGame game;
	
	@Before
	public void before() throws DirectionAlreadyAssignedException, CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException {
		this.emptyRoom = new Room();
		this.ItemAndMonsterRoom = new Room();
		AdventureGame game = new AdventureGame(emptyRoom);
		this.goldpurse = new GoldPurse(10);
		game.addItem(this.goldpurse, ItemAndMonsterRoom);
		this.monster = new Monster(50,7,20,"Monstre");
		game.addMonster(this.monster, ItemAndMonsterRoom);
		this.theAction = this.createAction();
		this.emptyRoom.addNeighborRoom(ItemAndMonsterRoom, Direction.EAST);
		this.game = game;
	}
	
	@Test
	public abstract void testIsPossibleReturnsTrue();
	
	@Test
	public abstract void testIsPossibleReturnsFalse();
	
	@Test
	public abstract void testExecuteWorksWell() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException;
	
}
