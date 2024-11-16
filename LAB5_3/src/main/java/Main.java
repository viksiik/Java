//Зашифрувати вхідний символьний потік за наступним алгоритмом:
//замінити кожний символ на такий, код якого більший на значення
//коду ключового символу. При виконанні завдання:
//a. Реалізувати метод, який реалізує шифрування
//b. Реалізувати метод, який реалізує дешифрування.
//c. Використати для розв’язання задачі потоки типу
//FilerOutputStream-FilterInputStream/FilterWriter-FilteredReader.


import java.util.Scanner;

public class Main {
    static Scanner scanner;

    public static void main(String[] args) {
        char key = 'K';
        String name = inputFilename();
        String path = inputPath();
        String originalText = inputInfo();

        EncryptionIO cipher = new EncryptionIO(key);

        cipher.encrypt(originalText, path+name);

        String decryptedText = cipher.decrypt(path+name);
    }

    private static String inputFilename() {
        System.out.println("Enter the filename (without extension): ");
        String filename;
        scanner = new Scanner(System.in);
        filename = scanner.nextLine();
        return filename + ".txt";
    }

    private static String inputPath() {
        String path;
        scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Do you want to enter specified path or use default one (s/d): ");
            choice = scanner.nextLine().charAt(0);
            choice = Character.toLowerCase(choice);

            if (choice == 's') {
                System.out.println("Enter the path to the file: ");
                System.out.println("Example: D:\\\\kpi\\\\example\\\\");
                path = scanner.nextLine();
            } else if (choice == 'd') {
                path = "D:\\kpi\\java\\";
            } else {
                System.out.println("Invalid choice, please try again.");
                path = "D:\\kpi\\java\\";
            }
        } while (choice != 's' && choice != 'd');

        return path;
    }

    private static String inputInfo() {
        System.out.println("Enter the text to encrypt: ");
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
