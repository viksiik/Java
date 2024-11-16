import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {

    private Translator translator;

    @BeforeEach
    public void setUp() {
        translator = new Translator();
        translator.addDefaultWords();
    }

    @Test
    public void testAddWord() {
        translator.addWord("world", "світ");
        assertEquals("світ", translator.translatePhrase("world"));
    }

    @Test
    public void testTranslatePhraseWithAllKnownWords() {
        String result = translator.translatePhrase("hello everybody");
        assertEquals("привіт усі", result);
    }

    @Test
    public void testTranslatePhraseWithMixedWords() {
        String result = translator.translatePhrase("hello unknown world");
        assertEquals("привіт [unknown] [world]", result);
    }

    @Test
    public void testTranslatePhraseWithUnknownWords() {
        String result = translator.translatePhrase("unknown phrase");
        assertEquals("[unknown] [phrase]", result);
    }

    @Test
    public void testTranslateEmptyPhrase() {
        String result = translator.translatePhrase("");
        assertEquals("[]", result);
    }

    @Test
    public void testAddDefaultWords() {
        assertEquals("привіт", translator.translatePhrase("hello"));
        assertEquals("усі", translator.translatePhrase("everybody"));
        assertEquals("як", translator.translatePhrase("how"));
        assertEquals("є", translator.translatePhrase("are"));
        assertEquals("ти", translator.translatePhrase("you"));
    }

    @Test
    public void testTranslatePhraseInsensitivity() {
        String result = translator.translatePhrase("Hello EVERYBODY");
        assertEquals("привіт усі", result);
    }
}
