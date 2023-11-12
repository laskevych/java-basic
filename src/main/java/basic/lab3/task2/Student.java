package basic.lab3.task2;

public class Student extends Citizen {
    private final String university;

    public Student(
            String firstName,
            String lastName,
            int age,
            Gender gender,
            Nationality nationality,
            String university
    ) throws Exception {
        super(firstName, lastName, age, gender, nationality);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", university='" + this.getUniversity() + '\'';
    }
}
