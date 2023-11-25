package basic.lab3.task1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Abstract class representing tram station with {@code name}, {@code opened} year and operating hour data.
 * Access to the sequence of hours, {@code name} and {@code opened} year is represented by abstract methods.
 */
public abstract class AbstractTramStation {

    private final String title;

    private final int[] routeNumbers;

    /**
     * The constructor initialises the tram station object with the specified values with {@code title},
     * {@code routeNumbers} list of route numbers.
     * @param title  the title of tram station;
     * @param routeNumbers the list of route numbers;
     */
    public AbstractTramStation(String title, int[] routeNumbers) {
        this.title = title;
        this.routeNumbers = routeNumbers;
    }

    public String getTitle() {
        return this.title;
    }

    public int[] getRouteNumbers() {
        return this.routeNumbers;
    }

    public abstract Hour[] getHours();

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Station: `").append(getTitle()).append("`.\n")
                .append("Route numbers: ").append(Arrays.toString(getRouteNumbers())).append(".\n")
                .append("Hours:\n");

        if (this.getHours().length == 0) {
            string.append("Empty.\n");
        } else {
            for (Hour h : getHours()) {
                string.append("\t").append(h).append("\n");
            }
        }

        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AbstractTramStation ms)) {
            return false;
        }

        return ms.getTitle().equals(getTitle())
                && Arrays.equals(ms.getRouteNumbers(), getRouteNumbers())
                && Arrays.equals(ms.getHours(), getHours());
    }

    @Override
    public int hashCode() {
        return getTitle().hashCode() * Arrays.hashCode(getRouteNumbers()) * Arrays.hashCode(getHours());
    }

    public Integer calculateTotalRidership() {
        if (this.getHours().length == 0) {
            return null;
        }

        int totalRidership = 0;

        for (Hour hour : getHours()) {
            totalRidership += hour.getRidership();
        }

        return totalRidership;
    }

    /**
     * Finds the hours with the minimal ridership in the array of tram station operating hours.
     * @return null, if there is no pointer to the hour, or it is empty,
     * hour with minimal ridership otherwise.
     */
    public Hour getHourWithMinRidership() {
        if (this.getHours().length == 0) {
            return null;
        }

        Hour minHour = this.getHours()[0];

        for (Hour hour : this.getHours()) {
            if (hour.getRidership() < minHour.getRidership()) {
                minHour = hour;
            }
        }

        return minHour;
    }

    /**
     * Finds the longest comment in an array of hours.
     * @return longest comment or null, if there is no pointer to the hours array, or it is empty.
     */
    public String getLongestCommentInHours() {
        if (this.getHours().length == 0) {
            return null;
        }

        Hour hourWithLongestComment = this.getHours()[0];

        for (Hour hour : this.getHours()) {
            if (hour.getCommentLength() < hourWithLongestComment.getCommentLength()) {
                hourWithLongestComment = hour;
            }
        }

        return hourWithLongestComment.getComment();
    }

    /**
     * Finds the total ridership for an array of tram station operating hours and prints the result to the console.
     */
    private void printTotalRidership() {
        Integer totalRidership = calculateTotalRidership();
        System.out.print("Total ridership for station:\t");

        if (totalRidership == null) {
            System.out.println("There is no ridership hours.");
        } else {
            System.out.println(totalRidership);
        }
    }

    /**
     * Prints the array of hours.
     * @param hours the array of hours to be printed.
     */
    private void printHours(Hour[] hours) {
        for (Hour hour : hours) {
            System.out.println(hour);
        }
    }

    private void printHoursWithMinRidership() {
        Hour hour = getHourWithMinRidership();

        System.out.printf(
                "Hours with minimal ridership: %s",
                Objects.requireNonNullElse(hour, "There are not ridership hours.")
        );
    }

    private void printLongestCommentInHours() {
        String comment = getLongestCommentInHours();

        System.out.printf(
                "The longest comment in hours list: %s",
                Objects.requireNonNullElse(comment, "There are not ridership hours.")
        );
    }

    /**
     * Sorts a sequence of hours by decreasing ridership using bubble sorting.
     * @return a reference to this object.
     */
    public AbstractTramStation sortByAscendingRidership() {
        boolean unsorted = true;

        while (unsorted) {
            unsorted = false;

            for (int i = 0; i < this.getHours().length - 1; i++) {
                if (this.getHours()[i].getRidership() > this.getHours()[1 + i].getRidership()) {
                    Hour temp = this.getHours()[i];
                    this.getHours()[i] = this.getHours()[i + 1];
                    this.getHours()[i + 1] = temp;
                    unsorted = true;
                }
            }
        }

        return this;
    }

    /**
     * Sorts a sequence of hours by comment in alphabetic order using insertion sorting.
     * @return a reference to this object.
     */
    public AbstractTramStation sortByCommentsAlphabetically() {
        Hour[] hours = this.getHours();

        for (int i = 1; i < hours.length; i++) {
            for (int j = i; j > 0 && hours[j].compareTo(hours[j - 1]) < 0; j--) {
                Hour temp = hours[j];
                hours[j] = hours[j - 1];
                hours[j - 1] = temp;
            }
        }

        return this;
    }
}
