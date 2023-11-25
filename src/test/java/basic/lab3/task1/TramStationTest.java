package basic.lab3.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TramStationTest {
    @Test()
    @DisplayName("Construct of `TramStationWithArray` should work and sorting method must work correctly.")
    void testObjectOfTramStationWithArray() {

        String title = "Central";
        int[] routeNumbers = {1, 5};

        Hour[] hours = {
            new Hour(345, "Medium ridership"),
            new Hour(23, "Very low ridership"),
            new Hour(87, "Low ridership"),
        };



        TramStationWithArray tramStation = new TramStationWithArray(title, routeNumbers, hours);

        Assertions.assertEquals(title, tramStation.getTitle());
        Assertions.assertEquals(routeNumbers, tramStation.getRouteNumbers());
        Assertions.assertEquals(hours, tramStation.getHours());

        Assertions.assertEquals(
                23,
                tramStation.sortByAscendingRidership().getHours()[0].getRidership()
        );

        Assertions.assertEquals(
                "Low ridership",
                tramStation.sortByCommentsAlphabetically().getHours()[0].getComment()
        );

        Assertions.assertEquals(23, tramStation.getHourWithMinRidership().getRidership());

        Assertions.assertEquals("Very low ridership", tramStation.getLongestCommentInHours());
    }

    @Test()
    @DisplayName("Construct of `TramStationWithSorting` should work and sorting method must work correctly.")
    void testObjectOfTramStationWithSorting() {
        String title = "Central";
        int[] routeNumbers = {1, 5};

        Hour[] hours = {
                new Hour(345, "Medium ridership"),
                new Hour(23, "Very low ridership"),
                new Hour(87, "Low ridership"),
        };

        TramStationWithSorting tramStation = new TramStationWithSorting(title, routeNumbers, hours, new CommentComparator());

        Assertions.assertEquals(title, tramStation.getTitle());
        Assertions.assertEquals(routeNumbers, tramStation.getRouteNumbers());
        Assertions.assertEquals(hours, tramStation.getHours());

        Assertions.assertEquals(
                23,
                tramStation.sortByAscendingRidership().getHours()[0].getRidership()
        );

        Assertions.assertEquals(
                "Low ridership",
                tramStation.sortByCommentsAlphabetically().getHours()[0].getComment()
        );

        Assertions.assertEquals(23, tramStation.getHourWithMinRidership().getRidership());

        Assertions.assertEquals("Very low ridership", tramStation.getLongestCommentInHours());
    }
}
