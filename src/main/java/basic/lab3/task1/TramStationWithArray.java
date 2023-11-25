package basic.lab3.task1;

/**
 * Represents tram station data with an array of operating hours.
 * This class is inherited from the abstract {@link AbstractTramStation} class.
 */
public class TramStationWithArray extends AbstractTramStation {
    private final Hour[] hours;

    /**
     * The constructor initialises the tram station object with the specified values with {@code name},
     * {@code routeNumbers} list of route numbers.
     *
     * @param title        the title of tram station;
     * @param routeNumbers the list of route numbers;
     * @param hours        the array of operating hours of tram station.
     */
    public TramStationWithArray(String title, int[] routeNumbers, Hour[] hours) {
        super(title, routeNumbers);
        this.hours = hours;
    }

    /**
     * Gets the array of operating hours for the tram station.
     * @return the array of hours.
     */
    @Override
    public Hour[] getHours() {
        return this.hours;
    }
}
