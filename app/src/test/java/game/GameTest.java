package game;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {
	@Test
	public void testGetsWordToGuessWithRandomWord() {
		Game game = new Game();
		String word = "M_____";
		assertEquals(game.getWordToGuess(word), word);
	}

	@Test
	public void testGetRemainingAttempts() {
		Game game = new Game();
		Integer remainingAttempts = 10;
		assertEquals("should return the number of attempts", Integer.valueOf(remainingAttempts),
				game.getRemainingAttempts());
	}
}
