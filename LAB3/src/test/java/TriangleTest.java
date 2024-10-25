import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void TriangleAreaTest() {
        Triangle triangle = new Triangle("Green", 6, 3);
        double expectedResult = 6 * 3 * 0.5;
        double result = triangle.calcArea();

        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    void testToString() {
        Triangle triangle = new Triangle("Red", 7, 5);
        String expectedString = "Triangle, color: Red, base: 7.0, height: 5.0, area: " + triangle.calcArea();
        assertEquals(expectedString, triangle.toString());
    }

}

