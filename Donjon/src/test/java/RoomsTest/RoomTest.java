package RoomsTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import characters.Monster;
import game.AdventureGame;
import items.GoldPurse;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;
import util.Direction;
import util.DirectionAlreadyAssignedException;
import util.NoRoomInThisDirectionException;

public class RoomTest {
	
	protected Room room;
	protected Room neighbor;
	
	protected Room createRoom() {
		return new Room();
	}
	
	@Before
	public void before() throws DirectionAlreadyAssignedException {
		this.room = this.createRoom();
		Room neighbor = new Room();
		this.neighbor = neighbor;
		this.room.addNeighborRoom(neighbor, Direction.EAST);
	}
	
	
	@Test
	public void testHasMonstersReturnsFalse() {
		assertFalse(this.room.hasMonsters());
	}
	
	@Test
	public void testHasMonstersReturnsTrue() throws CharacterHasWrongStrengthOrHealthException {
		AdventureGame game = new AdventureGame(room);
		game.addMonster(new Monster(20,5,0,"bob"), room);
		assertTrue(this.room.hasMonsters());
	}
	
	@Test
	public void testHasItemsReturnsFalse() {
		assertFalse(this.room.hasItems());
	}
	
	@Test
	public void testHasItemsReturnsTrue() throws BadParametersForThisItemException {
		AdventureGame game = new AdventureGame(room);
		game.addItem(new GoldPurse(20), room);
		assertTrue(this.room.hasItems());
	}
	
	@Test
	public void testIsExit() {
		assertFalse(this.room.isExit());
	}
	
	@Test
	public void testAddNeighborRoomIsOk() throws DirectionAlreadyAssignedException {
		Room addedRoom = new Room();
		this.room.addNeighborRoom(addedRoom, Direction.NORTH);
		assertTrue(this.room.getAvailableDirections().contains(Direction.NORTH));
		assertTrue(this.room.getNeighborRooms().contains(addedRoom));
		assertTrue(addedRoom.getAvailableDirections().contains(Direction.SOUTH));
		assertTrue(addedRoom.getNeighborRooms().contains(this.room));
	}
	
	@Test(expected = DirectionAlreadyAssignedException.class)
	public void testaddNeighborRoomThrowsException() throws DirectionAlreadyAssignedException{
		this.room.addNeighborRoom(new Room(), Direction.EAST);
	}
	
	@Test
	public void testGetRoomByDirectionIsOk() throws NoRoomInThisDirectionException {
		assertSame(this.room.getRoomByDirection(Direction.EAST), this.neighbor);
	}
	
	@Test(expected = NoRoomInThisDirectionException.class)
	public void testGetRoomByDirectionThrowsException() throws NoRoomInThisDirectionException {
		this.room.getRoomByDirection(Direction.NORTH);
	}
	
}
