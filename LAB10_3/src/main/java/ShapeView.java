import org.apache.log4j.Logger;
import java.util.ResourceBundle;

public class ShapeView {
    private static final Logger logger = (Logger) LoggerConfig.getLogger();
    private ResourceBundle bundle;

    public ShapeView(ResourceBundle bundle) {
        this.bundle = bundle;
    }


    public void displayShape(Shape shape) {
        System.out.println(shape);
    }

    public void displayTotalArea(double totalArea) {
        System.out.printf("%s: %.2f%n", bundle.getString("total_area"), totalArea);
        logger.trace("Total area of all shapes: " + totalArea);
    }

    public void displayShapes(Shape[] shapes) {
        if (shapes == null) {
            logger.warn("No shapes to display");
        } else {
            for (Shape shape : shapes) {
                displayShape(shape);
            }
        }
        logger.info("Shapes displayed successfully");
    }
}
