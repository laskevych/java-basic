package basic.lab2.task2;

import java.util.Arrays;

public class Eratosthenes {
    private static final int ARRAY_LENGTH = 300;
    private static final int NEGATIVE_VALUE = -1;

    static int[] createArrayOfNumbers() {
        int[] numbers = new int[ARRAY_LENGTH];
        Arrays.setAll(numbers, (i) -> i + 1);

        return numbers;
    }

    static void replaceNonPrimeNumbers(int[] numbers) {
        numbers[0] = NEGATIVE_VALUE;

        for (int i = 2; i * i <= ARRAY_LENGTH; i++) {
            if (numbers[i - 1] != NEGATIVE_VALUE) {
                for (int j = i + i; j <= ARRAY_LENGTH; j += i) {
                    if (numbers[j - 1] != NEGATIVE_VALUE) {
                        numbers[j - 1] = NEGATIVE_VALUE;
                    }
                }
            }
        }
    }

    static int[] getPrimeNumbers(int[] numbers) {
        replaceNonPrimeNumbers(numbers);
        return Arrays.stream(numbers)
                .filter(value -> value != NEGATIVE_VALUE)
                .toArray();
    }

    static void printArray(int[] array) {
        int counter = 0;

        for (int value : array) {
            if (counter == 10) {
                System.out.println();
                counter = 0;
            }

            System.out.print(value + "\t");
            counter++;
        }
    }

    public static void main(String[] args) {
        int[] arrayOfNumbers = createArrayOfNumbers();
        System.out.println("The array of prime numbers from 1 to 300:");
        printArray(getPrimeNumbers(arrayOfNumbers));
    }
}
