package basic.lab3.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMinimumTest {

    private final double
            start = 3,
            end = 10,
            step = 2;

    private final double expectValueByPow = 9;

    private final double expectValueByCubeRoot = 1.4422495703074083;
    @Test()
    @DisplayName("Correct work by `Abstract Class`")
    void testFindMinimumByAbstractClass() {
        Assertions.assertEquals(
                this.expectValueByPow,
                (new PowWithAbstractClass()).findMinValue(this.start, this.end, this.step)
        );

        Assertions.assertEquals(
                this.expectValueByCubeRoot,
                (new CubeRootWithAbstractClass()).findMinValue(this.start, this.end, this.step)
        );
    }

    @Test()
    @DisplayName("Correct work by `Interface`")
    void testFindMinimumByInterface() {
        Assertions.assertEquals(
                this.expectValueByPow,
                Solver.findMinValue(this.start, this.end, this.step, new PowWithInterface())
        );

        Assertions.assertEquals(
                this.expectValueByCubeRoot,
                Solver.findMinValue(this.start, this.end, this.step, new CubeRootWithInterface())
        );
    }

    @Test()
    @DisplayName("Correct work by `Anonymous Class`")
    void testFindMinimumByAnonymousClass() {
        Assertions.assertEquals(
                this.expectValueByPow,
                Solver.findMinValue(this.start, this.end, this.step, new FindValueInterface() {
                    @Override
                    public double function(double x) {
                        return Math.pow(x, 2);
                    }
                })
        );

        Assertions.assertEquals(
                this.expectValueByCubeRoot,
                Solver.findMinValue(this.start, this.end, this.step, new FindValueInterface() {
                    @Override
                    public double function(double x) {
                        return Math.cbrt(x);
                    }
                })
        );
    }

    @Test()
    @DisplayName("Correct work by `Lambda Expressions`")
    void testFindMinimumByLambdaExpressions() {
        Assertions.assertEquals(
                this.expectValueByPow,
                Solver.findMinValue(this.start, this.end, this.step, x -> Math.pow(x, 2))
        );
    }

    @Test()
    @DisplayName("Correct work by `References`")
    void testFindMinimumByReferences() {
        Assertions.assertEquals(
                this.expectValueByCubeRoot,
                Solver.findMinValue(this.start, this.end, this.step, Math::cbrt)
        );
    }
}
