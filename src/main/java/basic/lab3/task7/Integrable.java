package basic.lab3.task7;

@FunctionalInterface
public interface Integrable {
    double someFunction(double x);

    default double integral(
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
            area += someFunction(x) * step;
        }

        return area;
    }
}
