package game;

import java.util.ArrayList;

public class Game {
	private ArrayList<Character> guessedLetters = new ArrayList<>();
	private String word;
	public int remainingAttempts = 10;
	private Masker masker;
	public Game(WordChoser wordChoser) {
		this.word = wordChoser.getRandomWordFromDictionary();
	}



	public Integer getRemainingAttempts() {
		return this.remainingAttempts;
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

	public String getWordToGuess() {
		return this.masker.getMaskedWord(this.word, guessedLetters);
	}

	public Boolean isGameLost() {
		if (this.remainingAttempts == 0) {
			System.out.println("You've lost! Try again.");
			return true;
		} else {
			return false;
		}
	}

	public Boolean isGameWon() {
		for (int i = 1; i < this.word.length(); i++) {
			Character letter = this.word.charAt(i);
			if (!this.guessedLetters.contains(letter))
				return false;
		}
		return true;
	}
}
