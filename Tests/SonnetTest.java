import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;

public class SonnetTest {

    private final String SONNET = "Two households, both alike in dignity,";

    private InputStream originalIn;
    private PrintStream originalOut;

    @BeforeEach
    void setup() {
        originalIn = System.in;
        originalOut = System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @AfterEach
    void teardown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    /* -------------------------
       Case-insensitive
       ------------------------- */
    @Test
    void testCaseInsensitive() {
        Sonnet game = new Sonnet(SONNET);

        System.setIn(new ByteArrayInputStream("BOTH\n".getBytes()));
        game.PlayIndexRound(2); // "both"

        assertEquals(1, game.getCorrect());
        assertEquals(0, game.getIncorrect());
    }

    /* -------------------------
       Index = 0
       ------------------------- */
    @Test
    void testIndexZero() {
        Sonnet game = new Sonnet(SONNET);

        System.setIn(new ByteArrayInputStream("Two\n".getBytes()));
        game.PlayIndexRound(0);

        assertEquals(1, game.getCorrect());
    }

    /* -------------------------
       Index = last word
       ------------------------- */
    @Test
    void testLastIndex() {
        Sonnet game = new Sonnet(SONNET);

        System.setIn(new ByteArrayInputStream("dignity,\n".getBytes()));
        game.PlayIndexRound(SONNET.split(" ").length - 1);

        assertEquals(1, game.getCorrect());
    }

    /* -------------------------
       Three correct
       ------------------------- */
    @Test
    void testThreeCorrect() {
        Sonnet game = new Sonnet(SONNET);

        System.setIn(new ByteArrayInputStream("Two\n".getBytes()));
        game.PlayIndexRound(0);

        System.setIn(new ByteArrayInputStream("households,\n".getBytes()));
        game.PlayIndexRound(1);

        System.setIn(new ByteArrayInputStream("both\n".getBytes()));
        game.PlayIndexRound(2);

        assertEquals(3, game.getCorrect());
        assertTrue(game.GameOver());
    }

    /* -------------------------
       Three incorrect
       ------------------------- */
    @Test
    void testThreeIncorrect() {
        Sonnet game = new Sonnet(SONNET);

        System.setIn(new ByteArrayInputStream("wrong\n".getBytes()));
        game.PlayIndexRound(0);

        System.setIn(new ByteArrayInputStream("wrong\n".getBytes()));
        game.PlayIndexRound(1);

        System.setIn(new ByteArrayInputStream("wrong\n".getBytes()));
        game.PlayIndexRound(2);

        assertEquals(3, game.getIncorrect());
        assertTrue(game.GameOver());
    }
}
