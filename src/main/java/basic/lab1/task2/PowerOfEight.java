package basic.lab1.task2;

import java.util.Scanner;

public class PowerOfEight {
    public static final int MIN_EXPONENT = 0;
    public static final int MAX_EXPONENT = 10;
    public static final int BASE = 8;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the value of variable `n`: ");
            int n = scanner.nextInt();
            scanner.close();

            validateExponent(n);

            System.out.printf("Powers of %d to %d including (using arithmetic operations):%n", BASE, n);
            for (int i = 0; i <= n; i++) {
                System.out.printf("%d^%d = %d%n", BASE, i, pow(i));
            }

            System.out.printf("Powers of %d to %d including (using bitwise operations):%n", BASE, n);
            for (int i = 0; i <= n; i++) {
                System.out.printf("%d^%d = %d%n", BASE, i, powBitwise(i));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    protected static void validateExponent(int exponent) throws Exception {
        if (exponent < MIN_EXPONENT || exponent > MAX_EXPONENT) {
            throw new Exception("The `exponent` value must be between " + MIN_EXPONENT + " and " + MAX_EXPONENT + ".");
        }
    }

    public static int pow(int exponent) throws Exception {
        validateExponent(exponent);

        if (exponent == 0) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= BASE;
        }

        return result;
    }

    public static int powBitwise(int exponent) throws Exception {
        validateExponent(exponent);

        if (exponent == 0) {
            return 1;
        }

        return 1 << 3 * exponent;
    }
}
