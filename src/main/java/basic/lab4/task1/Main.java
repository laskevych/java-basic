package basic.lab4.task1;;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 * The {@code Main} class performs testing of the {@link TramStationWithList}
 * and {@link TramStationWithSortedSet} classes functionality.
 */
public class Main {
    /**
     * Creates the {@code ArrayList<Integer>} representing the route list of tram station.
     *
     * @return the route list.
     */
    public static ArrayList<Integer> createRouteList() {
        ArrayList<Integer> routList = new ArrayList<>(5);
        routList.add(5);
        routList.add(10);
        routList.add(9);
        routList.add(25);
        routList.add(3);

        return routList;
    }

    /**
     * Creates the operating hours of tram station for collection that extends the {@link Collection} interface.
     *
     * @param <T>             the type parameter representing a collection that extends {@link Collection<Hour>};
     * @param hourCollection the collection to which the operating hours will be added;
     * @return the collection with added operating hours.
     */
    public static <T extends Collection<Hour>> T createHourCollection(T hourCollection) {
        /* //todo for testing exceptions in classes constructors
        hourCollection.add(null);
        hourCollection.add(new Hour(-1, "Medium ridership"));
        hourCollection.add(new Hour(1, null));
         */
        hourCollection.add(new Hour(433, "Medium ridership"));
        hourCollection.add(new Hour(75, "Very low ridership"));
        hourCollection.add(new Hour(148, "Low ridership"));
        hourCollection.add(new Hour(433, "Medium ridership"));
        hourCollection.add(new Hour(790, "High ridership"));
        hourCollection.add(new Hour(245, "Low ridership"));
        hourCollection.add(new Hour(1109, "Very high ridership"));

        return hourCollection;
    }

    /**
     * Prints search and sorting results for objects of classes
     * that extends the {@link AbstractTramStationWithCollection} class.
     *
     * @param <T>         the type parameter representing objects that extend {@link AbstractTramStationWithCollection};
     * @param tramStation an object of a class that extends {@link AbstractTramStationWithCollection}.
     */
    public static <T extends AbstractTramStationWithCollection> void printTramStationWithSortedHours(T tramStation) {
        System.out.println("Get total ridership for all Operating Hours:\t" +
                tramStation.getTotalRidership() + "\n");

        System.out.println("Get Operating Hour with lowest ridership:");
        System.out.println(tramStation.getHourWithLowestRidership() + "\n");

        System.out.println("Get longest comment of Operating Hour: \t\'" +
                tramStation.getLongestCommentInHours() + "\'\n");

        System.out.println("Sort Operating Hours by increasing ridership:");
        System.out.println(tramStation.sortByAscendingRidership());

        System.out.println("Sort Operating Hours by comment alphabetically:");
        System.out.println(tramStation.sortByCommentsAlphabetically());
    }


    /**
     * Performs testing of the {@link TramStationWithList} class functionality.
     */
    public static void testTramStationWithList() {
        System.out.println("""
                _______________________________________________________
                SORTING AND SEARCH RESULTS FOR TRAM STATION WITH LIST:
                _______________________________________________________""");

        System.out.println("Create the Tram Station:");
        TramStationWithList tramStationWithList = new TramStationWithList(
                "University",
                createRouteList(),
                createHourCollection(new ArrayList<>())
        );
        System.out.println(tramStationWithList);

        printTramStationWithSortedHours(tramStationWithList);
    }

    /**
     * Performs testing of the {@link TramStationWithSortedSet} class functionality.
     */
    public static void testTramStationWithSortedSet() {
        System.out.println("""
                _____________________________________________________________
                SORTING AND SEARCH RESULTS FOR TRAM STATION WITH SORTED SET:
                _____________________________________________________________""");

        System.out.println("Create the Tram Station:");
        TramStationWithSortedSet tramStationWithSortedSet = new TramStationWithSortedSet(
                "University",
                createRouteList(),
                createHourCollection(new TreeSet<>())
        );
        System.out.println(tramStationWithSortedSet);

        printTramStationWithSortedHours(tramStationWithSortedSet);
    }

    /**
     * Carries out testing of the {@link TramStationWithList} and {@link TramStationWithSortedSet} classes
     * functionality. The {@code args} are not used.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        testTramStationWithList();
        System.out.println("\n");
        testTramStationWithSortedSet();
    }
}
