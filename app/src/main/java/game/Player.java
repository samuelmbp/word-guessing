package game;

public class Player {

    public String getGameResults(String playerResult, Game playerOne, Game playerTwo) {
        do {
            int counter = 1;

            if (playerResult == "right") {
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
        } while(playerOne.getWordToGuess().contains("_") && playerOne.getRemainingAttempts() > 0);
        return playerResult;
    }
}
