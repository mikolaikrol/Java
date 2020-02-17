package RoomsTest;

import static org.junit.Assert.*;

import rooms.ExitRoom;
import rooms.Room;

public class ExitRoomTest extends RoomTest {
	
	public Room createRoom() {
		return new ExitRoom();
	}
	
	@Override
	public void testIsExit() {
		assertTrue(this.room.isExit());
	}
	
}
