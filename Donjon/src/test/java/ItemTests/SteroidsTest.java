package ItemTests;

import org.junit.Test;

import ItemTests.DirectBonusItemTests;
import items.DirectBonusItem;
import items.Steroids;
import util.BadParametersForThisItemException;

public class SteroidsTest extends DirectBonusItemTests {

	@Override
	public DirectBonusItem createDirectBonusItem() throws BadParametersForThisItemException {
		return new Steroids(-20, 30);
	}
	
	@Test(expected=BadParametersForThisItemException.class)
	public void testConstructorWithNoValidHP() throws BadParametersForThisItemException {
		new Steroids(1, 30);
	}
	
	@Override @Test(expected=BadParametersForThisItemException.class)
	public void testConstructorWithBadParameters() throws BadParametersForThisItemException {
		new Steroids(5, -20);
	}
	
}
