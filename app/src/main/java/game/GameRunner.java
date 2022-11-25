package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameRunner {
    private int counter = 1;
    private final Print print = new Print();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        print.welcomeMessage();

        System.out.println("Enter name for player one: ");
        String playerOneName = scanner.nextLine();
        System.out.println("Enter name for player two: ");
        String playerTwoName = scanner.nextLine();

        WordChoser wordChoser = new WordChoser();
        Masker masker = new Masker();
        ArrayList<Game> players = new ArrayList<>(Arrays.asList(
                new Game(wordChoser, masker, playerOneName),
                new Game(wordChoser, masker, playerTwoName))
        );

        Random random = new Random();
        int randomPlayer = random.nextInt(players.size());
        Game playerOne = players.get(randomPlayer);
        Game playerTwo = players.get(1 - randomPlayer);

        print.wordToGuessMessage();
        System.out.println(playerOne.name + ": " + playerOne.getWordToGuess());
        System.out.println(playerTwo.name + ": " + playerTwo.getWordToGuess());
        System.out.println();

        do {
            print.askPlayerForLetterInput(playerOne.name, playerOne.getRemainingAttempts());
            Character playerOneInput = scanner.nextLine().charAt(0);
            String playerOneResult = playerOne.guessLetter(playerOneInput);

            if (playerOneResult == "right") {
                if (playerOne.isGameWon()) {
                    print.congratulateWinner(playerOne.name, playerOne.getWordToGuess());
                    break;
                } else {
                    print.correctGuess();
                    System.out.println(playerOne.getWordToGuess());
                    counter++;
                }
            } else {
                if (playerOne.isGameLost()) {
                    System.out.println("Wrong!" + playerTwo.name + " won!");
                    break;
                } else {
                    print.wrongGuess();
                    System.out.println(playerOne.getWordToGuess());
                    counter++;
                }
            }

            print.askPlayerForLetterInput(playerTwo.name, playerTwo.getRemainingAttempts());

            Character playerTwoInput = scanner.nextLine().charAt(0);
            String playerTwoResult = playerTwo.guessLetter(playerTwoInput);

            if (playerTwoResult == "right") {
                if (playerTwo.isGameWon()) {
                    print.congratulateWinner(playerTwo.name, playerTwo.getWordToGuess());
                    break;
                } else {
                    print.correctGuess();
                    System.out.println(playerTwo.getWordToGuess());
                    counter++;
                }
            } else {
                if (playerTwo.isGameLost()) {
                    System.out.println("Wrong! " + playerTwo.name + " won!");
                    break;
                } else {
                    print.wrongGuess();
                    System.out.println(playerTwo.getWordToGuess());
                    counter++;
                }
            }

        } while ((playerOne.getWordToGuess().contains("_") && playerOne.getRemainingAttempts() > 0 )
                || (playerTwo.getWordToGuess().contains("_") && playerTwo.getRemainingAttempts() > 0));
    }
}
