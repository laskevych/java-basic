package basic.lab3.task2;

public class Citizen extends Human {

    private final Nationality nationality;

    public Citizen(
            String firstName,
            String lastName,
            int age,
            Gender gender,
            Nationality nationality) throws Exception {
        super(firstName, lastName, age, gender);
        this.nationality = nationality;
    }

    public Nationality getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", nationality=" + this.getNationality();
    }

    public enum Nationality {
        AMERICAN ("American"),
        BRITISH ("British"),
        POLISH ("Polish"),
        UKRAINIAN ("Ukrainian");

        private final String title;

        Nationality(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }

        @Override
        public String toString() {
            return this.getTitle();
        }
    }
}
