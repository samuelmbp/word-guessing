package game;

import java.util.ArrayList;

public class Game {
	private ArrayList<Character> guessedLetters = new ArrayList<>();
	private String word;
	public int remainingAttempts = 10;
//	private Boolean isGameLostAttr;

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

	public Boolean isGameLost() {
		if (this.remainingAttempts == 0) {
			System.out.println("You've lost! Try again.");
			return true;
		} else {
			return false;
		}
	}

	public Boolean isGameWon() {
		for (int i = 1; i > word.length(); i++) {
			Character letter = word.charAt(i);
			if (!this.guessedLetters.contains(letter))
				return false;
		}
		return true;
	}
}
