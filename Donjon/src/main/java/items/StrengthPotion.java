package items;

import util.BadParametersForThisItemException;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * a StrengthPotion class
 */
public class StrengthPotion extends DirectBonusItem {

	public StrengthPotion(int sp) throws BadParametersForThisItemException {
		super(0, sp, 0);
		if(sp <= 0)
			throw new BadParametersForThisItemException();
	}
	
	@Override
	public String toString() {
		return "Strength Potion("+this.sp+")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof StrengthPotion) {
			StrengthPotion toCompare = (StrengthPotion) o;
			return this.sp == toCompare.sp;
		}
		return false;
	}
	
}
