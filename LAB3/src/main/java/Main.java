import java.util.Random;

//Напишіть консольний додаток, використовуючи архітектурний шаблон
//MVC, який:
//    описує інтерфейс Drawable з методом побудови фігури draw();
//    описує абстрактний клас Shape, який реалізує інтерфейс Drawable і
//містить поле shapeColor типу String для кольору фігури і конструктор
//для його ініціалізації, абстрактний метод обчислення площі фігури
//calcArea() і перевизначений метод toString();
//     описує класи Rectangle, Triangle, Circle, які успадковуються від класу
//Shape і реалізують метод calcArea (), а також перевизначають метод
//toString ();
//     створює набір даних типу Shape (масив розмірністю не менш 10
//        елементів);
//     обробляє масив:
//          - відображає набір даних;
//          - обчислює сумарну площу всіх фігур набору даних;
//          - обчислює сумарну площу фігур заданого виду;
//          - впорядковує набір даних щодо збільшення площі фігур,
//використовуючи об'єкт інтерфейсу Comparator;
//          - впорядковує набір даних за кольором фігур, використовуючи об'єкт
//інтерфейсу Comparator.
//Значення для ініціалізації об'єктів вибираються з заздалегідь підготовлених
//даних (обраних випадковим чином або по порядку проходження).

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Black"};
        Random random = new Random();

        for (int i = 0; i < shapes.length; i++) {
            String color = colors[random.nextInt(colors.length)];
            switch (random.nextInt(3)) {
                case 0:
                    shapes[i] = new Rectangle(color, random.nextDouble() * 10, random.nextDouble() * 10);
                    break;
                case 1:
                    shapes[i] = new Triangle(color, random.nextDouble() * 10, random.nextDouble() * 10);
                    break;
                case 2:
                    shapes[i] = new Circle(color, random.nextDouble() * 10);
                    break;
            }
        }

        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);

        System.out.println("---All Shapes:---");
        controller.displayAllShapes();

        controller.calculateTotalArea();
        controller.calculateTotalAreaByType("Circle");

        System.out.println("\n---Shapes sorted by area:---");
        controller.sortShapesByArea();
        controller.displayAllShapes();

        System.out.println("\n---Shapes sorted by color:---");
        controller.sortShapesByColor();
        controller.displayAllShapes();

    }
}
