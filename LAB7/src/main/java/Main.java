import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
* Знайти слова, символи в яких йдуть в порядку зростання їх кодів. На вхід поступає
рядок із словами. На виході – масив String.
* Відповідно до номера в списку (алгоритм описаний в першої лабораторній),
реалізувати такі завдання за допомогою lambda
* */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "y";

        do {
            String text = readInputText();
            String[] words = text.split(" ");
            ArrayList<String> ascendingWords = (ArrayList<String>) Arrays.stream(words)
                    .filter(word -> hasAllAscendingChars(word))
                    .collect(Collectors.toList());
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
        Arrays.stream(words)
                .filter(Main::hasAllAscendingChars)
                .forEach(word -> ascendingWords.add(word));
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
        List<String> words = List.of("Words");
        words.forEach(s -> System.out.println(s + ": "));

        for (int i = 0; i < ascendingWords.size(); i++) {
            System.out.print(ascendingWords.get(i));
            if (i < ascendingWords.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
