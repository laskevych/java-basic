package basic.lab3.task3;

abstract class FindValueAbstractClass {
    abstract double function(double x);

    public double findMinValue(double start, double end, double step) {
        double minValue = this.function(start);

        for (double x = start + step;  x <= end; x += step) {
            double value = this.function(x);

            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }
}
