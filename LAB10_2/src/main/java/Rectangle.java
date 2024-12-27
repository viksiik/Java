//     описує класи Rectangle, Triangle, Circle, які успадковуються від класу
//Shape і реалізують метод calcArea (), а також перевизначають метод
//toString ();

import java.io.Serializable;
import org.apache.log4j.Logger;

public class Rectangle extends Shape implements Serializable {
    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public void draw() {
        Logger logger = LoggerConfig.getLogger();
        logger.debug("Drawing Rectangle");
        System.out.println("Drawing Rectangle: \n" + toString());
    }

    @Override
    public String toString() {
        return String.format("Rectangle, color: %s, width: %.2f, height: %.2f, area: %.2f",
                shapeColor, width, height, calcArea());
    }
}
