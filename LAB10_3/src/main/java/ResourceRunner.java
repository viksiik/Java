import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ResourceRunner {

    ResourceRunner() {};

    public static void printMenu() {
        System.out.println("What language do you want to use?");
        System.out.println("1 – english");
        System.out.println("2 – українська");
        System.out.println("3 - deutsch");
        System.out.print("> ");
    }

    public static int inputCommand() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int com = sc.nextInt();
                if (com < 1 || com > 3)
                    throw new IOException();
                return com;
            } catch (IOException exp) {
                System.out.println("Error enter command!!! Repeat\n> ");
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1 and 3.");
                sc.next();
            }
        }
    }

    public static ResourceBundle getLocale(int choice) {
        Locale locale;
        if (choice == 1) {
            locale = new Locale("en", "US");
        } else if (choice == 2) {
            locale = new Locale("ua", "UA");
        } else if (choice == 3) {
            locale = new Locale("de", "DE");
        }
        else {
            System.out.println("Invalid choice. Defaulting to English.");
            locale = new Locale("en", "US");
        }

        ResourceBundle bundle;
        return bundle = ResourceBundle.getBundle("location.text", locale);
    }

}
