package basic.lab1.task3;

import java.util.Scanner;

public class ContinueAndBreak {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter double value of variable `x`: ");
            double x = scanner.nextDouble();

            System.out.print("Enter number of iterations: ");
            int n = scanner.nextInt();

            scanner.close();

            System.out.printf("Result: y = %.4f\n", calculate(x, n));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static double calculate(double x, int numberOfIterations) throws Exception {
        if (numberOfIterations < 1) {
            throw new Exception("Number of iterations must be greater or equal `1`");
        }

        double y = 1.0;
        boolean divideByZero = false;

        outerLoopLabel:
        for (int i = 1; i <= numberOfIterations - 1; i++) {

            double subResult = 0;
            for (int j = 0; j <= numberOfIterations; j++) {
                if (j + x == 0) {
                    divideByZero = true;
                    break outerLoopLabel;
                }

                if (i == j + x) {
                    continue outerLoopLabel;
                }

                subResult += i / (j + x);
            }

            y *= subResult;
        }

        if (divideByZero) {
            throw new Exception("Divide by zero.");
        }

        return y;
    }
}