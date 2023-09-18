package basic.lab1.task3;

import java.util.Scanner;

public class ContinueAndBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter double value of variable `x`: ");
        double x = scanner.nextDouble();

        System.out.print("Enter number of iterations: ");
        int numberOfIterations = scanner.nextInt();

        scanner.close();

        if (numberOfIterations < 1) {
            System.err.print("Number of iterations must be >= 1");
            System.exit(1);
        }

        double y = 1.0;

        outerLoopLabel:
        for (int i = 1; i <= numberOfIterations - 1; i++) {
            double s = 0;
            int j;

            for (j = 0; j <= numberOfIterations; j++) {
                if (j + x == 0) {
                    System.err.println("Division by zero.");
                    break outerLoopLabel;
                }

                if (i == j + x) {
                    continue outerLoopLabel;
                }

                s += i / (j + x);
            }

            y *= s;
        }

        System.out.printf("Result: y = %.2f\n", y);
    }
}