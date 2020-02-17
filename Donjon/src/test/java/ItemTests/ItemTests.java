package ItemTests;

import org.junit.Before;

import characters.Player;
import game.AdventureGame;
import items.Item;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;

public abstract class ItemTests {
	
	protected Item item;
	protected Player p;
	protected Room r;
	protected AdventureGame game;
	
	public abstract Item createItem() throws BadParametersForThisItemException;
	
	@Before
	public void before() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException {
		this.p = new Player(100, 20, 10, "Jeanpetikidanse");
		this.item = this.createItem();
		this.r = new Room();
		this.game = new AdventureGame(this.r);
		game.addItem(this.item, r);
	}

}
