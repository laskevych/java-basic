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
        Assertions.assertEquals(8.103982867798484, CalculationFunction.calculateY(-1));
        Assertions.assertEquals(9.38776229174348, CalculationFunction.calculateY(0));
        Assertions.assertEquals(20.912322183723735, CalculationFunction.calculateY(1));

        Assertions.assertEquals(12.0, CalculationFunction.calculateY(6));
    }
}
