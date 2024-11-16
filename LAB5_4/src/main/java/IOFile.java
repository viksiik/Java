import java.io.*;
import java.util.Scanner;

class IOFile {
    String filename;
    String filepath;
    Scanner scanner;

    public IOFile() {
        filename = inputFilename();
        filepath = inputPath();
        this.filename = filename;
        this.filepath = filepath;
        clearFile();
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

    public void writeIntoFile(String data) {
        try (FileOutputStream fileWriter = new FileOutputStream(filepath+filename, true);
             ObjectOutputStream writer = isFileEmpty() ? new ObjectOutputStream(fileWriter)
                     : new AppendableObjectOutputStream(fileWriter)) {
            writer.writeObject(data);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error writing into the file: " + e.getMessage(), e);
        }
    }

    public void readFromFile() {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filepath+filename))) {
            Object input;
            while (true) {
                try {
                    input = reader.readObject();
                    System.out.println(input);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading error: " + e.getMessage());
        }
    }

    private boolean isFileEmpty() {
        File file = new File(filepath+filename);
        return file.length() == 0;
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
}
