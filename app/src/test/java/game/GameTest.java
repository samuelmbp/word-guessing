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

	@Test public void testGuessLetterRight() {
		WordChoser mockedChoser = mock(WordChoser.class);
		when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

		Game game = new Game(mockedChoser);
		assertEquals(game.guessLetter('K'), true);
		assertEquals(game.getWordToGuess(), "M_K___");
	}
	@Test public void testGuessLetterWrongWhenNotInWord() {
		WordChoser mockedChoser = mock(WordChoser.class);
		when(mockedChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

		Game game = new Game(mockedChoser);
		assertEquals(game.guessLetter('Y'), false);
		assertEquals(game.getWordToGuess(), "L_____");
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

	@Test
	public void testGuessLetterRightAndDisplayIt() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

		Game game = new Game(wordChoser);
		assertEquals(game.guessLetter('O'), true);
	}

	@Test
	public void testGuessLetterWrong() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

		Game game = new Game(wordChoser);
		assertEquals(game.guessLetter('X'), false);
	}
}
