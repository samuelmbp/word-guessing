package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;

public class GameTest {
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
		assertEquals(game.getWordToGuess(), "L_____");
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

	@Test
	public void shouldLoseGameIfNotAttemptsLeft() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("SEA");

		Game game = new Game(wordChoser);
		game.guessLetter('Y');
		game.guessLetter('Y');
		game.guessLetter('Y');
		game.guessLetter('Y');
		game.guessLetter('Y');
		game.guessLetter('Y');
		game.guessLetter('Y');
		game.guessLetter('Y');
		game.guessLetter('Y');
		game.guessLetter('Y');
		assertTrue("should lose the game when no attempts left", game.isGameLost());
	}

	@Test
	public void shouldWinTheGameWhenWordIsGuessedCorrectly() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("SEA");

		Game game = new Game(wordChoser);
		game.guessLetter('S');
		game.guessLetter('E');
		game.guessLetter('A');
		assertTrue("should win the game when word is guessed", game.isGameWon());
	}

	@Test
	public void shouldWinTheGameWhenSpecialCharactersAreGuessed() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("ABBA");

		Game game = new Game(wordChoser);
		game.guessLetter('A');
		game.guessLetter('B');
		game.guessLetter('A');
		assertEquals(game.isGameWon(), true);
	}
}
