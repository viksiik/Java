import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FindAscendingWordsTest {

    @Test
    public void testFindAscendingWords() {
        String[] words = {"abc", "xyz", "cba", "mnop", "abb", "a"};
        ArrayList<String> result = Main.findAscendingWords(words);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("abc");
        expected.add("xyz");
        expected.add("mnop");
        expected.add("a");

        assertEquals(expected, result);
    }

    @Test
    public void testFindAscendingWordsEmptyArray() {
        String[] words = {};
        ArrayList<String> result = Main.findAscendingWords(words);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindAscendingWordsNoAscendingWords() {
        String[] words = {"cba", "zxy", "bba"};
        ArrayList<String> result = Main.findAscendingWords(words);

        assertTrue(result.isEmpty());
    }
}
