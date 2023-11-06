package basic.lab2.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EratosthenesTest {

    private static final int DEFAULT_ARRAY_LENGTH = 300;

    private static final int DEFAULT_NON_PRIME_NUMBER_FLAG = -1;

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        if (number <= 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
    @Test
    @DisplayName("Method `createArrayOfNumbers()` should return array length is `DEFAULT_ARRAY_LENGTH`.")
    void testCreateArrayOfNumbers() {
        Assertions.assertEquals(DEFAULT_ARRAY_LENGTH, Eratosthenes.createArrayOfNumbers().length);
    }

    @Test
    @DisplayName("Method `replaceNonPrimeNumbers()` should return array with -1 values instead of non-prime numbers.")
    void testReplaceNonPrimeNumbers() {
        int[] testArray = Eratosthenes.createArrayOfNumbers();
        Eratosthenes.replaceNonPrimeNumbers(testArray);

        for (int value : testArray) {
            if (!isPrime(value)) {
                Assertions.assertEquals(value, DEFAULT_NON_PRIME_NUMBER_FLAG);
            }
        }
    }

    @Test
    @DisplayName("Method `getPrimeNumbers()` should return array with prime numbers.")
    void testGetPrimeNumbers() {
        int[] testPrimeNumbers = Eratosthenes.getPrimeNumbers(
                Eratosthenes.createArrayOfNumbers()
        );

        for (int value : testPrimeNumbers) {
            Assertions.assertTrue(isPrime(value));
        }
    }
}
