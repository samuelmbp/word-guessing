package game;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class WordChoserTest {

	@Test
	public void shouldContainADictionary() {
		WordChoser wordChoser = new WordChoser();
		String[] MOCK_DICTIONARY = { "MAKERS", "CANDIES", "DEVELOPER", "LONDON" };

		assertTrue(Arrays.asList(MOCK_DICTIONARY).contains(wordChoser.getRandomWordFromDictionary()));
	}
}
