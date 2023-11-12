package basic.lab3.task4;

public class TwoDimensionalArrayOfPoints extends AbstractArrayOfPoints {
    private double[][] points = new double[0][2];

    @Override
    public int count() {
        return points.length;
    }

    @Override
    public void setPoint(int i, double x, double y) {
        if (i >= 0 && i < count()) {
            points[i][0] = x;
            points[i][1] = y;
        }
    }

    @Override
    public double getX(int i) {
        if (i >= 0 && i < count()) {
            return points[i][0];
        }

        return 0;
    }

    @Override
    public double getY(int i) {
        if (i >= 0 && i < count()) {
            return points[i][1];
        }

        return 0;
    }

    @Override
    public void addPoint(double x, double y) {
        double[][] newArray = new double[count() + 1][2];
        System.arraycopy(points, 0, newArray, 0, count());
        newArray[count()][0] = x;
        newArray[count()][1] = y;
        points = newArray;
    }

    @Override
    public void removeLast() {
        if (count() > 0) {
            double[][] newArray = new double[count() - 1][2];
            System.arraycopy(points, 0, newArray, 0, count() - 1);
            points = newArray;
        }
    }
}
