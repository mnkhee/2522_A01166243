package ca.bcit.comp2522.quizzes.quiz01;

public class AlarmClock {

    /**
     * Finds the amount of bars contained within the valid numbers for each digit.
     *
     * @param numbers The first parameter. It is an array of integer type values.
     * @param sizeOfArray The second parameter. It is an integer type value.
     * @return Returns the highest amount of bars at the specified digit.
     */

    public static int numberFinderBar(final int[] numbers, final int sizeOfArray) {
        for (int i = 0; i < sizeOfArray; i++) {
            boolean isHighest = true;
            for (int j = 0; j < sizeOfArray; j++) {
                if (numbers[i] < numbers[j]) {
                    isHighest = false;
                    break;
                }
            }
            if (isHighest) {
                return numbers[i];
            }
        }
        return 0;
    }

    /**
     * Finds the highest digit corresponding to the highest amount of bars.
     *
     * @param numbers The first parameter. It is an array of integer type values.
     * @param sizeOfArray The second parameter. It is an integer type value.
     * @return Returns the highest digit at the specified digit.
     */

    public static int numberFinderDigit(final int[] numbers, final int sizeOfArray) {
        for (int i = 0; i < sizeOfArray; i++) {
            boolean isHighest = true;
            for (int j = 0; j < sizeOfArray; j++) {
                if (numbers[i] < numbers[j]) {
                    isHighest = false;
                    break;
                }
            }
            if (isHighest) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Finds the highest clock time (24 hr) and the highest amount of bars.
     *
     * @param args Not used.
     */

    public static void main(final String[] args) {
        final int[] numbers = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        final int digit1 = 2;
        final int digit2 = numberFinderDigit(numbers, 5);
        final int digit3 = numberFinderDigit(numbers, 6);
        final int digit4 = numberFinderDigit(numbers, 10);

        final int bar1 = 5;
        final int bar2 = numberFinderBar(numbers, 5);
        final int bar3 = numberFinderBar(numbers, 6);
        final int bar4 = numberFinderBar(numbers, 10);

        final int resultingDigit = bar1 + bar2 + bar3 + bar4;

        System.out.println(String.format("The time with the highest amount of bars is %d%d:%d%d with %d amount of bars",
                digit1, digit2, digit3, digit4, resultingDigit));

    }
}
