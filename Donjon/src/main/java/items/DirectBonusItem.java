package items;

import characters.Player;
import rooms.Room;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * Class to manage item which give a bonus to the player.
 */
public abstract class DirectBonusItem implements Item {
	
	protected int hp;
	protected int sp;
	protected int gold;
	
	
	/**
	 * @param hp hp bonus
	 * @param sp sp bonus
	 * @param gold gold bonus
	 */
	public DirectBonusItem(int hp, int sp, int gold) {
		this.hp = hp;
		this.sp = sp;
		this.gold = gold;
	}
	
	/**
	 * @return the hp bonus
	 */
	public int getHp() {
		return hp;
	}


	/**
	 * @return the sp bonus
	 */
	public int getSp() {
		return sp;
	}

	/**
	 * @return the gold bonus
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * print the effect of a directbonusitem.
	 */
	public void printEffect() {
		String txt = "---> You used "+this+ " : ";
		if (this.hp < 0)
			txt += this.hp+"HP ";
		else if (this.hp > 0)
			txt += "+"+this.hp+"HP ";
		if (this.sp < 0)
			txt += this.sp+"SP ";
		else if (this.sp > 0)
			txt += "+"+this.sp+"SP ";
		if (this.gold < 0)
			txt += this.gold+"G ";
		else if (this.gold > 0)
			txt += "+"+this.gold+"G ";
		txt += "!";
		System.out.println(txt);
	}

	/**
	 * Applies the hp bonus, sp bonus and gold bonus of the item to the player
	 * @param p player who receives the bonus
	 * @param r current room
	 */
	public void use(Player p, Room r) {
		p.setGoldCarried(this.gold + p.getGoldCarried());
		p.setHealthPoints(this.hp + p.getHealthPoints());
		p.setStrengthPoints(this.sp + p.getStrengthPoints());
		this.printEffect();
	}
	
}
