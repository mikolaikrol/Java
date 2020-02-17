package items;

import util.BadParametersForThisItemException;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * a GoldPurse class
 */
public class GoldPurse extends DirectBonusItem {
		
	public GoldPurse(int gold) throws BadParametersForThisItemException{
		super(0, 0, gold);
		if(gold <= 0)
			throw new BadParametersForThisItemException();
	}
	
	@Override
	public String toString() {
		return "Gold purse("+this.gold+")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof GoldPurse) {
			GoldPurse toCompare = (GoldPurse) o;
			return this.gold == toCompare.gold;
		}
		return false;
	}
	
}
