//     описує класи Rectangle, Triangle, Circle, які успадковуються від класу
//Shape і реалізують метод calcArea (), а також перевизначають метод
//toString ();

import java.io.Serializable;

public class Circle extends Shape implements Serializable {
    double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle: \n" + toString());
    }

    @Override
    public String toString() {
        return String.format("Circle, color: %s, radius: %.2f, area: %.2f", shapeColor, radius, calcArea());
    }

}
