package basic.lab4.task1;;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.LinkedHashSet;

/**
 * Abstract class representing tram station with {@code name}, {@code opened} year and operating hour data.
 * Access to the sequence of hours, {@code name} and {@code opened} year is represented by abstract methods.
 */
public abstract class AbstractTramStationWithCollection {
    /** The title of the tram station. */
    private final String title;

    /** The list of tram station route numbers. */
    private final List<Integer> routeNumbers;

    /**
     * The constructor initialises the tram station object with the specified values with {@code title},
     * {@code routeNumbers} list of route numbers.
     *
     * @param title  the title of tram station;
     * @param routeNumbers the list of route numbers;
     * @throws IllegalArgumentException if invalid parameter value passed.
     */
    public AbstractTramStationWithCollection(
            String title,
            List<Integer> routeNumbers) throws IllegalArgumentException {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null.");
        }

        if (routeNumbers.isEmpty()) {
            throw new IllegalArgumentException("List of route numbers cannot be empty.");
        }

        for (Integer routeNumber : routeNumbers.toArray(new Integer[0])) {
            if (routeNumber == null || routeNumber < 1) {
                throw new IllegalArgumentException("Route numbers must be greater than 0.");
            }
        }

        this.title = title;
        Set<Integer> uniqueSet = new LinkedHashSet<>(routeNumbers);
        this.routeNumbers = new ArrayList<>(uniqueSet);
    }

    public String getTitle() {
        return this.title;
    }

    public Integer[] getRouteNumbers() {
        return this.routeNumbers.toArray(new Integer[0]);
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

        if (!(obj instanceof AbstractTramStationWithCollection ts)) {
            return false;
        }

        return ts.getTitle().equals(getTitle())
                && Arrays.equals(ts.getRouteNumbers(), getRouteNumbers())
                && Arrays.equals(ts.getHours(), getHours());
    }

    @Override
    public int hashCode() {
        return getTitle().hashCode()
                * Arrays.hashCode(getRouteNumbers())
                * Arrays.hashCode(getHours());
    }

    /**
     * Finds total ridership for all operating hours in the array of operating hours of tram station.
     *
     * @return null, if there is no pointer to the hour, or it is empty,
     * total ridership otherwise.
     */

    public int getTotalRidership() {
        return Arrays.stream(this.getHours()).mapToInt(Hour::getRidership).sum();
    }

    /**
     * Gets the hours with the minimal ridership in the array of tram station operating hours.
     *
     * @return null, if there is no pointer to the hour, or it is empty,
     * hour with minimal ridership otherwise.
     */
    public Hour getHourWithLowestRidership() {
        return Collections.min(
                Arrays.asList(this.getHours()),
                Comparator.comparing(Hour::getRidership));
    }

    /**
     * Gets the longest comment of hour in the array of tram station operating hours.
     *
     * @return longest comment or null, if there is no pointer to the hours array, or it is empty.
     */
    public String getLongestCommentInHours() {
        return Collections.max(
                Arrays.asList(this.getHours()),
                Comparator.comparing(Hour::getCommentLength)).getComment();
    }

    /**
     * Sorts the sequence of operating hours of tram station by ascending ridership.
     *
     * @return the {@code AbstractTramStationWithCollection} object with sorted operating hours.
     */
    public AbstractTramStationWithCollection sortByAscendingRidership() {
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
     * Sorts the sequence of operating hours of tram station by comment in alphabetic order.
     *
     * @return the {@code AbstractTramStationWithCollection} object with sorted operating hours.
     */
    public AbstractTramStationWithCollection sortByCommentsAlphabetically() {
        Hour[] hours = this.getHours();

        for (int i = 1; i < hours.length; i++) {
            for (int j = i; j > 0 && hours[j].getComment().compareTo(hours[j - 1].getComment()) < 0; j--) {
                Hour temp = hours[j];
                hours[j] = hours[j - 1];
                hours[j - 1] = temp;
            }
        }

        return this;
    }
}
