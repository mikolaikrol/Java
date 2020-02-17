package ActionsTest;

import static org.junit.Assert.assertTrue;

import actions.Action;
import actions.Look;

public class LookTest extends ActionTest {

	@Override
	protected Action createAction() {
		return Look.getInstance();
	}

	@Override
	public void testIsPossibleReturnsTrue() {
		assertTrue(this.theAction.isPossible(this.ItemAndMonsterRoom));
		assertTrue(this.theAction.isPossible(this.emptyRoom));
	}

	@Override
	public void testIsPossibleReturnsFalse() {
		// Ce n'est pas possible
	}

	@Override
	public void testExecuteWorksWell() {
		// On peut pas tester un print
	}

}
