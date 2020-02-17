package ItemTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import items.DirectBonusItem;
import items.Item;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;

public abstract class DirectBonusItemTests extends ItemTests{

	protected DirectBonusItem DirectBonusItem;
	
	@Override
	public void before() throws CharacterHasWrongStrengthOrHealthException, BadParametersForThisItemException {
		super.before();
		this.DirectBonusItem = this.createDirectBonusItem();
	}
	
	@Override
	public Item createItem() throws BadParametersForThisItemException {
		return this.createDirectBonusItem();
	}
	
	public abstract DirectBonusItem createDirectBonusItem() throws BadParametersForThisItemException;
	
	public abstract void testConstructorWithBadParameters() throws BadParametersForThisItemException;
	
	@Test
	public void testIfBonusHasBeenApplied() {
		int playerGBeforeUse = this.p.getGoldCarried();
		int playerHPBeforeUse = this.p.getHealthPoints();
		int playerSPBeforeUse = this.p.getStrengthPoints();
		int itemHP = this.DirectBonusItem.getHp();
		int itemSP = this.DirectBonusItem.getSp();
		int itemG = this.DirectBonusItem.getGold();
		this.DirectBonusItem.use(this.p, this.r);
		assertEquals(this.p.getHealthPoints(), playerHPBeforeUse+itemHP);
		assertEquals(this.p.getGoldCarried(), playerGBeforeUse+itemG);
		assertEquals(this.p.getStrengthPoints(), playerSPBeforeUse+itemSP);
	};

}
