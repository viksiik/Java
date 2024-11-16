import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class ReadInputTextTest {

    @Test
    public void testReadInputText() {

        String simulatedInput = "hello world\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        String result = Main.readInputText();

        assertEquals("hello world", result);
        System.setIn(System.in);
    }
}
