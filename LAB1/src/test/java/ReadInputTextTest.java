import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;

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
