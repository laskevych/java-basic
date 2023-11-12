package basic.lab3.task4;

public abstract class AbstractArrayOfPoints {
    public abstract void setPoint(int i, double x, double y);

    public abstract double getX(int i);

    public abstract double getY(int i);

    public abstract int count();

    public abstract void addPoint(double x, double y);

    public abstract void removeLast();

    public void sortBy(SortBy sortBy) throws Exception {
        boolean unsorted = true;

        while (unsorted) {
            unsorted = false;

            for (int i = 0; i < count() - 1; i++) {
                boolean compare;
                switch (sortBy) {
                    case X:
                        compare = getX(i) > getX(i + 1);
                        break;
                    case Y:
                        compare = getY(i) > getY(i + 1);
                        break;
                    default:
                        throw new Exception("The unknown value of comparison.");
                }

                if (compare) {
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    unsorted = true;
                }
            }
        }

    }

    public enum SortBy {
        X,
        Y
    }
}
