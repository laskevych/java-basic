package basic.lab2.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class FibonacciTest {

    private static final int MIN_FIBONACCI_NUMBER_INDEX = 1;
    private static final int MAX_FIBONACCI_NUMBER_INDEX = 92;

    @Test()
    @DisplayName("Method `getFibonacciNumberByIndex()` should throw exception while " +
            "index is less than `MIN_FIBONACCI_NUMBER_INDEX` or greater `MAX_FIBONACCI_NUMBER_INDEX`.")
    void testGetFibonacciNumberByIndexThrowExceptions() {
        Assertions.assertThrows(
                Exception.class, () -> Fibonacci.getFibonacciNumberByIndex(MIN_FIBONACCI_NUMBER_INDEX - 1)
        );

        Assertions.assertThrows(
                Exception.class, () -> Fibonacci.getFibonacciNumberByIndex(MAX_FIBONACCI_NUMBER_INDEX + 1)
        );
    }

    @Test()
    @DisplayName("Method `getFibonacciNumberByIndex()` should return valid Fibonacci number by index.")
    void testGetFibonacciNumberByIndex() throws Exception {
        Assertions.assertEquals(1, Fibonacci.getFibonacciNumberByIndex(MIN_FIBONACCI_NUMBER_INDEX));
        Assertions.assertEquals(2, Fibonacci.getFibonacciNumberByIndex(3));
        Assertions.assertEquals(832040, Fibonacci.getFibonacciNumberByIndex(30));
        Assertions.assertEquals(1134903170, Fibonacci.getFibonacciNumberByIndex(45));
        Assertions.assertEquals((new BigInteger("7540113804746346429")).longValue(), Fibonacci.getFibonacciNumberByIndex(MAX_FIBONACCI_NUMBER_INDEX));
    }
}
