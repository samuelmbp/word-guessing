package game;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
public class MaskerTest {
    @Test
    public void testGetInitialWorkToGuess() {
        Masker masker = new Masker();
        ArrayList<Character> guessedLetters = new ArrayList<>();

        assertEquals(masker.getMaskedWord("LONDON", guessedLetters), "L_____");
    }

    @Test
    public void testGetsMaskedWord() {
        Masker masker = new Masker();
        ArrayList<Character> guessedLetters = new ArrayList<>();
        guessedLetters.add('A');
        guessedLetters.add('S');

        assertEquals(masker.getMaskedWord("MAKERS", guessedLetters), "MA___S");
    }
}
