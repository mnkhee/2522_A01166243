package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

/**
 * Calculates different mathematical equations.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Mathematics {
    /**
     * Constant for the first 6 digits of Pi.
     */
    public static final double PI = 3.14159;
    /**
     * Constant for the conversion ratio between one foot and a kilometer.
     */
    public static final double ONE_FOOT_TO_KILOMETRE_RATIO = 0.0003048;
    private final Random randomNumber;

    /**
     * Constructs the object by instantiating a new Random object.
     */

    public Mathematics() {
        this.randomNumber = new Random();
    }

    /**
     * Calculates the area of a circle.
     *
     * @param v The radius of the circle. It is a double type value.
     * @return The area of a circle.
     */

    public double getCircleArea(double v) {
        return PI * Math.pow(v, 2);
    }

    /**
     * Calculates the area of a square.
     *
     * @param v The length of the sides of the square. It is a double type value.
     * @return The area of the square.
     */

    public double getSquareArea(double v) {
        return v * v;
    }

    /**
     * Adds the two parameters together.
     *
     * @param v The first number to be added. It is a double type value.
     * @param v1 The second number to be added. It is a double type value.
     * @return The sum of the two parameters.
     */

    public double add(double v, double v1) {
        return v + v1;
    }

    /**
     * Multiplies the two parameters together.
     *
     * @param v The first number to be multiplied. It is a double type value.
     * @param v1 The second number to be multiplied. It is a double type value.
     * @return The product of the two parameters.
     */

    public double multiply(double v, double v1) {
        return v * v1;
    }

    /**
     * Subtracts the two parameters together.
     *
     * @param v The first number to be subtracted. It is a double type value.
     * @param v1 The second number to be subtracted. It is a double type value.
     * @return The difference of the two parameters.
     */

    public double subtract(double v, double v1) {
        return v - v1;
    }

    /**
     * Divides the two parameters together. Will check of the divisor is 0.
     *
     * @param i The first number to be divided. It is a int type value.
     * @param i1 The second number to be divided. It is a int type value.
     * @return The quotient of the two parameters.
     */

    public double divide(double i, double i1) {
        if (i1 == 0) {
            return 0.0;
        }
        
        return i / i1;
    }

    /**
     * Takes the absolute value of the parameter.
     *
     * @param i The number passed into method. It is an int type value.
     * @return The parameter's absolute value.
     */

    public int absoluteValue(int i) {
        if (i < 0) {
            i *= -1;
        }

        return i;
    }

    /**
     * Generates a random number between the lowerbound and upperbound,
     * not including the invalid number.
     *
     * @return A number between lowerbound and upperbound,
     * not including invalid number.
     */

    public int getRandomNumberBetweenTenAndTwentyButNotFifteen() {
        final int lowerBound = 10;
        final int invalidNumber = 15;
        final int upperBound = 21;
        int newRandomNumber;

        do {
            newRandomNumber = randomNumber.nextInt(upperBound);
        } while (newRandomNumber < lowerBound || newRandomNumber == invalidNumber);

        return newRandomNumber;
    }

    /**
     * Converts the parameter (in feet) into kilometers.
     *
     * @param feet The number to converted. It is a double type value.
     * @return The converted number (in feet) to kilometers.
     */

    public double convertFeetToKilometres(double feet) {
        return ONE_FOOT_TO_KILOMETRE_RATIO * feet;
    }

    /**
     * Sums the integers up to the parameter.
     *
     * @param upperBound The integer that will be summed up to. It is an int type value.
     * @return The sum of the ints up to and including the parameter.
     */

    public int sumOfInts(int upperBound) {
        int intSum = 0;

        for (int num = 0; num <= upperBound; num++) {
            intSum += num;
        }

        return intSum;
    }

    /**
     * Checks if the parameter is positive.
     *
     * @param i The argument passed to check if it is positive. It is an int type value.
     * @return A boolean signifying if the argument is positive.
     */

    public boolean isPositive(int i) {
        return i > 0;
    }

    /**
     * Checks if the parameter is an even number.
     *
     * @param i The argument passed to check if it is even. It is an int type value.
     * @return A boolean signifying if the argument is even.
     */

    public boolean isEven(int i) {
        return i % 2 == 0;
    }

    /**
     * Sums all the even numbers in the range of the parameter.
     *
     * @param upperBound The integer that will be summed up to. It is an int type value.
     * @return The sum of the ints up to and including the parameter that are even.
     */

    public int sumOfEvens(int upperBound) {
        int evenSum = 0;

        if (!isPositive(upperBound)) {
            for (int num = 0; num >= upperBound; num--) {
                if (isEven(num)) {
                    evenSum += num;
                }
            }
        } else {
            for (int num = 0; num <= upperBound; num++) {
                if (isEven(num)) {
                    evenSum += num;
                }
            }
        }

        return evenSum;
    }

    /**
     * Sums all the products of the specified factor in the range of the parameter.
     *
     * @param upperBound The integer that will be summed up to. It is an int type value.
     * @param factor The factor by which the products are determined. It is an int type value.
     * @return The sum of the ints up to and including the parameter that are products of the value
     * passed in the factors parameter.
     */

    public int sumOfProducts(int upperBound, int factor) {
        int productSum = 0;

        if (!isPositive(upperBound)) {
            for (int num = 0; num >= upperBound; num--) {
                if (num % factor == 0) {
                    productSum += num;
                }
            }
        } else {
            for (int num = 0; num <= upperBound; num++) {
                if (num % factor == 0) {
                    productSum += num;
                }
            }
        }

        return productSum;
    }
}

