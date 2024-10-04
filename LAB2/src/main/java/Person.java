import java.util.Objects;

/*
* Крок 1. Реалізувати метод equals для класу Person у якого є декілька полів
(прізвище, ім’я, вік).
Крок 2. Реалізуйте наступний сценарій:
a. Створіть екземпляр Person
b. Конвертуйте його в JSON*
c. Конвертуйте назад в об’єкт*
d. Перевірте equals-ом початковий і одержаний об'єкт
* */

public class Person {
    private String name;
    private String lastName;
    private int age;
    private String gender;

    public Person(String name, String lastName, int age, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return age == person.age &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender);
    }

    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
