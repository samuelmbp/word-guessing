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
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < this.word.length(); i++) {
			Character currentLetter = word.charAt(i);
			if (i == 0) {
				builder.append(currentLetter);
			} else {
				if (guessedLetters.indexOf(currentLetter) != -1) {
					builder.append(currentLetter);
				} else {
					builder.append("_");
				}
			}
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
