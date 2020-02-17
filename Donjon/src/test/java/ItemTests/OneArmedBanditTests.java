package ItemTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import items.DirectBonusItem;
import items.GoldPurse;
import items.HealthPotion;
import items.Item;
import items.OneArmedBandit;
import items.StrengthPotion;
import util.BadParametersForThisItemException;

public class OneArmedBanditTests extends ItemTests{
	
	protected int cost;
	protected DirectBonusItem itemInOneArmedBandit;
		
	@Override
	public Item createItem() throws BadParametersForThisItemException {
		this.cost = this.p.getGoldCarried();
		OneArmedBandit bandit = new OneArmedBandit(cost);
		this.itemInOneArmedBandit = new HealthPotion(10);
		bandit.addPossiblePrize(itemInOneArmedBandit);
		return bandit;
	}

	@Test
	public void testIfBonusHasBeenAppliedWhenOnePossiblePrize() {
		int HpBeforeUse = this.p.getHealthPoints();
		this.item.use(this.p, this.r);
		int healthPoints = this.p.getHealthPoints();
		assertTrue(healthPoints == HpBeforeUse + this.itemInOneArmedBandit.getHp());
	}
	
	@Test
	public void testIfBonusHasBeenAppliedWhenMultiplePossiblePrize() throws BadParametersForThisItemException {
		OneArmedBandit bandit = new OneArmedBandit(10);
		HealthPotion i1 = new HealthPotion(10);
		bandit.addPossiblePrize(i1);
		StrengthPotion i2 = new StrengthPotion(10);
		bandit.addPossiblePrize(i2);
		GoldPurse i3 = new GoldPurse(10);
		bandit.addPossiblePrize(i3);
		int HpBeforeUse = this.p.getHealthPoints();
		int GoldBeforeUse = this.p.getGoldCarried();
		int SpBeforeUse = this.p.getStrengthPoints();
		this.item.use(this.p, this.r);
		int healthPoints = this.p.getHealthPoints();
		int strengthPoints = this.p.getStrengthPoints();
		int goldCarried = this.p.getGoldCarried();
		assertTrue(healthPoints == HpBeforeUse + i1.getHp() || strengthPoints == SpBeforeUse + i2.getSp() || goldCarried == GoldBeforeUse + i3.getGold());
	}
	
	@Test
	public void testUseIfNotEnoughGoldDoesNothingToThePlayer() {
		int goldSet = this.p.getGoldCarried() - 1;
		this.p.setGoldCarried(goldSet);
		int HpBeforeUse = this.p.getHealthPoints();
		int GoldBeforeUse = this.p.getGoldCarried();
		int SpBeforeUse = this.p.getStrengthPoints();
		this.item.use(this.p, this.r);
		assertTrue(this.p.getGoldCarried() == goldSet);
		int healthPoints = this.p.getHealthPoints();
		int strengthPoints = this.p.getStrengthPoints();
		int goldCarried = this.p.getGoldCarried();
		assertEquals(HpBeforeUse, healthPoints);
		assertEquals(GoldBeforeUse, goldCarried);
		assertEquals(SpBeforeUse, strengthPoints);
	}
	
	@Test
	public void testUseIfNotEnoughGoldMakesBanditDisappeared() {
		int goldSet = this.p.getGoldCarried() - 1;
		this.p.setGoldCarried(goldSet);
		this.item.use(this.p, this.r);
		assertFalse(this.r.getItems().contains(this.item));
	}
	
	@Test
	public void testUseReduceGold() {
		int beforeUse = this.p.getGoldCarried();
		this.item.use(this.p, this.r);
		assertEquals(this.p.getGoldCarried(), beforeUse - this.cost);
	}
	
	@Test
	public void possiblePrizeContainsAddedItem() throws BadParametersForThisItemException {
		OneArmedBandit bandit = new OneArmedBandit(this.cost);
		Item added = new StrengthPotion(10);
		bandit.addPossiblePrize(added);
		assertTrue(bandit.getPossiblePrize().contains(added));
	}


}
