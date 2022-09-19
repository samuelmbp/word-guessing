package game;

import java.util.Random;

public class Game {
	public String word;
	private Integer remainingAttempts = 10;

	private static final String[] DICTIONARY = { "MAKERS", "CANDIES", "DEVELOPER", "LONDON" };

	public Game() {
		word = this.getRandomWordFromDictionary();
	}

	public static void main(String[] args) {
	}

	public String getWordToGuess(String str) {
		StringBuilder builder = new StringBuilder(str);
		for (int i = 1; i < str.length(); i++) {
			builder.replace(i, str.length(), "_");
		}
		return builder.toString();
	}

	public Integer getRemainingAttempts() {
		return remainingAttempts;
	}

	public String getRandomWordFromDictionary() {
		Random random = new Random();
		return DICTIONARY[random.nextInt(DICTIONARY.length)];
	}

}
