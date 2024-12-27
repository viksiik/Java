import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ResourceBundle;

public class Rectangle extends Shape implements Serializable {
    private double height;
    private double width;
    private String localizedRectangle;
    private String localizedColor;
    private String localizedHeight;
    private String localizedWidth;
    private String localizedArea;
    private String localizedDrawingRectangle;

    public Rectangle(String shapeColor, double height, double width, ResourceBundle bundle) {
        super(shapeColor);
        this.height = height;
        this.width = width;

        this.localizedRectangle = bundle.getString("rectangle");
        this.localizedColor = bundle.getString("color");
        this.localizedHeight = bundle.getString("height");
        this.localizedWidth = bundle.getString("width");
        this.localizedArea = bundle.getString("area");
        this.localizedDrawingRectangle = bundle.getString("drawing_rectangle");
    }

    @Override
    public double calcArea() {
        return height * width;
    }

    @Override
    public void draw() {
        Logger logger = LoggerConfig.getLogger();
        logger.debug(localizedDrawingRectangle);
        System.out.println(localizedDrawingRectangle + ": \n" + toString());
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s, %s: %.2f, %s: %.2f, %s: %.2f",
                localizedRectangle,
                localizedColor, shapeColor,
                localizedHeight, height,
                localizedWidth, width,
                localizedArea, calcArea());
    }
}
