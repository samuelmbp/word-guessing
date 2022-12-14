package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.Test;
import java.util.ArrayList;

public class GameTest {
	@Test public void testGuessLetterRight() {
		WordChoser mockedChoser = mock(WordChoser.class);
		when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

		Masker mockedMasker = mock(Masker.class);

		Game game = new Game(mockedChoser, mockedMasker, "Samuel");
		assertEquals(game.guessLetter('K'), "right");
	}

	@Test
	public void testGuessLetterWrong() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

		Masker mockedMasker = mock(Masker.class);

		Game game = new Game(wordChoser, mockedMasker, "Samuel");
		assertEquals(game.guessLetter('X'), "wrong");
	}

	@Test
	public void testGetsWordToGuessWithRandomWord() {
		WordChoser mockedChoser = mock(WordChoser.class);
		when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

		Masker mockedMasker = mock(Masker.class);
		ArrayList<Character> guessedLetters = new ArrayList<>();
		when(mockedMasker.getMaskedWord("MAKERS", guessedLetters)).thenReturn("M_____");

		Game game = new Game(mockedChoser, mockedMasker, "Samuel");
		assertEquals(game.getWordToGuess(), "M_____");
	}

	 @Test
	 public void testGetRemainingAttempts() {
		 WordChoser mockedChoser = mock(WordChoser.class);
		 when(mockedChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

		 Masker mockedMasker = mock(Masker.class);
		 ArrayList<Character> guessedLetters = new ArrayList<>();
		 when(mockedMasker.getMaskedWord("LONDON", guessedLetters)).thenReturn("LONDON");

		 Game game = new Game(mockedChoser, mockedMasker, "Samuel");
		 int remainingAttempts = 10;
		 assertEquals("should return the number of attempts",
		 Integer.valueOf(remainingAttempts),
		 game.getRemainingAttempts());
	 }

	@Test
	public void testGuessLetterRightAndDisplayIt() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

		Masker mockedMasker = mock(Masker.class);
		ArrayList<Character> guessedLetters = new ArrayList<>();
		when(mockedMasker.getMaskedWord("DEVELOPER", guessedLetters)).thenReturn("DE_E___E_");

		Game game = new Game(wordChoser, mockedMasker, "Samuel");
		assertEquals(game.getWordToGuess(), "DE_E___E_");
	}
	@Test
	public void shouldLoseGameIfNotAttemptsLeft() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("SEA");

		Masker mockedMasker = mock(Masker.class);
		ArrayList<Character> guessedLetters = new ArrayList<>();
		when(mockedMasker.getMaskedWord("SEA", guessedLetters)).thenReturn("S__");

		Game game = new Game(wordChoser, mockedMasker, "Samuel");
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
		Masker mockedMasker = mock(Masker.class);


		Game game = new Game(wordChoser, mockedMasker, "Samuel");
		game.guessLetter('S');
		game.guessLetter('E');
		game.guessLetter('A');
		assertTrue("should win the game when word is guessed", game.isGameWon());
	}

	@Test
	public void shouldWinTheGameWhenSpecialCharactersAreGuessed() {
		WordChoser wordChoser = mock(WordChoser.class);
		when(wordChoser.getRandomWordFromDictionary()).thenReturn("ABBA");
		Masker mockedMasker = mock(Masker.class);


		Game game = new Game(wordChoser, mockedMasker,"Samuel");
		game.guessLetter('A');
		game.guessLetter('B');
		game.guessLetter('A');
		assertEquals(game.isGameWon(), true);
	}
}
