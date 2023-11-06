package basic.lab2.task1;

/**
 * Interface of array compute strategy.
 */
public interface ArrayComputeStrategy {

    /**
     * Return random integer by range from 20 to 30.
     * @return random integer.
     */
    int getRandomInteger();

    /**
     * Populates the given two-dimensional integer array with randomly generated positive odd numbers.
     * @param integerArray two-dimensional array of integers.
     */
    void fillIntegerArray(int[][] integerArray);

    /**
     * Fills the given string array with elements composed of the character according to the
     * maximum value in each row of the array of integers.
     * @param stringArray array of strings;
     * @param integerArray two-dimensional array of integers;
     * @param character letter
     */
    void fillStringArray(String[] stringArray, int[][] integerArray, char character);

    /**
     * Prints the provided two-dimensional array of integers to the console.
     * @param integerArray two-dimensional array of integers.
     */
    void printArray(int[][] integerArray);

    /**
     * Prints the provided array of strings to the console.
     * @param stringArray array of strings.
     */
    void printArray(String[] stringArray);

    /**
     * Finds the maximum value in the provided row of an array of integers.
     * @param integerArray row of an array of integers;
     * @return maximum value in the provided row of an array of integers.
     */
    int findMaxValueInArray(int[] integerArray);

    /**
     * Rearranges the given string array in reverse alphabetical order using the bubble sort algorithm.
     * @param stringArray array of strings.
     */
    void sortDesc(String[] stringArray);
}
