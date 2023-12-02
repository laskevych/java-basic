package basic.lab4.task1;;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.LinkedHashSet;

/**
 * Represents tram station data with an ArrayList of operating hours.
 * This class is inherited from the abstract {@link AbstractTramStationWithCollection}.
 */
public class TramStationWithList extends AbstractTramStationWithCollection {
    /** List of operating hours of the tram station. */
    private final List<Hour> hours;

    /**
     * The constructor initialises the tram station object with the specified values with {@code name},
     * {@code routeNumbers} list of route numbers.
     *
     * @param title        the title of tram station;
     * @param routeNumbers the list of route numbers;
     * @param hours        the list of operating hours of tram station.
     */
    public TramStationWithList(String title,
                               ArrayList<Integer> routeNumbers,
                               List<Hour> hours) throws IllegalArgumentException {
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

        Set<Hour> uniqeSet = new LinkedHashSet<>(hours);
        this.hours = new ArrayList<>(uniqeSet);
    }

    @Override
    public Hour[] getHours() {
        return this.hours.toArray(new Hour[0]);
    }

    public List<Hour> getHourList() {
        return this.hours;
    }

    /**
     * Sorts the sequence of operating hours of tram station by ascending ridership.
     *
     * @return the {@code TramStationWithList} object with sorted operating hours.
     */
    @Override
    public TramStationWithList sortByAscendingRidership() {
        Collections.sort(this.getHourList());

        return this;
    }

    /**
     * Sorts the sequence of operating hours of tram station by comment in alphabetic order.
     *
     * @return the {@code TramStationWithList} object with sorted operating hours.
     */
    @Override
    public TramStationWithList sortByCommentsAlphabetically() {
        this.getHourList().sort(Comparator.comparing(Hour::getComment));

        return this;
    }
}
