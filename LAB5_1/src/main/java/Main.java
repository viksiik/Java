import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list;
        IOFile file = new IOFile();
        file.writeIntoFile();

        list = file.readFromFile();
        file.findMaxWords(list);
    }
}