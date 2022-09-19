package game;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {
	@Test
	public void testGetsWordToGuess() {
		Game game = new Game("MAKERS");
		assertEquals(game.getWordToGuess(), "M_____");
	}

	/**
	 * Create a new game obj
	 * Create a variable called attempts as integer
	 * Use Integer.valueOf(attempts), obj.methodName()
	 */
	@Test
	public void testGetRemainingAttempts() {
		Game game = new Game("MAKERS");
		Integer remainingAttempts = 10;
		assertEquals("should return the numbers of attempts", Integer.valueOf(remainingAttempts), game.getRemainingAttempts());
	}
}
