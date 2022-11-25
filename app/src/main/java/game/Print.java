package game;

public class Print {

    public void welcomeMessage() {
        System.out.println("Welcome to the hangman game!");
        System.out.println();
    }
    public void correctGuess() {
        System.out.println("Right!");
    }

    public void wrongGuess() {
        System.out.println("Wrong!");
    }

    public void wordToGuessMessage() {
        System.out.println();
        System.out.println("Welcome! Today the word to guess is: ");
    }

    public void congratulateWinner(String name, String word) {
        System.out.printf("Congratulations %s! You won! \nThe word to guess was: %s", name, word);
    }

    public void askPlayerForLetterInput(String name, int remainingAttempts) {
        System.out.printf("%s: Enter one letter to guess (%d attempts remaining):\n", name, remainingAttempts);
    }
}
