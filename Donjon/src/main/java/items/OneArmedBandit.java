package items;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import characters.Player;
import rooms.Room;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * a OneArmedBandit class
 */
public class OneArmedBandit implements Item {
		
	private List<Item> possiblePrize;
	private int cost;
	
	public OneArmedBandit(int cost) {
		this.possiblePrize = new LinkedList<>();
		this.cost = cost;
	}
	
	/**
	 * @return the cost to pay to use the item
	 */
	public int getCost() {
		return this.cost;
	}
	
	/**
	 * @param t possible item to get with oneArmedBandit
	 */
	public void addPossiblePrize(Item t) {
		this.possiblePrize.add(t);
	}

	/**
	 * Randomly choose a item available in the one armed bandit and applies it effect to the player
	 * @param p player who receives the bonus
	 */
	@Override
	public void use(Player p, Room r) {
		if (p.getGoldCarried() >= this.cost) {
			System.out.println("---> You used "+this+", are you lucky ?");
			p.setGoldCarried(p.getGoldCarried() - this.cost);
			Item toUse = this.randomItem(this.possiblePrize);
			toUse.use(p, r);
		}
		else {
			System.out.println("You don't have enough money to use "+this+". It disappears !");
			r.getItems().remove(this);
		}
	}
	
	/**
	 * @return the possible prizes
	 */
	public List<Item> getPossiblePrize() {
		return this.possiblePrize;
	}

	/**
	 * @param list a list of item it is possible to get with oneArmedBandit
	 * @return a random item from the list
	 */
	private Item randomItem(List<Item> list) {
		Random rand = new Random();
		int index = rand.nextInt(list.size());
		return list.get(index);
	}
	
	@Override
	public String toString() {
		return "One Armed Bandit (cost: "+this.cost+")";
	}

}
