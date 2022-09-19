package game;

import java.util.Random;

public class Game {
	private String word;
	private Integer remainingAttempts = 10;

	private static final String[] DICTIONARY = { "MAKERS", "CANDIES", "DEVELOPER", "LONDON" };

	public Game() {
		word = this.getRandomWordFromDictionary();
	}

	public static void main(String[] args) {
	}

	public String getWordToGuess() {
		StringBuilder builder = new StringBuilder(word);
		for (int i = 1; i < word.length(); i++) {
			builder.replace(i, word.length(), "_");
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
