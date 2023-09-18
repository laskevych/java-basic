package basic.lab1.task4;

import basic.lab1.task4.utils.BooleanConverter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class BooleanConverterTest {
    @Test
    @DisplayName("Test BooleanConverter.convert() - integer.")
    void testConvertIntToBoolean() {
        Assertions.assertFalse(BooleanConverter.convert(0));
        Assertions.assertTrue(BooleanConverter.convert(1));
    }

    @Test
    @DisplayName("Test BooleanConverter.convert() - boolean.")
    void testConvertBooleanToInt() {
        Assertions.assertEquals(0, BooleanConverter.convert(false));
        Assertions.assertEquals(1, BooleanConverter.convert(true));
    }
}