package game;

import java.util.Random;

public class WordChoser {
	private static final String[] DICTIONARY = { "MAKERS", "CANDIES", "DEVELOPER", "LONDON" };

	public String getRandomWordFromDictionary() {
		Random random = new Random();
		return DICTIONARY[random.nextInt(DICTIONARY.length)];
	}
}
