package items;
import util.BadParametersForThisItemException;

/**
 * @author Bart Sébastien and Krol Mikolaï
 * A Steroids class: add sp but lowers a lot hp
 */
public class Steroids extends DirectBonusItem {

	/**
	 * @param hp the hp to remove
	 * @param sp the sp to add
	 * @throws BadParametersForThisItemException if hp inferior or equal to 0
	 */
	public Steroids(int hp, int sp) throws BadParametersForThisItemException {
		super(hp, sp, 0);
		if(hp >= 0 || sp < 0)
			throw new BadParametersForThisItemException();
	}
	
	@Override
	public String toString() {
		return "Steroids("+this.hp+"HP, "+this.sp+"SP)";
	}

}
