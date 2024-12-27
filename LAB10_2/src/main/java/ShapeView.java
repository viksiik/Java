import org.apache.log4j.Logger;

public class ShapeView {
    private static final Logger logger = (Logger) LoggerConfig.getLogger();

    public void displayShape(Shape shape) {
        System.out.println(shape);
    }

    public void displayTotalArea(double totalArea) {
        System.out.printf("Total area of all shapes: " + "%.2f%n", totalArea);
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
