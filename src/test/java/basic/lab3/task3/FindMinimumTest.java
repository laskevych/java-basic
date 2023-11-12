package basic.lab3.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMinimumTest {
    @Test()
    @DisplayName("Methods of class `FindMinimum` should return correct values.")
    void testFindMinimum() throws Exception {
        double start = 3,
                end = 10,
                step = 2;

        double expectValueByPow = 9;
        double expectValueByCubeRoot = 1.4422495703074083;

        Assertions.assertEquals(expectValueByPow, FindMinimum.findMinValueByAbstractClass(start, end, step, new PowWithAbstractClass()));
        Assertions.assertEquals(expectValueByCubeRoot, FindMinimum.findMinValueByAbstractClass(start, end, step, new CubeRootWithAbstractClass()));

        Assertions.assertEquals(expectValueByPow, FindMinimum.findMinValueByInterface(start, end, step, new PowWithInterface()));
        Assertions.assertEquals(expectValueByCubeRoot, FindMinimum.findMinValueByInterface(start, end, step, new CubeRootWithInterface()));

        Assertions.assertEquals(expectValueByPow, FindMinimum.findMinValueByAnonymousClassPow(start, end, step));
        Assertions.assertEquals(expectValueByCubeRoot, FindMinimum.findMinValueByAnonymousClassCubeRoot(start, end, step));

        Assertions.assertEquals(expectValueByPow, FindMinimum.findMinValueByLambdaExpressionsPow(start, end, step));
        Assertions.assertEquals(expectValueByCubeRoot, FindMinimum.findMinValueByLambdaExpressionsCubeRoot(start, end, step));

        Assertions.assertEquals(expectValueByPow, FindMinimum.findMinValueByReferencesToMethodPow(start, end, step));

        Assertions.assertEquals(expectValueByCubeRoot, FindMinimum.findMinValueByReferencesToMethodCubeRoot(start, end, step));
    }
}
