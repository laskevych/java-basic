package basic.lab1.task4.app;

import basic.lab1.task4.utils.BooleanConverter;

import static basic.lab1.task4.utils.BooleanConverter.*;

public class Main {
    public static void main(String[] args) {
        boolean boolValue;

        for (int i = 0; i <= 1; i++) {
            boolValue = convert(i);
            System.out.printf("Integer -> Boolean: %d -> %b%n", i, boolValue);

            i = BooleanConverter.convert(boolValue);
            System.out.printf("Boolean -> Integer: %b -> %d%n", boolValue, i);
        }
    }
}
