public class ShapeView {
    public void displayShape(Shape shape) {
        System.out.println(shape);
    }

    public void displayTotalArea(double totalArea) {
        System.out.println("\nTotal area of all shapes: " + totalArea);
    }

    public void displayShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            displayShape(shape);
        }
    }
}
