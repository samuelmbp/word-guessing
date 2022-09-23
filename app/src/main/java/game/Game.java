package game;

public class Game {
	public static void main(String[] args) {
	}

	public String word;
	private int remainingAttempts = 10;

	public Game(WordChoser wordChoser) {
		this.word = wordChoser.getRandomWordFromDictionary();
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
}
