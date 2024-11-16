import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;
    private Translator translator;

    @BeforeEach
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        translator = new Translator();
        translator.addDefaultWords();
        Main.translator = translator;
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testAddWordAndTranslatePhrase() {
        String simulatedInput = "y\nworld\nсвіт\nn\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Main.scanner = new Scanner(System.in);

        Main.enterMoreWords();

        String translatedPhrase = translator.translatePhrase("hello world");
        assertEquals("привіт світ", translatedPhrase);
    }

    @Test
    public void testTranslatePhraseWithDefaultWords() {
        String simulatedInput = "hello everybody";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Main.scanner = new Scanner(System.in);

        String translatedPhrase = translator.translatePhrase("hello everybody");
        assertEquals("привіт усі", translatedPhrase);
    }

    @Test
    public void testEnterMoreWordsInvalidChoice() {
        String simulatedInput = "z\ny\nmoon\nмісяць\nn\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Main.scanner = new Scanner(System.in);

        Main.enterMoreWords();

        String output = testOut.toString();
        assert(output.contains("Invalid choice, please try again."));
        assertEquals("місяць", translator.translatePhrase("moon"));
    }
}
