package ItemTests;

import org.junit.Test;

import items.DirectBonusItem;
import items.MysteryPotion;
import util.BadParametersForThisItemException;

public class MysteryPotionTest extends DirectBonusItemTests {

	@Override
	public DirectBonusItem createDirectBonusItem() {
		return new MysteryPotion(-5, 5, -5, 5);
	}
	
	@Override @Test
	public void testConstructorWithBadParameters() throws BadParametersForThisItemException {
		// C'est random pas de parametres
	}
	
}
