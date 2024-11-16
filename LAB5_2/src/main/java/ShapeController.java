import java.util.Arrays;
import java.util.Comparator;

//     обробляє масив:
//          - відображає набір даних;
//          - обчислює сумарну площу всіх фігур набору даних;
//          - обчислює сумарну площу фігур заданого виду;
//          - впорядковує набір даних щодо збільшення площі фігур,
//використовуючи об'єкт інтерфейсу Comparator;
//          - впорядковує набір даних за кольором фігур, використовуючи об'єкт
//інтерфейсу Comparator.

public class ShapeController {
    private Shape[] model;
    private ShapeView view;

    public ShapeController(Shape[] model, ShapeView view) {
        this.model = model;
        this.view = view;
    }

    public void displayAllShapes() {
        view.displayShapes(model);
    }

    public double calculateTotalArea() {
        double totalArea = Arrays.stream(model).mapToDouble(Shape::calcArea).sum();
        view.displayTotalArea(totalArea);
        return totalArea;
    }

    public double calculateTotalAreaByType(String typeName) {
        double totalArea = Arrays.stream(model)
                .filter(shape -> shape.getClass().getSimpleName().equalsIgnoreCase(typeName))
                .mapToDouble(Shape::calcArea)
                .sum();
        System.out.printf("Total area of " + typeName + "s: " + "%.2f%n", totalArea);
        return totalArea;
    }

    public void sortShapesByArea() {
        Arrays.sort(model, Comparator.comparingDouble(Shape::calcArea));
    }

    public void sortShapesByColor() {
        Arrays.sort(model, Comparator.comparing(shape -> shape.shapeColor));
    }
}
