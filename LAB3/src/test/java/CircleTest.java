import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class CircleTest {
    @Test
    public void CircleAreaTest() {
        Circle circle = new Circle("Green", 4);
        double expectedResult = 4 * 4 * Math.PI;
        double result = circle.calcArea();

        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    void testToString() {
        Circle circle = new Circle("Green", 7);
        String expectedString = "Circle, color: Green, radius: 7.0, area: " + circle.calcArea();
        assertEquals(expectedString, circle.toString());
    }


}
