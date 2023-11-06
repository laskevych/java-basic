package basic.lab2.task1;

import java.util.Arrays;
import java.util.Random;

/**
 * Strategy uses functions of the Arrays class (without loops).
 */
public class FunctionMethodArrayCompute implements ArrayComputeStrategy {

    @Override
    public int getRandomInteger() {
        return (new Random()).nextInt(11) + 20;
    }

    @Override
    public void fillIntegerArray(int[][] integerArray) {
        Arrays.stream(integerArray).forEach(row -> Arrays.setAll(row, i -> this.getRandomInteger()));
    }

    @Override
    public void fillStringArray(String[] stringArray, int[][] integerArray, char character) {
        Arrays.setAll(stringArray, j -> String.valueOf(character).repeat(findMaxValueInArray(integerArray[j])));
    }

    @Override
    public void printArray(int[][] integerArray) {
        Arrays.stream(integerArray).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    @Override
    public void printArray(String[] stringArray) {
        Arrays.stream(stringArray).forEach(System.out::println);
    }

    @Override
    public int findMaxValueInArray(int[] integerArrayRow) {
        return Arrays.stream(integerArrayRow).max().orElse(0);
    }

    @Override
    public void sortDesc(String[] stringArray) {
        Arrays.sort(stringArray, (s1, s2) -> -s1.compareTo(s2));
    }
}
