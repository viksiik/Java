//    описує абстрактний клас Shape, який реалізує інтерфейс Drawable і
//містить поле shapeColor типу String для кольору фігури і конструктор
//для його ініціалізації, абстрактний метод обчислення площі фігури
//calcArea() і перевизначений метод toString();

abstract class Shape implements Drawable{
    String shapeColor;

    public Shape(String shapeColor){
        this.shapeColor = shapeColor;
    }

    abstract double calcArea();

    @Override
    public String toString() {
        return "Shape color:" + shapeColor;
    }
}
