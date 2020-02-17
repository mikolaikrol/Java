package CharactersTest;

import characters.*;
import characters.Character;
import util.CharacterHasWrongStrengthOrHealthException;

public class PlayerTest extends CharactersTest {

	@Override
	protected Character createCharacter(int healthPoints, int strengthPoints, int gold, String name) throws CharacterHasWrongStrengthOrHealthException {
		return new Player(healthPoints, strengthPoints, name);
	}

}
