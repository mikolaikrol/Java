package rooms;

import java.util.ArrayList;
import java.util.List;
import characters.Monster;
import items.Item;
import util.Direction;
import util.DirectionAlreadyAssignedException;
import util.NoRoomInThisDirectionException;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * a Room class
 */
public class Room {
	
	// external room properties
	private List<Direction> availableDirections;
	private List<Room> neighborRooms;

	// inside the room properties
	private List<Monster> monsters;
	private List<Item> items;
	
	/**
	 * Constructor for Room
	 */
	public Room() {
		this.availableDirections = new ArrayList<Direction>();
		this.neighborRooms = new ArrayList<Room>();
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
	}

	/**
	 * displays a description of the room
	 */
	public void description() {
		int nbMonsters = this.monsters.size();
		int nbItems = this.items.size();
		int nbDirections = this.availableDirections.size();
		System.out.println("---> There is(are) "+ nbMonsters + " monster(s), "+ nbItems +" item(s), "+ nbDirections +" possible direction(s) in this room.");
	}

	/**
	 * @return true if the room has alive monster(s) in
	 */
	public boolean hasMonsters() {
		return !this.monsters.isEmpty();
	}
	
	/**
	 * @return the list of the monsters in the room
	 */
	public List<Monster> getMonsters(){
		return this.monsters;
	}
	
	/**
	 * @return true if there are items in the room
	 */
	public boolean hasItems() {
		return !this.items.isEmpty();
	}
	
	/**
	 * @return the list of the items in the room
	 */
	public List<Item> getItems(){
		return this.items;
	}
	
	/**
	 * @return the availableDirections
	 */
	public List<Direction> getAvailableDirections() {
		return this.availableDirections;
	}

	/**
	 * @return the neighborRooms
	 */
	public List<Room> getNeighborRooms() {
		return this.neighborRooms;
	}
	
	/**
	 * @return true if is an exit room, false otherwise
	 */
	public boolean isExit() {
		return false;
	}
	
	/**
	 * @param r the room to add
	 * @param d	the direction the room is in
	 * @throws DirectionAlreadyAssignedException if the direction added is already assigned
	 */
	public void addNeighborRoom(Room r, Direction d) throws DirectionAlreadyAssignedException {
		if(!this.availableDirections.contains(d)) {
			this.neighborRooms.add(r);
			this.availableDirections.add(d);
			r.getNeighborRooms().add(this);
			r.getAvailableDirections().add(Direction.values()[(d.ordinal()+2)%4]); // Direction opposée
		}
		else throw new DirectionAlreadyAssignedException();
	}
	
	/**
	 * @param d direction of the room we want
	 * @return the room corresponding to the given direction
	 * @throws NoRoomInThisDirectionException if the given direction is not assigned to the room
	 */
	public Room getRoomByDirection(Direction d) throws NoRoomInThisDirectionException {
		if (this.availableDirections.contains(d)) {
			int i = this.availableDirections.indexOf(d);
			return this.neighborRooms.get(i);
		}
		else throw new NoRoomInThisDirectionException();
	}
	
}
