package basic.lab3.task6;

import java.util.Comparator;

public class Triangle {
    private final double edgeA;
    private final double edgeB;
    private final double edgeC;

    public Triangle(double edgeA, double edgeB, double edgeC) throws Exception {
        if (edgeA <= 0
                || edgeB <= 0
                || edgeC <= 0) {
            throw new Exception("The edge must be greater than 0");
        }

        if (edgeB + edgeC <= edgeA
                || edgeA + edgeC <= edgeB
                || edgeA + edgeB <= edgeC) {
            throw new Exception("The sum of lengths of 2 edges must be greater than length of the 3 edge.");
        }

        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }

    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }

    public double calculateArea() {
        return Math.sqrt(
                    (getEdgeA() + getEdgeB() + getEdgeC())
                    * (getEdgeB() + getEdgeC() - getEdgeA())
                    * (getEdgeA() + getEdgeB() - getEdgeC())
        ) * 0.25;
    }
}
