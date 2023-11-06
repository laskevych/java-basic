package basic.lab2.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAlignerTest {
    private static final int MIN_NEEDED_LENGTH = 1;

    @Test()
    @DisplayName("Method `align()` should return correct value.")
    void testAlign() throws Exception {
        Assertions.assertEquals(
                "Hello     ",
                StringAligner.align("Hello", 10)
        );

        Assertions.assertEquals(
                "Hello     Java",
                StringAligner.align("Hello Java", 15)
        );
    }

    @Test()
    @DisplayName("Method `align()` should throw exception while " +
            "`neededLength` is less than `MIN_NEEDED_LENGTH`(1) or `inputString` length greater then `neededLength`.")
    void testAlignThrowExceptions() {
        Assertions.assertThrows(
                Exception.class, () -> StringAligner.align("Hello", MIN_NEEDED_LENGTH - 1)
        );

        Assertions.assertThrows(
                Exception.class, () -> StringAligner.align("Hello", MIN_NEEDED_LENGTH)
        );
    }
}
