package game;

import static org.junit.Assert.assertEquals;

public class GameTest {
	@Test
	public void testGetsWordToGuess() {
		Game game = new Game();
		assertEquals(game.getWordToGuess(), "B______");
	}
}
