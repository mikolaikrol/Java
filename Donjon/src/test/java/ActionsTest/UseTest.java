package ActionsTest;

import static org.junit.Assert.*;

import actions.Action;
import actions.Use;
import characters.Character;
import characters.Player;
import items.Item;
import rooms.Room;
import util.CharacterHasWrongStrengthOrHealthException;

public class UseTest extends ActionTest {

	@Override
	protected Action createAction() {
		return Use.getInstance();
	}

	@Override
	public void testIsPossibleReturnsTrue() {
		assertTrue(this.theAction.isPossible(this.ItemAndMonsterRoom));
	}

	@Override
	public void testIsPossibleReturnsFalse() {
		assertFalse(this.theAction.isPossible(this.emptyRoom));
	}

	@Override
	public void testExecuteWorksWell() throws CharacterHasWrongStrengthOrHealthException {
		MyMockUse mockUse = new MyMockUse();
		Player player = new Player(100,20,0,"Louis");
		int goldBeforeUse = player.getGoldCarried();
		mockUse.execute(player, this.ItemAndMonsterRoom, this.goldpurse);
		assertEquals(player.getGoldCarried(), goldBeforeUse + this.goldpurse.getGold());
	}
	
	// MOCK USE pour tester sans inputs, on passe en parametre de execute ce qu'on est censé récupérer avec selectFromList avec l'input
	public class MyMockUse{
		
		public MyMockUse() {};
		
		public void execute(Character c, Room r, Item i) {
			Item toUse = i;
			toUse.use((Player) c, r);
			r.getItems().remove(toUse);
		}
		
	}

}
