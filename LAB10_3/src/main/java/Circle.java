import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ResourceBundle;

public class Circle extends Shape implements Serializable {
    private double radius;
    private String localizedCircle;
    private String localizedColor;
    private String localizedRadius;
    private String localizedArea;
    private String localizedDrawingCircle;

    public Circle(String shapeColor, double radius, ResourceBundle bundle) {
        super(shapeColor);
        this.radius = radius;

        this.localizedCircle = bundle.getString("circle");
        this.localizedColor = bundle.getString("color");
        this.localizedRadius = bundle.getString("radius");
        this.localizedArea = bundle.getString("area");
        this.localizedDrawingCircle = bundle.getString("drawing_circle");
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        Logger logger = LoggerConfig.getLogger();
        logger.debug(localizedDrawingCircle);
        System.out.println(localizedDrawingCircle + ": \n" + toString());
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s, %s: %.2f, %s: %.2f",
                localizedCircle,
                localizedColor, shapeColor,
                localizedRadius, radius,
                localizedArea, calcArea());
    }
}
