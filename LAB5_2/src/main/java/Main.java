import java.util.Random;

//Відкрийте код додатка за завданням Task 3 Simple OOP і внесіть
//наступні зміни
//        - додайте в меню команду для збереження набору об'єктів в файл;
//        - передбачте можливість читання набору об'єктів з файлу.

//ВИМОГИ
//1. Передбачте можливість введення розташування та ім’я файлу для
//збереження даних.
//2. Використовуйте об'єктні потоки для роботи з файлом.
//3. Застосуйте серіалізацію за замовчуванням для роботи з файлами.
//4. Виділіть роботу з файлами в окремий клас.
//5. Дані для пошуку інформації в наборі даних повинні вводитися
//набором з клавіатури.


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
