package game;

import java.util.ArrayList;

public class Game {
	private ArrayList<Character> guessedLetters = new ArrayList<>();
	public static void main(String[] args) {
	}
	private String word;
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

	public Boolean guessLetter(Character letter) {
		if (this.word.indexOf(letter) != -1) {
			guessedLetters.add(letter);
			return true;
		} else {
			this.remainingAttempts--;
			return false;
		}
	};
}
