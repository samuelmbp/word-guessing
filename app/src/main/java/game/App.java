/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the hangman game!");

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

        System.out.println("Welcome! Today the word to guess is: ");
        System.out.println(playerOne.name + ": " + playerOne.getWordToGuess());
        System.out.println(playerTwo.name + ": " + playerTwo.getWordToGuess());

       do {
           int counter = 1;

           System.out.println(playerOne.name + ": Guess a letter " + "(" + playerOne.getRemainingAttempts()
                   + " attempts remaining" + ")");
           Character playerOneInput = scanner.nextLine().charAt(0);
           String playerOneResult = playerOne.guessLetter(playerOneInput);

           if (playerOneResult == "right") {
               if (playerOne.isGameWon()) {
                   System.out.println("Congratulations! " + playerOne.name + " won!");
                   System.out.println(playerOne.getWordToGuess());
                   break;
               } else {
                   System.out.println("Right!");
                   System.out.println(playerOne.getWordToGuess());
                   counter++;
               }
           } else {
               if (playerOne.isGameLost()) {
                   System.out.println("Wrong!" + playerTwo.name + " won!");
                   break;
               } else {
                   System.out.println("Wrong");
                   System.out.println(playerOne.getWordToGuess());
                   counter++;
               }
           }

           System.out.println(playerTwo.name + ": Guess a letter! " + "(" + playerTwo.getRemainingAttempts()
                   + " attempts remaining)");

           Character playerTwoInput = scanner.nextLine().charAt(0);
           String playerTwoResult = playerTwo.guessLetter(playerTwoInput);

           if (playerTwoResult == "right") {
               if (playerTwo.isGameWon()) {
                   System.out.println("Congratulations! " + playerTwo.name + " won!");
                   System.out.println(playerTwo.getWordToGuess());
                   break;
               } else {
                   System.out.println("Right!");
                   System.out.println(playerTwo.getWordToGuess());
                   counter++;
               }
           } else {
               if (playerTwo.isGameLost()) {
                   System.out.println("Wrong! " + playerTwo.name + " won!");
                   break;
               } else {
                   System.out.println("Wrong!");
                   System.out.println(playerTwo.getWordToGuess());
                   counter++;
               }
           }

       } while ((playerOne.getWordToGuess().contains("_") && playerOne.getRemainingAttempts() > 0 )
               || (playerTwo.getWordToGuess().contains("_") && playerTwo.getRemainingAttempts() > 0));
    }
}

