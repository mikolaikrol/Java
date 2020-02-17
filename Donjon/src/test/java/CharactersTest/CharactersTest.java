package CharactersTest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import characters.Character;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;

public abstract class CharactersTest {
	
	protected abstract Character createCharacter(int healthPoints, int strengthPoints, int gold, String name) throws CharacterHasWrongStrengthOrHealthException;
	protected Character character;
	
	@Before
	public void before() throws CharacterHasWrongStrengthOrHealthException {
		this.character = this.createCharacter(100, 15, 0, "Character");
	}
	
	// On ne teste pas les setters et getters
	
	@Test
	public void TestIsDeadReturnsFalseWhenPositiveHealthPoints() {
		assertFalse(this.character.isDead());
	}
	
	@Test
	public void TestIsDeadreturnsTrueWhenNoMoreHealthPoints() {
		this.character.setHealthPoints(0);
		assertTrue(this.character.isDead());
	}
	
	@Test
	public void testBattleOneRoundWithNoDeath() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException {
		Room r = new Room();
		Character target = this.createCharacter(100, 10, 0, "target");
		int targetHPBeforeBattle = target.getHealthPoints();
		int characterHPBeforeBattle = this.character.getHealthPoints();
		this.character.battleOneRound(target, r);
		assertEquals(this.character.getHealthPoints(), characterHPBeforeBattle-target.getStrengthPoints());
		assertEquals(target.getHealthPoints(), targetHPBeforeBattle-this.character.getStrengthPoints());
	}
	
	@Test
	public void testBattleOneRoundWhenDeath() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException { // on verifie que deathEffect est appelé
		Room r = new Room();
		MyMockCharacter mockTarget = new MyMockCharacter(10, 0, 0, "mockmock");
		this.character.battleOneRound(mockTarget, r);
		assertTrue(mockTarget.isDead());
		assertTrue(mockTarget.deathEffectApplied);
	}
	
	@Test
	public void testBattleUntilDeath() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException {
		Room r = new Room();
		Character target = this.createCharacter(100, 8, 10, "monster");
		this.character.battleUntilDeath(target, r);
		assertTrue(target.isDead());
	}
	
	@Test(expected = CharacterHasWrongStrengthOrHealthException.class)
	public void testCreateWrongHealthCharacter() throws CharacterHasWrongStrengthOrHealthException {
		this.createCharacter(-50, 10, 10, "cannot exist");
	}
	
	@Test(expected = CharacterHasWrongStrengthOrHealthException.class)
	public void testCreateWrongStrengthCharacter() throws CharacterHasWrongStrengthOrHealthException {
		this.createCharacter(50, -1, 10, "cannot exist");
	}
	
	@Test
	public void healthAndStrengthPointsEqualsZeroIfNegativePoints() {
		this.character.setHealthPoints(-10);
		this.character.setStrengthPoints(-10);
		assertEquals(0, this.character.getHealthPoints());
		assertEquals(0, this.character.getStrengthPoints());
	}
	
	// MOCK pour tester si deathEffect a été appelé
	public class MyMockCharacter extends Character {

		public MyMockCharacter(int healthPoints, int strengthPoints, int gold, String name) throws CharacterHasWrongStrengthOrHealthException {
			super(healthPoints, strengthPoints, gold, name);
			this.deathEffectApplied = false;
		}
		
		protected boolean deathEffectApplied;
		
		@Override
		public void deathEffect(Room r) {
			this.deathEffectApplied = true;
		}
		
	}
	


}