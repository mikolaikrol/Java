package characters;

import util.CharacterHasWrongStrengthOrHealthException;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * a Player class
 */
public class Player extends Character {
	
	public Player(int healthPoints, int strengthPoints, int gold, String name) throws CharacterHasWrongStrengthOrHealthException {
		super(healthPoints, strengthPoints, gold, name);
	}

	public Player(int healthPoints, int strengthPoints, String name) throws CharacterHasWrongStrengthOrHealthException {
		super(healthPoints, strengthPoints,0, name); // Les joueurs commencent à 0 d'or.
	}
	
}
