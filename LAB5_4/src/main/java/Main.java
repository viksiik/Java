//Підрахувати частоту, з якою зустрічаються теги на сторінці по URL
//        (URL на ваш вибір).
//a. Вивести результати наступним чином: в порядку зростання
//для тегів в лексикографічному порядку
//b. Вивести результати наступним чином: в порядку зростання по
//частоті появи тегів
//        ВИМОГИ
//1. Передбачте можливість введення розташування та ім’я файлу для
//збереження даних.
//        2. Використовуйте об'єктні потоки для роботи з файлом.
//        3. Застосуйте серіалізацію за замовчуванням для роботи з файлами.
//        4. Виділіть роботу з файлами в окремий клас.
//5. Дані для пошуку інформації в наборі даних повинні вводитися
//набором з клавіатури

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String url = scanner.nextLine();

        List<String> tags = TagCounter.fetchTags(url);
        Map<String, Integer> tagCount = TagCounter.countTags(tags);

        TagCounter.sortTagsLexicographically(tagCount);
        TagCounter.sortTagsByFrequency(tagCount);

        TagCounter.printFile();
    }

}
