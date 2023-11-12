package basic.lab3.task2;

public class Human {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;

    public Human(
            String firstName,
            String lastName,
            int age,
            Gender gender
    ) throws Exception {
        if (age < 0) {
            throw new Exception("Age must be equal or greater than 0.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", age=" + this.getAge() +
                ", gender=" + this.getGender();
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
