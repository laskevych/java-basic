package basic.lab3.task6;

import java.util.Comparator;

public class TriangleComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return Double.compare(o2.calculateArea(), o1.calculateArea());
    }
}
