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
        this.filename = "test2.ser";
        this.filepath = "D:\\kpi\\java\\";
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
