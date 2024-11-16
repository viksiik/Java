import java.util.HashMap;
import java.util.Map;

public class Translator {
    private Map<String, String> dictionary;

    public Translator() {
        dictionary = new HashMap<>(16, 0.75f);
    }

    public void addWord(String english, String ukrainian) {
        dictionary.put(english.toLowerCase(), ukrainian.toLowerCase());
    }

    public String translatePhrase(String phrase) {
        StringBuilder translatedPhrase = new StringBuilder();
        String[] words = phrase.toLowerCase().split(" ");

        for (String word : words) {
            String translatedWord = dictionary.getOrDefault(word, "[" + word + "]");
            translatedPhrase.append(translatedWord).append(" ");
        }

        return translatedPhrase.toString().trim();
    }

    public void addDefaultWords() {
        addWord("hello", "привіт");
        addWord("hello", "вітаю");
        addWord("everybody", "усі");
        addWord("how", "як");
        addWord("are", "є");
        addWord("you", "ти");
    }
}