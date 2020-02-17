import characters.*;
import game.AdventureGame;
import items.*;
import rooms.*;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;
import util.Direction;
import util.DirectionAlreadyAssignedException;
import util.NoRoomInThisDirectionException;


/**
 * @author Bart Sébastien and Krol Mikolaï
 * Main class for dungeon project
 */

public class DungeonMain {

	public static void main(String[] args) throws DirectionAlreadyAssignedException, NoRoomInThisDirectionException, CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException {
		// player playing
		Player p = new Player(100, 10, "Sébastien");
		
		// init AdventureGame
		Room startingRoom = new Room();
		AdventureGame game = new AdventureGame(startingRoom);
		
		// creating the donjon rooms and assembling them
		Room r1 = new Room();
		startingRoom.addNeighborRoom(r1, Direction.NORTH);
		Room r2 = new Room();
		r1.addNeighborRoom(r2, Direction.EAST);
		Room r3 = new Room();
		r2.addNeighborRoom(r3, Direction.NORTH);
		Room r4 = new Room();
		r3.addNeighborRoom(r4, Direction.WEST);
		ExitRoom exit = new ExitRoom();
		r3.addNeighborRoom(exit, Direction.EAST);
		Room r5 = new Room();
		r2.addNeighborRoom(r5, Direction.SOUTH);
		
		// adding items to the rooms
		// starting room
		OneArmedBandit bdManchot = new OneArmedBandit(300);
		bdManchot.addPossiblePrize(new HealthPotion(300));
		bdManchot.addPossiblePrize(new StrengthPotion(200));
		game.addItem(new GoldPurse(50), startingRoom);
		game.addItem(new MysteryPotion(-20, 30, -20 , 30), startingRoom);
		game.addItem(bdManchot, startingRoom);
		// r1
		game.addItem(new HealthPotion(20), r1);
		game.addItem(new StrengthPotion(10), r1);
		// r2
		game.addItem(new Steroids(-20, 15), r2);
		game.addItem(new GoldPurse(20), r2);
		// r3
		game.addItem(new StrengthPotion(15), r3);
		// r4
		game.addItem(new HealthPotion(30), r4);
		// r5 
		game.addItem(new MysteryPotion(-5, 15, 0, 10), r5);
		
		
		
		
		// adding Monsters
		// r1
		game.addMonster(new Monster(50, 10, 25, "Orc"), r1);
		// r3
		game.addMonster(new Monster(70, 20, 50, "Troll"), r3);
		// r4
		game.addMonster(new Monster(80, 15, 60, "Cyclope"), r4);
		// r5
		game.addMonster(new Monster(25, 40, 100, "Diablotin"), r5);
				
		// play
		game.play(p);
	}

}
