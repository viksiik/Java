import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Translator translator = new Translator();

    public static void main(String[] args) {

        translator.addDefaultWords();

        System.out.println("Dictionary already has some default words.");

        enterMoreWords();

        System.out.print("Enter english phrase to translate: ");
        String phrase = scanner.nextLine();
        String translatedPhrase = translator.translatePhrase(phrase);
        System.out.println("Translation: " + translatedPhrase);

        scanner.close();
    }

    public static void enterMoreWords() {
        char choice;
        do {
            System.out.println("Do you want to add one more? (y/n)");
            choice = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();

            if (choice == 'y') {
                System.out.print("Enter english word: ");
                String englishWord = scanner.nextLine();
                System.out.print("Enter ukrainian translation: ");
                String ukrainianWord = scanner.nextLine();
                translator.addWord(englishWord, ukrainianWord);
                System.out.println("Word added.");
            } else if (choice != 'n') {
                System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 'n');
    }
}
