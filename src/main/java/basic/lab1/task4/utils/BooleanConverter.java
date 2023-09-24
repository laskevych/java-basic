package basic.lab1.task4.utils;

public class BooleanConverter
{
    public static int convert(boolean value) {
        return value ? 1 : 0;
    }

    public static boolean convert(int value) {
        return value != 0;
    }
}
