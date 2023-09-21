package basic.lab1.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PowerOfEightTest {
    private static final int MIN_EXPONENT = 0;
    private static final int MAX_EXPONENT = 10;
    private static final int OVER_MIN_EXPONENT = MIN_EXPONENT - 1;
    private static final int OVER_MAX_EXPONENT = MAX_EXPONENT + 1;
    private static final int[] CORRECT_VALUES = {1, 8, 64, 512, 4096, 32768, 262144, 2097152, 16777216, 134217728, 1073741824};


    @Test
    @DisplayName("Method `pow()` should return correct compute value.")
    void testPow() throws Exception {
        for (int i = 0; i < CORRECT_VALUES.length; i++) {
            Assertions.assertEquals(CORRECT_VALUES[i], PowerOfEight.pow(i));
        }

    }

    @Test
    @DisplayName("Method `powBitwise()` should return correct compute value.")
    void testPowBitwise() throws Exception {
        for (int i = 0; i < CORRECT_VALUES.length; i++) {
            Assertions.assertEquals(CORRECT_VALUES[i], PowerOfEight.pow(i));
        }
    }

    @Test()
    @DisplayName("Method `pow()` should throw exception while exponent is less than `MIN_EXPONENT` or greater `MAX_EXPONENT`.")
    void testPowThrowExceptionMinExponent() {
        Assertions.assertThrows(Exception.class, () -> PowerOfEight.pow(OVER_MIN_EXPONENT));
        Assertions.assertThrows(Exception.class, () -> PowerOfEight.pow(OVER_MAX_EXPONENT));
    }

    @Test
    @DisplayName("Method `powBitwise()` should throw exception while exponent is less than `MIN_EXPONENT` or greater `MAX_EXPONENT`.")
    void testPowBitwiseThrowExceptionMinExponent() {
        Assertions.assertThrows(Exception.class, () -> PowerOfEight.powBitwise(OVER_MIN_EXPONENT));
        Assertions.assertThrows(Exception.class, () -> PowerOfEight.powBitwise(OVER_MAX_EXPONENT));
    }
}
