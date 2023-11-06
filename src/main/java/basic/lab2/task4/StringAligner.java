package basic.lab2.task4;

public class StringAligner {

    private static StringBuilder getStringBuilder(int numberOfSpacesToAdd, int countOfWords, String[] words) {
        int numberOfSpacesBetweenWords = numberOfSpacesToAdd / (countOfWords - 1);
        int numberOfAdditionalSpaces = numberOfSpacesToAdd % (countOfWords - 1);

        StringBuilder result = new StringBuilder(words[0]);
        for (int i = 1; i < countOfWords; i++) {
            result.append(" ".repeat(numberOfSpacesBetweenWords));
            if (i <= numberOfAdditionalSpaces) {
                result.append(" ");
            }

            result.append(words[i]);
        }

        return result;
    }

    public static String align(String inputString, int neededLength) throws Exception {
        if (neededLength <= 0) {
            throw new Exception("Error! Needed string length must be greater than zero.");
        }

        if (inputString.length() > neededLength) {
            throw new Exception("Error! `inputString` length must be less or equal argument `neededLength`. " +
                    "Details: `inputString`: " + inputString.length() + "; `neededLength`: " + neededLength + ";");
        }

        String[] words = inputString.split("\\s+");
        int countOfWords = words.length;
        int numberOfSpacesToAdd = neededLength - inputString.length();

        if (countOfWords == 1) {
            return inputString + " ".repeat(numberOfSpacesToAdd);
        } else {
            return getStringBuilder(numberOfSpacesToAdd, countOfWords, words).toString();
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error! You must pass 2 arguments.");
            System.exit(1);
        }

        try {
            int neededLength = Integer.parseInt(args[1]);
            String stringValue = args[0];
            System.out.println(align(stringValue, neededLength));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
