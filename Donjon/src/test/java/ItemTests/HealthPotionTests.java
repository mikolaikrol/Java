package ItemTests;

import org.junit.Test;

import items.DirectBonusItem;
import items.HealthPotion;
import util.BadParametersForThisItemException;

public class HealthPotionTests extends DirectBonusItemTests{
	
	@Override
	public DirectBonusItem createDirectBonusItem() throws BadParametersForThisItemException {
		return new HealthPotion(10);
	}
	
	@Override @Test(expected=BadParametersForThisItemException.class)
	public void testConstructorWithBadParameters() throws BadParametersForThisItemException {
		new HealthPotion(-5);
	}

}
