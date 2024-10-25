
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class ShapeControllerTest {
    private ShapeController shapeController;
    private Shape[] model;
    private ShapeView view;

    @BeforeEach
    void setUp() {
        view = new ShapeView();
        model = new Shape[]{
                new Circle("Red", 5),
                new Rectangle("Blue", 4, 6),
                new Circle("Green", 3),
                new Rectangle("Red", 2, 8)
        };
        shapeController = new ShapeController(model, view);
    }

    @Test
    void testCalculateTotalArea() {
        double expectedTotalArea = Arrays.stream(model).mapToDouble(Shape::calcArea).sum();
        double actualTotalArea = shapeController.calculateTotalArea();
        assertEquals(expectedTotalArea, actualTotalArea, 0.0001);
    }


    @Test
    void testCalculateTotalAreaByType() {
        double expectedTotalArea = Arrays.stream(model)
                .filter(shape -> shape instanceof Circle)
                .mapToDouble(Shape::calcArea)
                .sum();

        double actualTotalArea = shapeController.calculateTotalAreaByType("Circle");

        assertEquals(expectedTotalArea, actualTotalArea, 0.0001, "Total area calculation for Circles is incorrect");
    }


    @Test
    void testSortShapesByArea() {
        shapeController.sortShapesByArea();
        for (int i = 0; i < model.length - 1; i++) {
            assertTrue(model[i].calcArea() <= model[i + 1].calcArea());
        }
    }

    @Test
    void testSortShapesByColor() {
        shapeController.sortShapesByColor();
        for (int i = 0; i < model.length - 1; i++) {
            assertTrue(model[i].shapeColor.compareTo(model[i + 1].shapeColor) <= 0);
        }
    }


}
