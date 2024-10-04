import org.testng.annotations.Test;
import static org.junit.Assert.*;
//import java.util.Objects;

public class PersonTest {

    @Test
    public void testSamePerson() {
        Person samePerson = new Person("Robin", "Tiri", 15, "m");
        assertTrue(samePerson.equals(samePerson));
    }

    @Test
    public void testNullPerson() {
        Person nullPerson = new Person("Robin", "Tiri", 15, "m");
        assertFalse(nullPerson.equals(null));
    }

    @Test
    public void testDifferentPersonsName() {
        Person differentPerson1 = new Person("Robin", "Tiri", 15, "m");
        Person differentPerson2 = new Person("Wilson", "Tiri", 15, "m");
        assertFalse(differentPerson1.equals(differentPerson2));
    }

    @Test
    public void testDifferentPersonsLastName() {
        Person differentPerson1 = new Person("Robin", "Tiri", 15, "m");
        Person differentPerson2 = new Person("Robin", "Dloew", 15, "m");
        assertFalse(differentPerson1.equals(differentPerson2));
    }

    @Test
    public void testDifferentPersonsAge() {
        Person differentPerson1 = new Person("Robin", "Tiri", 15, "m");
        Person differentPerson2 = new Person("Wilson", "Tiri", 31, "m");
        assertFalse(differentPerson1.equals(differentPerson2));
    }

    @Test
    public void testDifferentPersonsGender() {
        Person differentPerson1 = new Person("Robin", "Tiri", 15, "m");
        Person differentPerson2 = new Person("Wilson", "Tiri", 15, "f");
        assertFalse(differentPerson1.equals(differentPerson2));
    }

    @Test
    public void testSamePersons() {
        Person samePerson1 = new Person("Robin", "Tiri", 15, "m");
        Person samePerson2 = new Person("Robin", "Tiri", 15, "m");
        assertTrue(samePerson1.equals(samePerson2));
    }

    @Test
    public void testDifferentClasses() {
        Person person1 = new Person("Robin", "Tiri", 15, "m");
        String person2 = "Robin Tiri";
        assertFalse(person1.equals(person2));
    }
}