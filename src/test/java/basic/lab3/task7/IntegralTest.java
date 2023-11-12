package basic.lab3.task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegralTest {
    @Test()
    @DisplayName("Method `integral()` of classes `IntegralWithRectangularMethod` and `IntegralWithTrapezoidalMethod` should return correct value.")
    void testIntegral() throws Exception {
        double start = -2, end = 1, accuracy = 0.0001;

        IntegralWithRectangularMethod firstIntegrator = new IntegralWithRectangularMethod();
        IntegralWithTrapezoidalMethod secondIntegrator = new IntegralWithTrapezoidalMethod();

        Assertions.assertEquals(3.000750045000114, firstIntegrator.integral(start, end, accuracy));
        Assertions.assertEquals(3.0003001350136334, secondIntegrator.integral(start, end, accuracy));
    }
}
