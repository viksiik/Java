//    описує абстрактний клас Shape, який реалізує інтерфейс Drawable і
//містить поле shapeColor типу String для кольору фігури і конструктор
//для його ініціалізації, абстрактний метод обчислення площі фігури
//calcArea() і перевизначений метод toString();

import java.io.Serializable;

public abstract class Shape implements Serializable {

    String shapeColor;

    public Shape(String shapeColor){
        this.shapeColor = shapeColor;
    }

    abstract double calcArea();

    public abstract void draw();

    @Override
    public String toString() {
        return "Shape color:" + shapeColor;
    }
}
