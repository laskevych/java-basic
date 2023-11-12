package basic.lab3.task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TriangleTest {
    @Test()
    @DisplayName("Logic of class `Triangle` and sorting by `TriangleComparator` should work correctly.")
    void testTriangle() throws Exception {
        double [][] testTriangles = {
                {9.5, 9.5, 9.5},
                {10.1, 11.2, 12.3},
                {4, 3, 5}
        };

        Triangle[] triangles = new Triangle[testTriangles.length];

        for (int i = 0; i < testTriangles.length; i++) {
            triangles[i] = new Triangle(testTriangles[i][0], testTriangles[i][1], testTriangles[i][2]);
        }

        for (int i = 0; i < testTriangles.length; i++) {
            Assertions.assertEquals(testTriangles[i][0], triangles[i].getEdgeA());
            Assertions.assertEquals(testTriangles[i][1], triangles[i].getEdgeB());
            Assertions.assertEquals(testTriangles[i][2], triangles[i].getEdgeC());
        }

        // Sort
        Arrays.sort(triangles, new TriangleComparator());

        Assertions.assertEquals(10.1, triangles[0].getEdgeA());
        Assertions.assertEquals(11.2, triangles[0].getEdgeB());
        Assertions.assertEquals(12.3, triangles[0].getEdgeC());
    }
}
