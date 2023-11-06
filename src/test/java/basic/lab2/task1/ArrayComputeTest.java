package basic.lab2.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayComputeTest {

    private static final int NUMBER_OF_ROWS = 4;
    private static final int NUMBER_OF_COLUMNS = 3;
    private static final int MIN_NUMBER = 20;
    private static final int MAX_NUMBER = 30;

    private static int findMinOrMaxValueInArray(int[] integerArray, boolean findMin) {
        int value = integerArray[0];

        for (int i = 1; i < integerArray.length; i++) {
            if (findMin) {
                if (integerArray[i] < value) {
                    value = integerArray[i];
                }
            } else {
                if (integerArray[i] > value) {
                    value = integerArray[i];
                }
            }
        }

        return value;
    }

    @Test
    @DisplayName("Method `fillArrayWithIntegers()` should return correct value by traditional method.")
    void testFillArrayByTraditionalMethod() {
        int[][] testArray = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

        TraditionalMethodArrayCompute strategy = new TraditionalMethodArrayCompute();
        ArrayCompute arrayCompute = new ArrayCompute(strategy);
        arrayCompute.fillArrayWithIntegers(testArray);

        for (int[] row : testArray) {
            int minValue = findMinOrMaxValueInArray(row, true);
            int maxValue = findMinOrMaxValueInArray(row, false);

            Assertions.assertTrue(minValue >= MIN_NUMBER);
            Assertions.assertTrue(maxValue <= MAX_NUMBER);
        }
    }

    @Test
    @DisplayName("Method `fillArrayWithIntegers()` should return correct value by functional method.")
    void testFillArrayByFunctionalMethod() {
        int[][] testArray = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

        FunctionMethodArrayCompute strategy = new FunctionMethodArrayCompute();
        ArrayCompute arrayCompute = new ArrayCompute(strategy);
        arrayCompute.fillArrayWithIntegers(testArray);

        for (int[] row : testArray) {
            int minValue = findMinOrMaxValueInArray(row, true);
            int maxValue = findMinOrMaxValueInArray(row, false);

            Assertions.assertTrue(minValue >= MIN_NUMBER);
            Assertions.assertTrue(maxValue <= MAX_NUMBER);
        }
    }

    @Test
    @DisplayName("Logic of traditional method should return correct values.")
    void testLogicOfTraditionalMethod() {
        int[][] testArray = new int[][] {
                {20, 21, 20},
                {29, 20, 25},
                {28, 27, 26},
                {30, 29, 30},
        };

        TraditionalMethodArrayCompute strategy = new TraditionalMethodArrayCompute();
        ArrayCompute arrayCompute = new ArrayCompute(strategy);

        String[] stringArray = new String[NUMBER_OF_ROWS];
        arrayCompute.fillStringArray(stringArray, testArray);

        Assertions.assertEquals(21, stringArray[0].length());
        Assertions.assertEquals(30, stringArray[3].length());

        arrayCompute.sortStringArrayByDesc(stringArray);

        Assertions.assertEquals(30, stringArray[0].length());
        Assertions.assertEquals(21, stringArray[3].length());
    }

    @Test
    @DisplayName("Logic of functional method should return correct values.")
    void testLogicOfFunctionalMethod() {
        int[][] testArray = new int[][] {
                {20, 21, 20},
                {29, 20, 25},
                {28, 27, 26},
                {30, 29, 30},
        };

        FunctionMethodArrayCompute strategy = new FunctionMethodArrayCompute();
        ArrayCompute arrayCompute = new ArrayCompute(strategy);

        String[] stringArray = new String[NUMBER_OF_ROWS];
        arrayCompute.fillStringArray(stringArray, testArray);

        Assertions.assertEquals(21, stringArray[0].length());
        Assertions.assertEquals(30, stringArray[3].length());

        arrayCompute.sortStringArrayByDesc(stringArray);

        Assertions.assertEquals(30, stringArray[0].length());
        Assertions.assertEquals(21, stringArray[3].length());
    }
}
