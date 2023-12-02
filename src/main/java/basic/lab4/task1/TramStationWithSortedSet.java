package basic.lab4.task1;;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Represents tram station data with an SortedSet of operating hours.
 * This class is inherited from the abstract {@link AbstractTramStationWithCollection}.
 */
public class TramStationWithSortedSet extends AbstractTramStationWithCollection {
    /**
     * SortedSet of operating hours of the tram station.
     * The set is initialized with a TreeSet using a custom comparator based on the hashCode of the Hour objects.
     */
    private SortedSet<Hour> hours;

    /**
     * The constructor initialises the tram station object with the specified values with {@code name},
     * {@code routeNumbers} sortedset of route numbers.
     *
     * @param title        the title of tram station;
     * @param routeNumbers the list of route numbers;
     * @param hours        the list of operating hours of tram station.
     */
    public TramStationWithSortedSet(String title,
                               ArrayList<Integer> routeNumbers,
                               SortedSet<Hour> hours) throws IllegalArgumentException {
        super(title, routeNumbers);

        if (hours.isEmpty()) {
            throw new IllegalArgumentException("List of operating hours cannot be empty.");
        }

        for (Hour hour : hours.toArray(new Hour[0])) {
            if (hour == null) {
                throw new IllegalArgumentException("Operating hour cannot be empty.");
            }

            if (hour.getRidership() < 0) {
                throw new IllegalArgumentException("Count of ridership must be equal or greater than 0.");
            }

            if (hour.getComment() == null) {
                throw new IllegalArgumentException("Comment cannot be null.");
            }
        }

        this.hours = hours;
    }


    @Override
    public Hour[] getHours() {
        return this.hours.toArray(new Hour[0]);
    }

    /**
     * Sorts the sequence of operating hours of tram station by ascending ridership.
     *
     * @return the {@code TramStationWithSortedSet} object with sorted operating hours.
     */
    @Override
    public TramStationWithSortedSet sortByAscendingRidership() {
        SortedSet<Hour> sortedSet = new TreeSet<>(Comparator.comparing(Hour::getRidership));
        sortedSet.addAll(this.hours);
        this.hours = sortedSet;

        return this;
    }

    /**
     * Sorts the sequence of operating hours of tram station by comment in alphabetic order.
     *
     * @return the {@code TramStationWithSortedSet} object with sorted operating hours.
     */
    @Override
    public TramStationWithSortedSet sortByCommentsAlphabetically() {
        SortedSet<Hour> sortedSet = new TreeSet<>(Comparator.comparing(Hour::getComment));
        sortedSet.addAll(this.hours);
        this.hours = sortedSet;

        return this;
    }
}
