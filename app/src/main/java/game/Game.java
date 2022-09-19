package game;

public class Game {
	String word;

	public Game(String word) {
		this.word = word;
	}

	public static void main(String[] args) {
	}

	public String getWordToGuess() {
		StringBuilder sb = new StringBuilder(word);
		for (int i = 1; i < word.length(); i++) {
			sb.replace(i, word.length(), "_");
		}
		return sb.toString();
	}
}
