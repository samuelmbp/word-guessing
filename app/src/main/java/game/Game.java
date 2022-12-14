package game;

import java.util.ArrayList;

public class Game {
	final private ArrayList<Character> guessedLetters = new ArrayList<>();
	private String word;
	private int remainingAttempts = 10;
	public String name;
	final private Masker masker;
	private WordChoser wordChoser;

	public Game(WordChoser wordChoser, Masker masker, String name) {
		this.word = wordChoser.getRandomWordFromDictionary();
		this.masker = masker;
		this.name = name;
	}
	public Integer getRemainingAttempts() {
		return this.remainingAttempts;
	}

	public String guessLetter(Character letter) {
		if (this.word.indexOf(letter) != -1) {
			guessedLetters.add(letter);
			return "right";
		} else {
			this.remainingAttempts--;
			return "wrong";
		}
	};

	public String getWordToGuess() {
		return this.masker.getMaskedWord(this.word, guessedLetters);
	}

	public Boolean isGameLost() {
		if (this.remainingAttempts == 0) {
			System.out.println("You've lost! Try again.");
			return true;
		} else return false;
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
