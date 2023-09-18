package basic.lab1.task2;

import java.util.Scanner;

public class PowerOfEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int base = 8;
        System.out.print("Enter the value of variable `n`: ");
        int n = scanner.nextInt();
        scanner.close();

        if (n < 0 || n > 10) {
            System.err.println("The value does not belong in the allowed range of 0 to 10 including.");
            System.exit(1);
        }

        System.out.printf("Powers of %d to %d including (using arithmetic operations):\n", base, n );
        for (int i = 0; i <= n; i++) {
            int result = (int) Math.pow(base, i);
            System.out.println(base + "^" + i + " = " + result);
        }

        System.out.printf("Powers of %d to %d including (using bitwise operations):\n", base, n );
        for (int i = 0; i <= n; i++) {
            int result = 1 << 3 * i;
            System.out.println(base + "^" + i + " = " + result);
        }
    }
}
