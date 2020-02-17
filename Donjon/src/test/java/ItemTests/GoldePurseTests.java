package ItemTests;

import org.junit.Test;

import items.DirectBonusItem;
import items.GoldPurse;
import util.BadParametersForThisItemException;

public class GoldePurseTests extends DirectBonusItemTests{

	@Override
	public DirectBonusItem createDirectBonusItem() throws BadParametersForThisItemException {
		return new GoldPurse(10);
	}

	@Override @Test(expected=BadParametersForThisItemException.class)
	public void testConstructorWithBadParameters() throws BadParametersForThisItemException {
		new GoldPurse(-5);
	}

}
