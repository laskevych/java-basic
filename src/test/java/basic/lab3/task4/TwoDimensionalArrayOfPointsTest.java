package basic.lab3.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwoDimensionalArrayOfPointsTest {
    @Test()
    @DisplayName("Logic of class `TwoDimensionalArrayOfPoints` should work correctly.")
    void testTwoDimensionalArrayOfPoints() throws Exception {
        double[][] testPoints = {{15, 12}, {31, 6.5}, {-3, 59}, {-14, 7}};

        TwoDimensionalArrayOfPoints arrayOfPoints = new TwoDimensionalArrayOfPoints();

        for (double[] testPoint: testPoints) {
            arrayOfPoints.addPoint(testPoint[0], testPoint[1]);
        }

        for (int i = 0; i < testPoints.length; i++) {
            Assertions.assertEquals(testPoints[i][0], arrayOfPoints.getX(i));
            Assertions.assertEquals(testPoints[i][1], arrayOfPoints.getY(i));
        }

        // Sort by X
        arrayOfPoints.sortBy(AbstractArrayOfPoints.SortBy.X);

        Assertions.assertEquals(-14, arrayOfPoints.getX(0));
        Assertions.assertEquals(7, arrayOfPoints.getY(0));

        // Sort by Y
        arrayOfPoints.sortBy(AbstractArrayOfPoints.SortBy.Y);

        Assertions.assertEquals(31, arrayOfPoints.getX(0));
        Assertions.assertEquals(6.5, arrayOfPoints.getY(0));

        // Remove last
        arrayOfPoints.removeLast();

        Assertions.assertEquals(testPoints.length - 1, arrayOfPoints.count());

        // Set point
        arrayOfPoints.setPoint(0, 35, 7.5);

        Assertions.assertEquals(35, arrayOfPoints.getX(0));
        Assertions.assertEquals(7.5, arrayOfPoints.getY(0));
    }
}
