package items;

import util.BadParametersForThisItemException;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * a HealthPotion class
 */
public class HealthPotion extends DirectBonusItem {

	public HealthPotion(int hp) throws BadParametersForThisItemException {
		super(hp, 0, 0);
		if(hp <= 0)
			throw new BadParametersForThisItemException();
	}
	
	@Override
	public String toString() {
		return "Health Potion("+this.hp+")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof HealthPotion) {
			HealthPotion toCompare = (HealthPotion) o;
			return this.hp == toCompare.hp;
		}
		return false;
	}
	
}
