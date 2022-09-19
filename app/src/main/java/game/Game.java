package game;

public class Game {
	private String word;

	public Game(String word) {
		this.word = word;
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
		return 10;
	}
}
