package characters;

import rooms.Room;
import util.BadParametersForThisItemException;
import util.CharacterHasWrongStrengthOrHealthException;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * a Character class to manage the characters (abstract)
 */
public abstract class Character {
	
	protected int healthPoints;
	protected int strengthPoints;
	protected int goldCarried;
	protected String name;
	
	/**
	 * @param healthPoints number of health points
	 * @param strengthPoints number of strength points
	 * @param gold number of gold coins
	 * @param name name of the character
	 * @throws CharacterHasWrongStrengthOrHealthException if no sense parameters
	 */
	public Character(int healthPoints, int strengthPoints, int gold, String name) throws CharacterHasWrongStrengthOrHealthException {
		if (healthPoints <= 0 || strengthPoints < 0) {
			throw new CharacterHasWrongStrengthOrHealthException();
		}
		else {
			this.healthPoints = healthPoints;
			this.strengthPoints = strengthPoints;
			this.goldCarried = gold;
			this.name = name;
		}
	}
	
	/**
	 * @return the number of hp
	 */
	public int getHealthPoints() {
		return healthPoints;
	}
	
	/**
	 * @param healthPoints the hp to set, cannot be inferior to 0
	 */
	public void setHealthPoints(int healthPoints) {
		if (healthPoints < 0)
			this.healthPoints = 0;
		else
			this.healthPoints = healthPoints;
	}
	
	/**
	 * @return the number of sp
	 */
	public int getStrengthPoints() {
		return strengthPoints;
	}
	
	/**
	 * @param strengthPoints the sp to set, cannot be inferior to 0
	 */
	public void setStrengthPoints(int strengthPoints) {
		if (strengthPoints < 0)
			this.strengthPoints = 0;
		else
			this.strengthPoints = strengthPoints;
	}
	
	/**
	 * @return the number of gold
	 */
	public int getGoldCarried() {
		return goldCarried;
	}
	
	/**
	 * @param goldCarried the gold total to set, cannot be inferior to 0
	 */
	public void setGoldCarried(int goldCarried) {
		if (goldCarried < 0)
			this.goldCarried = 0;
		else
			this.goldCarried = goldCarried;
	}
	
	/**
	 * @return true if the character is dead, false if not
	 */
	public boolean isDead() {
		return this.getHealthPoints() <= 0;
	}
	
	@Override
	public String toString() {
		return this.name + "(" +this.healthPoints+"HP, "+this.strengthPoints+"SP, "+this.goldCarried+"G)"; 
	}

	/**
	 * @param r the Room the death take place in
	 * @throws BadParametersForThisItemException if bad item
	 */
	public void deathEffect(Room r) throws BadParametersForThisItemException{
		System.out.println(this + " died.");
	}
	
	/**
	 * does one round of battle between two characters
	 * @param target the attacked Character
	 * @param r the room where the battle takes place
	 * @throws BadParametersForThisItemException if dead character drop bad item
	 */
	public void battleOneRound(Character target, Room r) throws BadParametersForThisItemException {
		System.out.println("---> "+ this + " attacks " + target + " !");
		target.setHealthPoints(target.getHealthPoints() - this.getStrengthPoints());
		if (!target.isDead()) {
			System.out.println(target + " is not dead ! It fights back !");
			this.setHealthPoints(this.getHealthPoints() - target.getStrengthPoints());
			if (this.isDead()) {
				this.deathEffect(r);
			}
		}
		else {
			target.deathEffect(r);
		}
	}
	
	/**
	 * same as battleOneRound but until one of the Character dies
	 * @param target the attacked Character
	 * @param r the room where the battle takes place
	 * @throws BadParametersForThisItemException if dead character drop bad item
	 */
	public void battleUntilDeath(Character target, Room r) throws BadParametersForThisItemException {
		while (!(this.isDead() || target.isDead())) {
			this.battleOneRound(target, r);
		}
	}
	
}
