package game;

public class Game {
	public static void main(String[] args) {
	}

	public String word;
	private Integer remainingAttempts = 10;

	public Game() {
		WordChoser wordChoser = new WordChoser();
		word = wordChoser.getRandomWordFromDictionary();
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
}
