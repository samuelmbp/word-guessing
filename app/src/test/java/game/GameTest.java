package game;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.Test;

public class GameTest {
	 @Test
	 public void testGetsWordToGuess() {
		 WordChoser mockedChoser = mock(WordChoser.class);
		 when(mockedChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

		 Game game = new Game(mockedChoser);
		 String word = "L_____";
		 assertEquals(game.getWordToGuess(), word);
	 }

	@Test
	public void testGetsWordToGuessWithRandomWord() {
		WordChoser mockedChoser = mock(WordChoser.class);
		when(mockedChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

		Game game = new Game(mockedChoser);
		String word = "L_____";
		assertEquals(game.getWordToGuess(), word);
	}

	 @Test
	 public void testGetRemainingAttempts() {
		 WordChoser mockedChoser = mock(WordChoser.class);
		 when(mockedChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

		 Game game = new Game(mockedChoser);
		 int remainingAttempts = 10;
		 assertEquals("should return the number of attempts",
		 Integer.valueOf(remainingAttempts),
		 game.getRemainingAttempts());
	 }
}
