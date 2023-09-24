package basic.lab1.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationFunctionTest {
    @Test
    @DisplayName("Method `validateInput()` should throw exceptions.")
    void testValidateInputThrowException() {
        Assertions.assertThrows(Exception.class, () -> CalculationFunction.validateInput(0, 10, -1));
        Assertions.assertThrows(Exception.class, () -> CalculationFunction.validateInput(0, 0, 0));
        Assertions.assertThrows(Exception.class, () -> CalculationFunction.validateInput(10, 0, 2));
        Assertions.assertThrows(Exception.class, () -> CalculationFunction.validateInput(-10, -20, 1));
        Assertions.assertThrows(Exception.class, () -> CalculationFunction.validateInput(0.1, 0.01, 1));
    }

    @Test
    @DisplayName("Method `calculateY()` should return valid result.")
    void testCalculateY() {
        Assertions.assertEquals(22.498668156113357, CalculationFunction.calculateY(-5));
        Assertions.assertEquals(9.38776229174348, CalculationFunction.calculateY(0));
        Assertions.assertEquals(10.790317539865102, CalculationFunction.calculateY(2.5));
        Assertions.assertEquals(11.071917702349428, CalculationFunction.calculateY(5));

        Assertions.assertEquals(12.0, CalculationFunction.calculateY(6));
        Assertions.assertEquals(10.0, CalculationFunction.calculateY(10));
    }
}
