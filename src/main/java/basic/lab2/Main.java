package basic.lab2;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 3, 4, 5};

        /*for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }*/

//        for (int n : numbers) {
//            System.out.println(n);
//        }

        printIntegers(1, 2, 3, 4, 5, 6);
    }

    static void printIntegers(int... a) {
        for (int j : a) {
            System.out.println(j);
        }
    }
}
