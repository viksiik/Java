import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void RectangleAreaTest() {
        Rectangle rectangle = new Rectangle("Green", 5, 5);
        double expectedResult = 5 * 5;
        double result = rectangle.calcArea();

        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    void testToString() {
        Rectangle rectangle = new Rectangle("Yellow", 5, 5);
        String expectedString = "Rectangle, color: Yellow, width: 5.0, height: 5.0, area: " + rectangle.calcArea();
        assertEquals(expectedString, rectangle.toString());
    }

}

