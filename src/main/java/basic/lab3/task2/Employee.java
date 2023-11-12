package basic.lab3.task2;

public class Employee extends Citizen {

    private final String company;
    private final String position;

    public Employee(String firstName,
                    String lastName,
                    int age,
                    Gender gender,
                    Nationality nationality,
                    String company,
                    String position
    ) throws Exception {
        super(firstName, lastName, age, gender, nationality);
        this.company = company;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", company='" + this.getCompany() + '\'' +
                ", position='" + this.getPosition() + '\'';
    }
}
