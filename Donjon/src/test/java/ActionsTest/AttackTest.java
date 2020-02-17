package ActionsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;
import actions.Attack;
import characters.Character;
import characters.Monster;
import characters.Player;
import items.GoldPurse;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;

public class AttackTest extends ActionTest {

	@Override
	protected Action createAction() {
		return Attack.getInstance();
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
	public void testExecuteWorksWell() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException { // On teste si le monstre et le joueur ont perdu des hp
		MyMockAttack mockAttack = new MyMockAttack();
		Player player = new Player(100,20,0,"Louis");
		int beforeAttackMonsterHP = this.monster.getHealthPoints();
		int beforeAttackPlayerHP = player.getHealthPoints();
		mockAttack.execute(player, ItemAndMonsterRoom, this.monster);
		assertEquals(beforeAttackMonsterHP-player.getStrengthPoints(), this.monster.getHealthPoints());
		assertEquals(beforeAttackPlayerHP-this.monster.getStrengthPoints(), player.getHealthPoints());
	}
	
	@Test
	public void testExecuteWhenMonsterDies() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException {
		int nbItemsBeforeDeath = this.ItemAndMonsterRoom.getItems().size();
		int goldMonster = this.monster.getGoldCarried();
		GoldPurse droppedItem = new GoldPurse(goldMonster);
		MyMockAttack mockAttack = new MyMockAttack();
		Player player = new Player(100,20,0,"Louis");
		this.monster.setHealthPoints(1);
		mockAttack.execute(player, ItemAndMonsterRoom, this.monster);
		int nbItemsAfterDeath = this.ItemAndMonsterRoom.getItems().size();
		assertEquals(nbItemsBeforeDeath+1, nbItemsAfterDeath);
		assertTrue(this.ItemAndMonsterRoom.getItems().contains(droppedItem));
		assertFalse(this.ItemAndMonsterRoom.getMonsters().contains(monster));
	}
	
	
	
	
	// MOCK ATTACK pour tester sans inputs, on passe en parametre de execute ce qu'on est censé récupérer avec selectFromList avec l'input
	public class MyMockAttack{
		
		public MyMockAttack() {};
		
		public void execute(Character c, Room r, Monster m) throws BadParametersForThisItemException { // on ajoute le Monster en paramètre
			c.battleOneRound(m, r);
		}
		
	}
		
		

}
