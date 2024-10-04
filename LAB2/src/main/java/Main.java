import com.google.gson.Gson;

/*
* Крок 1. Реалізувати метод equals для класу Person у якого є декілька полів
(прізвище, ім’я, вік).
Крок 2. Реалізуйте наступний сценарій:
a. Створіть екземпляр Person
b. Конвертуйте його в JSON*
c. Конвертуйте назад в об’єкт*
d. Перевірте equals-ом початковий і одержаний об'єкт
* */

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Petrenko", "Petro", 15, "m");

        Gson gson = new Gson();
        String personJson = gson.toJson(person1);

        System.out.println("Original: " + person1);
        System.out.println("JSON: " + personJson);

        Person personFromJson = gson.fromJson(personJson, Person.class);

        if (person1.equals(personFromJson)) {
            System.out.println("Equal");
        }
        else {
            System.out.println("Not equal.");
        }
    }
}

