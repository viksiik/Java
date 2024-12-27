
//До попереднього завдання (10.2) – додайте в меню пункт «Вибір мови»
//        для можливості відображення інтерфейсу взаємодії з користувачем на
//        інших мовах.
//        Вимоги.
//        1. Використовуйте клас ResourceBundle для організації
//        інтернаціонального інтерфейсу.
//        2. Додайте в папку «resources» папку «location», в якій і розмістіть
//        файли з даними для різних мов

import java.util.ResourceBundle;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String runAgain = "y";

        do {
            try {
                Shape[] shapes = new Shape[10];

                ResourceRunner.printMenu();
                int command = ResourceRunner.inputCommand();
                ResourceBundle bundle = ResourceRunner.getLocale(command);

                String[] colors = {
                        bundle.getString("color1"),
                        bundle.getString("color2"),
                        bundle.getString("color3"),
                        bundle.getString("color4"),
                        bundle.getString("color5"),
                };

                Random random = new Random();
                IOFile file = new IOFile();

                for (int i = 0; i < shapes.length; i++) {
                    String color = colors[random.nextInt(colors.length)];
                    switch (random.nextInt(3)) {
                        case 0:
                            shapes[i] = new Rectangle(color, random.nextDouble() * 10, random.nextDouble() * 10, bundle);
                            break;
                        case 1:
                            shapes[i] = new Triangle(color, random.nextDouble() * 10, random.nextDouble() * 10, bundle);
                            break;
                        case 2:
                            shapes[i] = new Circle(color, random.nextDouble() * 10, bundle);
                            break;
                    }
                    file.writeIntoFile(shapes[i]);
                }

                ShapeView view = new ShapeView(bundle);
                ShapeController controller = new ShapeController(shapes, view, bundle);

                System.out.println("-------------------------");
                System.out.println(bundle.getString("all_shapes"));
                file.readFromFile();
                System.out.println("-------------------------");

                System.out.println("\n-------------------------");
                controller.calculateTotalArea();
                controller.calculateTotalAreaByType("Circle");
                System.out.println("-------------------------");

                System.out.println("\n-------------------------");
                System.out.println(bundle.getString("by_area"));
                controller.sortShapesByArea();
                controller.displayAllShapes();
                System.out.println("-------------------------");

                System.out.println("\n-------------------------");
                System.out.println(bundle.getString("by_color"));
                controller.sortShapesByColor();
                controller.displayAllShapes();
                System.out.println("-------------------------");

                System.out.println(bundle.getString("continue_run"));
                runAgain = scanner.nextLine();

                while ( !runAgain.equalsIgnoreCase("y") &&
                        !runAgain.equalsIgnoreCase("n")) {
                    System.out.println(bundle.getString("invalid_input"));
                    runAgain = scanner.nextLine();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        } while (runAgain.equalsIgnoreCase("y"));
    }
}