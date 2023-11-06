package basic.lab2.task1;

/**
 * The {@code ArrayCompute} class performs some operations on a two-dimensional array of integers
 * and an array of strings.
 * <p> It provides a traditional strategy that uses loops and individual elements
 * and a functional strategy that uses functions of the Arrays class (without loops).
 */
public class ArrayCompute {

    /** The count of rows in the integer array and the count of elements in the string array. */
    private static final int NUMBER_OF_ROWS = 4;

    /** The count of columns in the integer array. */
    private static final int NUMBER_OF_COLUMNS = 3;

    /** The character utilized for string filling. */
    private static final char DEFAULT_CHAR = 'N';

    /** Current strategy of compute logic */
    private final ArrayComputeStrategy strategy;

    /**
     * Create new object of class {@code ArrayCompute} with strategy {@code ArrayComputeStrategy}
     * @param strategy the strategy that will be used to calculate the array.
     */
    public ArrayCompute(ArrayComputeStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Populates the given two-dimensional integer array with randomly generated positive odd numbers.
     * @param integerArray two-dimensional array of integers.
     * @see ArrayComputeStrategy#fillIntegerArray(int[][])
     */
    public void fillArrayWithIntegers(int[][] integerArray) {
        this.strategy.fillIntegerArray(integerArray);
    }

    /**
     * Fills the given string array with elements composed of the character according to the
     * maximum value in each row of the array of integers.
     * @param stringArray array of strings;
     * @param integerArray two-dimensional array of integers;
     * @see ArrayComputeStrategy#fillStringArray(String[], int[][], char)
     */
    public void fillStringArray(String[] stringArray, int[][] integerArray) {
        this.strategy.fillStringArray(stringArray, integerArray, DEFAULT_CHAR);
    }

    /**
     * Prints the provided two-dimensional array of integers to the console.
     * @param integerArray two-dimensional array of integers.
     * @see ArrayComputeStrategy#printArray(int[][])
     */
    public void printIntegerArray(int[][] integerArray) {
        this.strategy.printArray(integerArray);
    }

    /**
     * Prints the provided array of strings to the console.
     * @param stringArray array of strings.
     * @see ArrayComputeStrategy#printArray(String[])
     */
    public void printStringArray(String[] stringArray) {
        this.strategy.printArray(stringArray);
    }

    /**
     * Rearranges the given string array in reverse alphabetical order using the bubble sort algorithm.
     * @param stringArray array of strings.
     * @see ArrayComputeStrategy#sortDesc(String[])
     */
    public void sortStringArrayByDesc(String[] stringArray) {
        this.strategy.sortDesc(stringArray);
    }

    /**
     * Operates on arrays using the strategy and using the test array of integers and filling the array
     * of strings with multiple characters or specified character.
     * <p> Prints the array of integers. Fills the array of strings with the {@value #DEFAULT_CHAR} character
     * based on the maximum value in each row of the array of integers. Prints the array of strings. Sorts the array
     * of strings in reverse alphabetical order and prints it.
     */
    public void compute() {
        int[][] integerArray = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        this.fillArrayWithIntegers(integerArray);

        System.out.println("Array of integers:");
        this.printIntegerArray(integerArray);

        String[] stringArray = new String[NUMBER_OF_ROWS];
        this.fillStringArray(stringArray, integerArray);
        System.out.println("Array of strings before sorting:");
        this.printStringArray(stringArray);

        this.sortStringArrayByDesc(stringArray);
        System.out.println("Array of strings after sorting:");
        this.printStringArray(stringArray);
    }
}
