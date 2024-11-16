//Підрахувати частоту, з якою зустрічаються теги на сторінці по URL
//        (URL на ваш вибір).
//        a. Вивести результати наступним чином: в порядку зростання
//        для тегів в лексикографічному порядку
//        b. Вивести результати наступним чином: в порядку зростання по
//        частоті появи тегів
//        ВИМОГИ
//        1. Передбачте можливість введення розташування та ім’я файлу для
//        збереження даних.
//        2. Використовуйте об'єктні потоки для роботи з файлом.
//        3. Застосуйте серіалізацію за замовчуванням для роботи з файлами.
//        4. Виділіть роботу з файлами в окремий клас.
//        5. Дані для пошуку інформації в наборі даних повинні вводитися
//        набором з клавіатури.
//        6. Передбачте обробку коректності введення даних через блоки try catch


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.URL;
import java.util.*;

public class TagCounter {
    static IOFile file = new IOFile();

    public static List<String> fetchTags(String url) throws IOException {
        Document doc = Jsoup.parse(new URL(url), 10000);
        List<String> tags = new ArrayList<>();
        for (Element element : doc.getAllElements()) {
            tags.add(element.tagName());
        }
        return tags;
    }

    public static Map<String, Integer> countTags(List<String> tags) {
        Map<String, Integer> tagCount = new HashMap<>();

        for (String tag : tags) {
            tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
        }

        return tagCount;
    }

    public static void sortTagsLexicographically(Map<String, Integer> tagCount) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(tagCount.entrySet());

        sortedList.sort(Map.Entry.comparingByKey());

        file.writeIntoFile("\n---------Tags by lexicographical order---------");
        for (Map.Entry<String, Integer> entry : sortedList) {
            file.writeIntoFile(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static void sortTagsByFrequency(Map<String, Integer> tagCount) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(tagCount.entrySet());

        sortedList.sort(Map.Entry.comparingByValue());

        file.writeIntoFile("\n---------Tags by frequency---------");
        for (Map.Entry<String, Integer> entry : sortedList) {
            file.writeIntoFile(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static void printFile() {
        file.readFromFile();
    }
}