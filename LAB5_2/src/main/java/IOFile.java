import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOFile implements Serializable {
    ObjectOutputStream writer;
    ObjectInputStream reader;
    Scanner scanner;
    String filename;
    String filepath;

    public IOFile() {
        filename = inputFilename();
        filepath = inputPath();
        this.filename = "test2.ser";
        this.filepath = "D:\\kpi\\java\\";
        clearFile();
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

    public void clearFile() {
        File file = new File(filepath+filename);
        if (file.exists()) {
            try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filepath + filename))) {
                System.out.println("Ready to work!");
            } catch (IOException e) {
                System.out.println("Error clearing the file: " + e.getMessage());
            }
        }
    }

    public void writeIntoFile(Shape content) {
        try (FileOutputStream fileWriter = new FileOutputStream(filepath+filename, true);
             ObjectOutputStream writer = isFileEmpty() ? new ObjectOutputStream(fileWriter)
                     : new AppendableObjectOutputStream(fileWriter)) {

            writer.writeObject(content);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile() {
        List<Shape> shapes = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filepath + filename))) {
            while (true) {
                try {
                    Object input = reader.readObject();
                    shapes.add((Shape) input);
                    System.out.println(input);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

    }

    private boolean isFileEmpty() {
        File file = new File(filepath+filename);
        return file.length() == 0;
    }
}
