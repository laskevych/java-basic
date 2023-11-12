package basic.lab3.task4;

public class OneDimensionalArrayOfPoints extends AbstractArrayOfPoints {
    private double[] points = new double[0];

    @Override
    public void setPoint(int i, double x, double y) {
        if (i >= 0 && i * 2 + 1 < points.length) {
            points[i * 2] = x;
            points[i * 2 + 1] = y;
        }
    }

    @Override
    public double getX(int i) {
        if (i >= 0 && i * 2 + 1 < points.length) {
            return points[i * 2];
        }

        return 0;
    }

    @Override
    public double getY(int i) {
        if (i >= 0 && i * 2 + 1 < points.length) {
            return points[i * 2 + 1];
        }

        return 0;
    }

    @Override
    public int count() {
        return points.length / 2;
    }

    @Override
    public void addPoint(double x, double y) {
        double[] newArray = new double[points.length + 2];
        System.arraycopy(points, 0, newArray, 0, points.length);
        newArray[points.length] = x;
        newArray[points.length + 1] = y;
        points = newArray;
    }

    @Override
    public void removeLast() {
        if (count() > 0) {
            double[] newArray = new double[points.length - 2];
            System.arraycopy(points, 0, newArray, 0, points.length - 2);
            points = newArray;
        }
    }
}
