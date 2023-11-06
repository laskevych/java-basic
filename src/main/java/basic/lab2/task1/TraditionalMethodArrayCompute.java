package basic.lab2.task1;

import java.util.Random;

/**
 * Strategy that uses loops and individual elements.
 */
public class TraditionalMethodArrayCompute implements ArrayComputeStrategy {
    @Override
    public int getRandomInteger() {
        return (new Random()).nextInt(11) + 20;
    }

    @Override
    public void fillIntegerArray(int[][] integerArray) {
        for (int i = 0; i < integerArray.length; i++) {
            for (int j = 0; j < integerArray[i].length; j++) {
                integerArray[i][j] = this.getRandomInteger();
            }
        }
    }

    @Override
    public void fillStringArray(String[] stringArray, int[][] integerArray, char character) {
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = String.valueOf(character)
                    .repeat(findMaxValueInArray(integerArray[i]));
        }
    }

    @Override
    public void printArray(int[][] integerArray) {
        for (int[] row : integerArray) {
            System.out.print('[');

            for (int j = 0; j < row.length - 1; j++) {
                System.out.print(row[j] + ", ");
            }

            System.out.println(row[row.length - 1] + "]");
        }
    }

    @Override
    public void printArray(String[] stringArray) {
        for (String s : stringArray) {
            System.out.println(s);
        }
    }

    @Override
    public int findMaxValueInArray(int[] integerArrayRow) {
        int maxValue = integerArrayRow[0];

        for (int i = 1; i < integerArrayRow.length; i++) {
            if (integerArrayRow[i] > maxValue) {
                maxValue = integerArrayRow[i];
            }
        }

        return maxValue;
    }

    @Override
    public void sortDesc(String[] stringArray) {
        boolean isUnsorted = true;

        while (isUnsorted) {
            isUnsorted = false;
            for (int i = 0; i < stringArray.length - 1; i++) {
                if (stringArray[i].compareTo(stringArray[i + 1]) < 0) {
                    String tString = stringArray[i];
                    stringArray[i] = stringArray[i + 1];
                    stringArray[i + 1] = tString;
                    isUnsorted = true;
                }
            }
        }
    }
}
