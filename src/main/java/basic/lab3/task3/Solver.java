package basic.lab3.task3;

public class Solver {
    public static double findMinValue(double start, double end, double step, FindValueInterface findValue) {
        double minValue = findValue.function(start);

        for (double x = start + step;  x <= end; x += step) {
            double value = findValue.function(x);

            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }
}
