
//Відкрийте код 5-ї лаби із завданням 5.2 або 5.3 (в крайньому випадку –
//якоїсь іншої) і внесіть наступні зміни:
//- додайте систему логування для фіксації ходу виконання програми та
//виведення повідомлень про помилки в консоль;
//- додайте вивід повідомлень в текстовий файл.
//Примітка: продемонструйте роботу системи логування з урахуванням
//рівня реєстратора і використовуваного методу виведення (тобто щоб не всі
//        повідомлення дійшли до пункту призначення).

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Black"};
        Random random = new Random();
        IOFile file = new IOFile();

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
            file.writeIntoFile(shapes[i]);
        }

        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);

        System.out.println("-------------------------");
        System.out.println("---All Shapes:---");
        file.readFromFile();
        System.out.println("-------------------------");

        System.out.println("\n-------------------------");
        controller.calculateTotalArea();
        controller.calculateTotalAreaByType("Circle");
        System.out.println("-------------------------");

        System.out.println("\n-------------------------");
        System.out.println("---Shapes sorted by area:---");
        controller.sortShapesByArea();
        controller.displayAllShapes();
        System.out.println("-------------------------");

        System.out.println("\n-------------------------");
        System.out.println("---Shapes sorted by color:---");
        controller.sortShapesByColor();
        controller.displayAllShapes();
        System.out.println("-------------------------");

    }
}