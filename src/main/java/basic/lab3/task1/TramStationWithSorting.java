package basic.lab3.task1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Represents tram station data with an array of operating hours and overridden sorting methods.
 * This class extends (inherits from) the {@link TramStationWithArray} class.
 * Also, this class is inherited from the abstract {@link AbstractTramStation} class.
 */
public class TramStationWithSorting extends TramStationWithArray {

    private final Comparator<Hour> hourComparator;

    /**
     * The constructor initialises the tram station object with the specified values with {@code name},
     * {@code routeNumbers} list of route numbers.
     *
     * @param title          the title of tram station;
     * @param routeNumbers   the list of route numbers;
     * @param hours          the array of operating hours of tram station.
     * @param hourComparator the comparator for object Hour.
     */
    public TramStationWithSorting(String title, int[] routeNumbers, Hour[] hours, Comparator<Hour> hourComparator) {
        super(title, routeNumbers, hours);
        this.hourComparator = hourComparator;
    }

    /**
     * Overridden decreasing ridership sorting method using the standard sort function of class {@code Arrays}.
     * This method is provided by the implementation of the Comparable interface for objects of type {@code Hour}.
     * @return a reference to this object.
     */
    @Override
    public AbstractTramStation sortByAscendingRidership() {
        Arrays.sort(this.getHours());
        return this;
    }

    /**
     * Overridden descending comment length sorting method using the standard sort function of class {@code Arrays}
     * and {@code Comparator}. This method is provided by creating a separate class {@code CommentComparator}
     * that implements the {@code Comparator} interface for objects of type {@code Hour}.
     * @return a reference to this object.
     */
    @Override
    public AbstractTramStation sortByCommentsAlphabetically() {
        Arrays.sort(getHours(), this.hourComparator);
        return this;
    }
}
