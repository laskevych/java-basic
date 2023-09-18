package basic.lab1.task1;

import java.util.Scanner;

public class CalculationFunction {

    final static int CALCULATION_ITERATIONS_COUNT = 17;

    public static double calculate(double x) {
        double y;

        if (x < 6) {
            y = 0.5 * x + 9;
            for (int k = 1; k < CALCULATION_ITERATIONS_COUNT; k++) {
                y += Math.pow(Math.sin(x - 6), k);
            }
        } else {
            y = 0.5 * Math.abs(x - 10) + 10;
        }

        return y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = "Enter double value of variable `%s`: ";

        System.out.printf(message, "startInterval");
        double startInterval = scanner.nextDouble();

        System.out.printf(message, "endInterval");
        double endInterval = scanner.nextDouble();

        System.out.printf(message, "step");
        double step = scanner.nextDouble();

        scanner.close();

        if (startInterval > endInterval) {
            System.err.println("Value of `endInterval` must be greater than `startInterval`.");
            System.exit(1);
        } else if (step <= 0) {
            System.err.println("Value of `step` must be greater than 0.");
            System.exit(1);
        }

        for (double x = startInterval; x <= endInterval ; x += step) {
            double y = calculate(x);
            System.out.printf("x = %.3f, y = %.3f%n", x, y);
        }
    }
}
