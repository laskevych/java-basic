package basic.lab1.task3;

import basic.lab1.task3.ContinueAndBreak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ContinueAndBreakTest {

    private static final int INVALID_NUMBER_OF_ITERATIONS = 0;
    private static final int VALID_NUMBER_OF_ITERATIONS = 3;

    @Test
    @DisplayName("Method `calculate()` should return valid result.")
    void testCalculation() throws Exception {
        Assertions.assertEquals(1.0, ContinueAndBreak.calculate(1.0, VALID_NUMBER_OF_ITERATIONS));;
        Assertions.assertEquals(1.8049999999999995, ContinueAndBreak.calculate(3.0, VALID_NUMBER_OF_ITERATIONS));
    }

    @Test
    @DisplayName("Method `calculate()` should throw exceptions.")
    void testCalculationThrowException() {
        Assertions.assertThrows(Exception.class, () -> ContinueAndBreak.calculate(1, INVALID_NUMBER_OF_ITERATIONS));
        Assertions.assertThrows(Exception.class, () -> ContinueAndBreak.calculate(0, VALID_NUMBER_OF_ITERATIONS));
        Assertions.assertThrows(Exception.class, () -> ContinueAndBreak.calculate(-1, VALID_NUMBER_OF_ITERATIONS));
    }
}
