//Напишіть програму, яка отримає рядок з максимальною кількістю
//слів із заданого файлу
//ВИМОГИ
//1. Передбачте можливість введення розташування та ім’я файлу для
//збереження даних.
//2. Використовуйте об'єктні потоки для роботи з файлом.
//3. Застосуйте серіалізацію за замовчуванням для роботи з файлами.
//4. Виділіть роботу з файлами в окремий клас.
//5. Дані для пошуку інформації в наборі даних повинні вводитися
//набором з клавіатури.

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOFile implements Serializable{
    ObjectOutputStream writer;
    ObjectInputStream reader;
    Scanner scanner;
    String filename;
    String filepath;

    public IOFile() {
        filename = inputFilename();
        filepath = inputPath();
        this.filename = filename;
        this.filepath = filepath;


    }

    public void writeIntoFile() {
        String input;
        System.out.println("Please enter a text (enter \"exit\" to exit): ");
        try {
            writer = new ObjectOutputStream(new FileOutputStream(filepath+filename));
            do {
                input = inputInfo();

                if (!input.equalsIgnoreCase("exit")) {
                    writer.writeObject(input);
                    writer.flush();
                }
            } while(!input.equalsIgnoreCase("exit"));
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String inputInfo() {
        String info;
        scanner = new Scanner(System.in);
        info = scanner.nextLine();
        return info;
    }

    public String inputFilename() {
        System.out.println("Enter the filename (without extension): ");
        String filename;
        scanner = new Scanner(System.in);
        filename = scanner.nextLine();
        return filename + ".ser";
    }

    public String inputPath() {
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

    public ArrayList<String> readFromFile() {
        ArrayList<String> lines = new ArrayList<>();

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filepath+filename))) {
            Object input;
            while (true) {
                try {
                    input = reader.readObject();
                    System.out.println(input);
                    lines.add((String)input);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return lines;
    }

    public void findMaxWords(ArrayList<String> lines) {
        String maxLine = "";
        int maxWords = 0;

        for (String line : lines) {
            int wordCount = line.split("\\s+").length;
            if (wordCount > maxWords) {
                maxWords = wordCount;
                maxLine = line;
            }
        }
        System.out.println("------------------------");
        System.out.println("Line with max words: " + maxLine);
        System.out.println("Max words: " + maxWords);
        System.out.println("------------------------");

    }
}
