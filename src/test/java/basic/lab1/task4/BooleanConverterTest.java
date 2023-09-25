package basic.lab1.task4;

import basic.lab1.task4.utils.BooleanConverter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BooleanConverterTest {
    @Test
    @DisplayName("Method `convert()` should return boolean if pass integer.")
    void testConvertIntToBoolean() {
        Assertions.assertTrue(
                BooleanConverter.convert(-1)
        );

        Assertions.assertFalse(
                BooleanConverter.convert(0)
        );

        Assertions.assertTrue(
                BooleanConverter.convert(1)
        );
    }

    @Test
    @DisplayName("Method `convert()` should return integer if pass boolean.")
    void testConvertBooleanToInt() {
        Assertions.assertEquals(
                0, BooleanConverter.convert(false)
        );

        Assertions.assertEquals(
                1, BooleanConverter.convert(true)
        );
    }
}