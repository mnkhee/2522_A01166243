package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Creates a Hare object with an integer type position attribute and ability to
 * call a move() method to modify the attribute position.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Hare {
    private static final int RANGE = 101;
    private static final int TWENTY_PERCENT = 20;
    private static final int TEN_PERCENT_ONE = 30;
    private static final int TEN_PERCENT_TWO = 40;
    private static final int THIRTY_PERCENT = 70;
    private static final int SMALL_HOP = 1;
    private static final int SMALL_SLIP = 2;
    private static final int BIG_HOP = 9;
    private static final int BIG_SLIP = 12;

    private int position;
    private Random randomNumber = new Random();

    /**
     * Sets the value of the attribute position.
     *
     * @param position The position of the Hare. It is an integer type value.
     */

    public final void setPosition(final int position) {
        this.position = position;
    }

    /**
     * Gets the value of the attribute position.
     *
     * @return The integer type attribute position specific to the instance of the object.
     */

    public final int getPosition() {
        return this.position;
    }

    /**
     * Moves the Hare object by increasing or decreasing the position attribute by random chance.
     *
     * @return The integer type attribute position.
     */

    public final int move() {
        if (randomNumber == null) {
            randomNumber = new Random();
        }

        final int generateRandomNum = randomNumber.nextInt(RANGE);

        if (generateRandomNum <= TWENTY_PERCENT) {
            return position;
        } else if (generateRandomNum <= TEN_PERCENT_ONE) {
            position += BIG_HOP;
            return position;
        } else if (generateRandomNum <= TEN_PERCENT_TWO) {
            position -= BIG_SLIP;
            return position;
        } else if (generateRandomNum <= THIRTY_PERCENT) {
            position += SMALL_HOP;
            return position;
        } else {
            position -= SMALL_SLIP;
            return position;
        }
    }

    /**
     * Checks if the object passed into the method is:
     * 1. Not null.
     * 2. Same object (Address-wise).
     * 3. The same object type.
     * 4. Has the same values within.
     *
     * @param obj The value being compared with. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the
     * same as what it being checked against.
     */

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        final Hare object = (Hare) obj;

        return object.getPosition() == this.position;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Hare.
     */

    @Override
    public final String toString() {
        return "Hare's position is: " + position;
    }
}
