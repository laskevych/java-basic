package basic.lab3.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HourTest {
    @Test()
    @DisplayName("Constructor of class `Hour` should correctly works.")
    void testHour() {
        int ridership = 50;
        String comment = "Test comment";

        Hour hour = new Hour(ridership, comment);

        Assertions.assertEquals(ridership, hour.getRidership());
        Assertions.assertEquals(comment, hour.getComment());
        Assertions.assertEquals(comment.length(), hour.getCommentLength());
    }

    @Test()
    @DisplayName("Constructor of class `Hour` should throws exception.")
    void testHourThrowException() {
        Assertions.assertThrows(
                Exception.class, () -> new Hour(-1, "Test")
        );

        Assertions.assertThrows(
                Exception.class, () -> new Hour(1, null)
        );
    }
}
