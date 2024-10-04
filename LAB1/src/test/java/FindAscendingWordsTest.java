import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

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
