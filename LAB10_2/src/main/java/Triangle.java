//     описує класи Rectangle, Triangle, Circle, які успадковуються від класу
//Shape і реалізують метод calcArea (), а також перевизначають метод
//toString ();

import java.io.Serializable;
import org.apache.log4j.Logger;

public class Triangle extends Shape implements Serializable {
    private double base;
    private double height;

    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        Logger logger = LoggerConfig.getLogger();
        logger.debug("Drawing Triangle");
        System.out.println("Drawing Triangle: \n" + toString());
    }

    @Override
    public String toString() {
        return String.format("Triangle, color: %s, base: %.2f, height: %.2f, area: %.2f",
                shapeColor, base, height, calcArea());

    }
}
