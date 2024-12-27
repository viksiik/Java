import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ResourceBundle;

//     обробляє масив:
//          - відображає набір даних;
//          - обчислює сумарну площу всіх фігур набору даних;
//          - обчислює сумарну площу фігур заданого виду;
//          - впорядковує набір даних щодо збільшення площі фігур,
//використовуючи об'єкт інтерфейсу Comparator;
//          - впорядковує набір даних за кольором фігур, використовуючи об'єкт
//інтерфейсу Comparator.

public class ShapeController {
    private static final Logger logger = LoggerConfig.getLogger();
    private Shape[] model;
    private ShapeView view;
    private ResourceBundle bundle;

    public ShapeController(Shape[] model, ShapeView view, ResourceBundle bundle) {
        this.model = model;
        this.view = view;
        logger.info("ShapeController initialized");
        this.bundle = bundle;
    }

    public void displayAllShapes() {
        view.displayShapes(model);
    }

    public double calculateTotalArea() {
        double totalArea = Arrays.stream(model).mapToDouble(Shape::calcArea).sum();
        view.displayTotalArea(totalArea);
        logger.debug("Calculating total area");
        return totalArea;
    }

    public double calculateTotalAreaByType(String typeName) {
        double totalArea = Arrays.stream(model)
                .filter(shape -> shape.getClass().getSimpleName().equalsIgnoreCase(typeName))
                .mapToDouble(Shape::calcArea)
                .sum();

        if (typeName.equals("Rectangle")) {
            System.out.printf("%s \"%s\": %.2f%n", bundle.getString("total_area_of"), bundle.getString("rectangle"), totalArea);
        }
        else if (typeName.equals("Circle")) {
            System.out.printf("%s \"%s\": %.2f%n", bundle.getString("total_area_of"), bundle.getString("circle"), totalArea);
        }
        else if (typeName.equals("Triangle")) {
            System.out.printf("%s \"%s\": %.2f%n", bundle.getString("total_area_of"), bundle.getString("triangle"), totalArea);
        }
        else {
            System.out.println("Unknown type: " + typeName);
        }
        logger.debug("Calculating total area by type: " + typeName);

        return totalArea;
    }

    public void sortShapesByArea() {
        Arrays.sort(model, Comparator.comparingDouble(Shape::calcArea));
        logger.debug("Sorting shapes by area");
    }

    public void sortShapesByColor() {
        Arrays.sort(model, Comparator.comparing(shape -> shape.shapeColor));
        logger.debug("Sorting shapes by color");
    }
}
