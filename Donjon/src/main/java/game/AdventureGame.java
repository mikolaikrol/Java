package game;

import characters.Monster;
import characters.Player;
import items.Item;
import rooms.Room;
import util.BadParametersForThisItemException;
import util.Direction;
import util.NoRoomInThisDirectionException;
import actions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * Class to manage a dungeon game
 */
public class AdventureGame {
	
	private Player player;
	private Room currentRoom;
	
	
	/**
	 * Build an adventure game which starts in the given room
	 * @param startingRoom starting room
	 */
	public AdventureGame(Room startingRoom) {
		this.currentRoom = startingRoom;
	}
	
	/**
	 * @return the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * @param currentRoom the currentRoom to set
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * @param p player to set
	 */
	public void setPlayer(Player p) {
		this.player = p;
	}
	
	
	/**
	 * add a monster in a room
	 * @param monster the monster to add
	 * @param room the room in which we add the monster
	 */
	public void addMonster(Monster monster, Room room) {
		room.getMonsters().add(monster);
	}
	
	/**
	 * add an item to a room
	 * @param item the item to add
	 * @param room the room in which we add the item
	 */
	public void addItem(Item item, Room room) {
		room.getItems().add(item);
	}
	
	/**
	 * @param direction the direction the player move
	 * @throws NoRoomInThisDirectionException if the player move to a non existing position
	 */
	public void playerMoveTo(Direction direction) throws NoRoomInThisDirectionException {
		int idx = this.currentRoom.getAvailableDirections().indexOf(direction);
		if (idx == -1) {
			throw new NoRoomInThisDirectionException();
		}
		else {
			this.setCurrentRoom(this.currentRoom.getNeighborRooms().get(idx));
		}
	}
	
	/**
	 * @return true if the game is finished (player dead or in an exit room), false otherwise
	 */
	public boolean isFinished() {
		if (this.player.isDead()) {
			System.out.println("you loose !");
			return true;
		}
		else if (this.getCurrentRoom().isExit()) {
			System.out.println(this.player + " finds the exit of the dungeon !");
			System.out.println("you won !");
			return true;
		}
		return false;
	}
	
	/**
	 * @param AllActions The list of all the actions
	 * @param r the current room
	 * @return A list of all the actions that are possible
	 */
	public List<Action> getPossibleActions(List<Action> AllActions, Room r){
		List<Action> possible = new ArrayList<Action>();
		for (Action action : AllActions) {
			if (action.isPossible(r)) {
				possible.add(action);
			}
		}
		return possible;
	}
	
	/**
	 * @param player the main character that the user will control
	 * @throws NoRoomInThisDirectionException if during the game the player move to a non existing direction (can't happen)
	 * @throws BadParametersForThisItemException if bad item
	 */
	public void play(Player player) throws NoRoomInThisDirectionException, BadParametersForThisItemException {
		this.player = player;
		Action chosen;
		List<Action> AllActions = new ArrayList<>();
		AllActions.add(Look.getInstance());
		AllActions.add(Attack.getInstance());
		AllActions.add(Move.getInstance());
		AllActions.add(Use.getInstance());
		// On commence la  boucle
		while (!this.isFinished()) {
			List<Action> possibleActions = this.getPossibleActions(AllActions, this.currentRoom);
			System.out.println("------------------------------------------------------------------");
			chosen = Action.selectFromMenu(possibleActions, this.player+" select an action:");
			chosen.execute(this.player, this.currentRoom);
			if (chosen instanceof Move) {
				Move move = ((Move) chosen);
				this.playerMoveTo(move.getChosenDirection());
				move.resetChosenDirection();
			}
		}
		// boucle terminée, jeu fini
		System.out.println("The game is over.");
	}
	
	
}
