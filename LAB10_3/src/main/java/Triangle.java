import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ResourceBundle;

public class Triangle extends Shape implements Serializable {
    private double height;
    private double base;
    private String localizedTriangle;
    private String localizedColor;
    private String localizedHeight;
    private String localizedBase;
    private String localizedArea;
    private String localizedDrawingTriangle;

    public Triangle(String shapeColor, double height, double base, ResourceBundle bundle) {
        super(shapeColor);
        this.height = height;
        this.base = base;

        this.localizedTriangle = bundle.getString("triangle");
        this.localizedColor = bundle.getString("color");
        this.localizedHeight = bundle.getString("height");
        this.localizedBase = bundle.getString("base");
        this.localizedArea = bundle.getString("area");
        this.localizedDrawingTriangle = bundle.getString("drawing_triangle");
    }

    @Override
    public double calcArea() {
        return 0.5 * height * base;
    }

    @Override
    public void draw() {
        Logger logger = LoggerConfig.getLogger();
        logger.debug(localizedDrawingTriangle);
        System.out.println(localizedDrawingTriangle + ": \n" + toString());
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s, %s: %.2f, %s: %.2f, %s: %.2f",
                localizedTriangle,
                localizedColor, shapeColor,
                localizedHeight, height,
                localizedBase, base,
                localizedArea, calcArea());
    }
}
