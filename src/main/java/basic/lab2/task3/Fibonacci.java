package basic.lab2.task3;

public class Fibonacci {

    private static final int ARRAY_LENGTH = 92;

    private static int lastComputedFibonacciNumberIndex = 2;

    private static final long[] fibonacciNumbersStorage = new long[ARRAY_LENGTH];
    static {
        fibonacciNumbersStorage[0] = 1;
        fibonacciNumbersStorage[1] = 1;
    }

    static long getFibonacciNumberByIndex(int index) throws Exception {
        if (index < 1 || index > ARRAY_LENGTH) {
            throw new Exception("Invalid value of Fibonacci number index. The allowed index value is from 1 to" + ARRAY_LENGTH + ".");
        }

        if (lastComputedFibonacciNumberIndex < index) {
            for (int i = lastComputedFibonacciNumberIndex; i < index; i++) {
                fibonacciNumbersStorage[i] = fibonacciNumbersStorage[i - 2] + fibonacciNumbersStorage[i - 1];
            }

            lastComputedFibonacciNumberIndex = index;
        }

        return fibonacciNumbersStorage[index - 1];
    }
}
