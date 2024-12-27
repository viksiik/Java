//Напишіть консольний додаток, який:
//- створює та ініціалізує змінну типу String;
//- використовує рефлексію для зміни значення створеного рядка (через
//  доступ до закритого поля char [] value класу String).
//- Рядок повинен бути створеним та проініціалізованим двома
//способами:
//   як строковий літерал;
//   введений набором з клавіатури.
//- Значення для заміни може бути задано програмно або введено набором з клавіатури.
//- Рядок повинен бути виведений до зміни і після.

import java.util.Scanner;


// java --add-opens java.base/java.lang=ALL-UNNAMED -cp . Main


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String runAgain = "y";

        do {
            try {
                char choice;
                do {
                    System.out.println("Do you want to enter specified strings or use default ones (s/d): ");

                    choice = scanner.nextLine().charAt(0);
                    choice = Character.toLowerCase(choice);

                    if (choice == 's') {
                        System.out.println("Enter a string: ");
                        String inputString = scanner.nextLine();

                        System.out.println("Enter new string to edit with:");
                        String newValue = scanner.nextLine();

                        System.out.println("String before editing: " + inputString);
                        StringModifier.modifyStringValue(inputString, newValue);
                        System.out.println("String after editing: " + inputString);

                    } else if (choice == 'd') {
                        String literalString = "First string";
                        System.out.println("The string literal before editing: " + literalString);

                        StringModifier.modifyStringValue(literalString, "Modified String");
                        System.out.println("The string literal after editing: " + literalString);
                    } else {
                        System.out.println("Invalid choice, please try again.");
                    }
                } while (choice != 's' && choice != 'd');

                System.out.println("\nDo you want to continue? (y/n)");
                runAgain = scanner.nextLine();

                while ( !runAgain.equalsIgnoreCase("y") &&
                        !runAgain.equalsIgnoreCase("n")) {
                    System.out.println("Invalid input. Try again.");
                    runAgain = scanner.nextLine();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (runAgain.equalsIgnoreCase("y"));
    }
}