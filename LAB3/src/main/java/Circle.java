//     описує класи Rectangle, Triangle, Circle, які успадковуються від класу
//Shape і реалізують метод calcArea (), а також перевизначають метод
//toString ();

public class Circle extends Shape{
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
        return "Circle, color: " + shapeColor +
                ", radius: " + radius + ", area: " + calcArea();
    }
}
