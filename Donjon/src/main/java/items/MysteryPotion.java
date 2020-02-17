package items;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * A MysteryPotion class to get random bonus/malus
 */
public class MysteryPotion extends DirectBonusItem {

	/**
	 * Create a potion with random hp and sp bonus or malus
	 * @param infHP inferior limit for hp
	 * @param maxHP superior limit for hp
	 * @param infSP inferior limit for sp
	 * @param maxSP superior limit for sp
	 */
	public MysteryPotion(int infHP, int maxHP, int infSP, int maxSP) {
		super(ThreadLocalRandom.current().nextInt(infHP, maxHP), ThreadLocalRandom.current().nextInt(infSP, maxSP), 0);
	}
	
	@Override
	public String toString() {
		return "Mystery Potion";
	}

}
