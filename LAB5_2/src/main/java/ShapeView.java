public class ShapeView {

    public void displayShape(Shape shape) {
        System.out.println(shape);
    }

    public void displayTotalArea(double totalArea) {
        System.out.printf("Total area of all shapes: " + "%.2f%n", totalArea);
    }

    public void displayShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            displayShape(shape);
        }
    }
}
