package basic.lab3.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CircleTest {
    @Test()
    @DisplayName("Method `compareTo` should return value of [-1, 0, 1].")
    void testCompareTo() throws Exception {
        Circle[] circles = {
                new Circle(2),
                new Circle(4),
                new Circle(2)
        };

        Assertions.assertEquals(-1, circles[0].compareTo(circles[1]));
        Assertions.assertEquals(0, circles[0].compareTo(circles[2]));
        Assertions.assertEquals(1, circles[1].compareTo(circles[0]));
    }

    @Test()
    @DisplayName("Constructor of `Circle` should throw exception while " +
            "radios is less 0.")
    void testConstructorCircle() {
        Assertions.assertThrows(
                Exception.class, () -> new Circle(-1)
        );
    }
}
