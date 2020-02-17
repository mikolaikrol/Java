package ItemTests;

import org.junit.Test;

import items.DirectBonusItem;
import items.StrengthPotion;
import util.BadParametersForThisItemException;

public class StrengthPotionTests extends DirectBonusItemTests{

	@Override
	public DirectBonusItem createDirectBonusItem() throws BadParametersForThisItemException {
		return new StrengthPotion(10);
	}
	
	@Override @Test(expected=BadParametersForThisItemException.class)
	public void testConstructorWithBadParameters() throws BadParametersForThisItemException {
		new StrengthPotion(-5);
	}

}
