package basic.lab3.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test()
    @DisplayName("All classes of `Human` should create correctly.")
    void testClassCreation() throws Exception {
        String firstName = "Andrii";
        String lastName = "Laskevych";
        int age = 30;
        Human.Gender gender = Human.Gender.MALE;
        Citizen.Nationality nationality = Citizen.Nationality.UKRAINIAN;
        String university = "NTU 'KhPI'";
        String company = "OWOX";
        String position = "Software Engineer";

        Human human = new Human(firstName, lastName, age, gender);
        Citizen citizen = new Citizen(firstName, lastName, age, gender, nationality);
        Employee employee = new Employee(firstName, lastName, age, gender, nationality, company, position);
        Student student = new Student(firstName, lastName, age, gender, nationality, university);

        Human[] persons = {human, citizen, student, employee};

        for (Human person : persons) {
            Assertions.assertTrue(person.toString().indexOf("firstName") > 0);
            Assertions.assertTrue(person.toString().indexOf("lastName") > 0);
            Assertions.assertTrue(person.toString().indexOf("age") > 0);
            Assertions.assertTrue(person.toString().indexOf("gender") > 0);

            if (person instanceof Citizen) {
                Assertions.assertTrue(person.toString().indexOf("nationality") > 0);
            }

            if (person instanceof Employee) {
                Assertions.assertTrue(person.toString().indexOf("nationality") > 0);
                Assertions.assertTrue(person.toString().indexOf("company") > 0);
                Assertions.assertTrue(person.toString().indexOf("position") > 0);
            }

            if (person instanceof Student) {
                Assertions.assertTrue(person.toString().indexOf("nationality") > 0);
                Assertions.assertTrue(person.toString().indexOf("university") > 0);
            }
        }
    }
}
