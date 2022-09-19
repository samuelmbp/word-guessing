package game;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {
	@Test
	public void testGetsWordToGuess() {
		Game game = new Game("MAKERS");
		assertEquals(game.getWordToGuess(), "M_____");
	}
}
