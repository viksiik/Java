import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasAllAscendingCharsTest {

    @Test
    public void testHasAllAscendingCharsTrueCase() {
        assertTrue(Main.hasAllAscendingChars("abc"));
        assertTrue(Main.hasAllAscendingChars("mnop"));
        assertTrue(Main.hasAllAscendingChars("a"));
    }

    @Test
    public void testHasAllAscendingCharsFalseCase() {
        assertFalse(Main.hasAllAscendingChars("cba"));
        assertFalse(Main.hasAllAscendingChars("abb"));
        assertFalse(Main.hasAllAscendingChars("zxy"));
    }

    @Test
    public void testHasAllAscendingCharsSingleChar() {
        assertTrue(Main.hasAllAscendingChars("a"));
        assertTrue(Main.hasAllAscendingChars("z"));
    }

    @Test
    public void testHasAllAscendingCharsEmptyString() {
        assertTrue(Main.hasAllAscendingChars(""));
    }
}



