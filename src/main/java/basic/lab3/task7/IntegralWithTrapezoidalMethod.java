package basic.lab3.task7;

public class IntegralWithTrapezoidalMethod implements Integrable {
    @Override
    public double someFunction(double x) {
        return Math.pow(x, 2);
    }

    @Override
    public double integral(
            double start,
            double end,
            double accuracy
    ) throws Exception {
        if (start >= end) {
            throw new Exception("The start must be less than the end.");
        }

        double step = (end - start) * accuracy;
        double area = 0;

        for (double x = start; x < end; x += step) {
            area += 0.5 * step * (someFunction(x) + someFunction(x + step));
        }

        return area;
    }
}
