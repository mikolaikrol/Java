package GameTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import characters.Player;
import game.AdventureGame;
import rooms.ExitRoom;
import rooms.Room;
import util.CharacterHasWrongStrengthOrHealthException;
import util.Direction;
import util.DirectionAlreadyAssignedException;
import util.NoRoomInThisDirectionException;

public class AdventureGameTests {
	
	private Player player;
	private Room r1;
	private Room r2;
	private Room r3;
	private AdventureGame game;
	
	@Before
	public void before() throws DirectionAlreadyAssignedException, CharacterHasWrongStrengthOrHealthException {
		this.player = new Player(100, 10, "Sébastien");
		this.r1 = new Room();
		this.r2 = new ExitRoom();
		this.r3 = new Room();
		this.game = new AdventureGame(r1);
		game.setPlayer(this.player);
		this.r1.addNeighborRoom(r3, Direction.NORTH);
	}
	
	@Test
	public void testIsDeadWhenPlayerAliveInClassicRoom() {
		assertFalse(this.game.isFinished());
	}
	
	@Test
	public void testIsDeadWhenPlayerDead() {
		this.player.setHealthPoints(0);
		assertTrue(this.game.isFinished());
	}
	
	@Test
	public void testIsDeadWhenPlayerAliveInExitRoom() {
		this.game.setCurrentRoom(r2);
		assertTrue(this.game.isFinished());
	}
	
	@Test
	public void playerChangedRoomWhenMovedToCorrectDirection() throws NoRoomInThisDirectionException {
		this.game.playerMoveTo(Direction.NORTH);
		assertEquals(this.r3, this.game.getCurrentRoom());
	}
	
	@Test(expected = NoRoomInThisDirectionException.class)
	public void playerMoveToBadDirectionThrowsException() throws NoRoomInThisDirectionException {
		this.game.playerMoveTo(Direction.EAST);
	}
	
	
}
