import java.util.ArrayList;
import java.util.Scanner;

/*
* Знайти слова, символи в яких йдуть в порядку зростання їх кодів. На вхід поступає
рядок із словами. На виході – масив String.
* */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "y";

        do {
            String text = readInputText();
            String[] words = text.split(" ");
            ArrayList<String> ascendingWords = findAscendingWords(words);
            printWords(ascendingWords);

            System.out.println("Do you want to continue? (y/n)");
            choice = scanner.nextLine();

            while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Try again.");
                choice = scanner.nextLine();
            }


        } while (choice.equalsIgnoreCase("y"));
        scanner.close();
    }

    public static String readInputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text: ");
        return scanner.nextLine();
    }

    public static ArrayList<String> findAscendingWords(String[] words) {
        ArrayList<String> ascendingWords = new ArrayList<>();
        for (String word : words) {
            if (hasAllAscendingChars(word)) {
                ascendingWords.add(word);
            }
        }
        return ascendingWords;
    }

    public static boolean hasAllAscendingChars(String word) {
        if (word.length() < 2) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void printWords(ArrayList<String> ascendingWords) {
        for (int i = 0; i < ascendingWords.size(); i++) {
            System.out.print(ascendingWords.get(i));
            if (i < ascendingWords.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
