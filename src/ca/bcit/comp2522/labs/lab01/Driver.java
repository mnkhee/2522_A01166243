package ca.bcit.comp2522.labs.lab01;

/**
 * Simulates the races by running them in the main method of the program. Tortoise wins most often.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Driver {
    private static final int LENGTH_100 = 100;
    private static final int NUMBER_OF_RACES_1000 = 1000;
    private static final int NUMBER_OF_RACES = 100;

    /**
     * Simulates multiple races between the Hare and Tortoise objects.
     *
     * @param numOfRaces The first parameter for this method.
     *                   It specifies the number of races done.
     *                   It is an integer type value.
     * @param lengthOfRace The second parameter for this method.
     *                     It specifies the length of the race.
     *                     It is an integer type value.
     * @return A formatted String object stating the amount of times
     * the Hare and Tortoise objects won the race.
     */

    public static String simulateRaces(final int numOfRaces, final int lengthOfRace) {
        final Race race = new Race(lengthOfRace);

        for (int races = 0; races < numOfRaces; races++) {
            race.simulateRace();
        }
        return String.format("Hare won %d time(s).\nTortoise won %d times.",
                race.getHareWins(), race.getTortoiseWins());
    }

    /**
     * Runs the simulateRaces method to simulate the races. Prints out the results.
     *
     * @param args The only parameter for this method. It is not used.
     */

    public static void main(final String[] args) {
        final Race oneRace = new Race(LENGTH_100);

        String resultOneRace = oneRace.simulateRace();

        if (resultOneRace.equals("Tortoise")) {
            resultOneRace = resultOneRace + " wins in " + oneRace.getClockTicks()
                    + " clock ticks at position " + oneRace.getTortoise().getPosition()
                    + "." + " Hare was at position " + oneRace.getHare().getPosition() + ".";
        } else {
            resultOneRace = resultOneRace + " wins in " + oneRace.getClockTicks()
                    + " clock ticks at position " + oneRace.getHare().getPosition()
                    + "." + " Tortoise was at position "
                    + oneRace.getTortoise().getPosition() + ".";
        }

        System.out.println(resultOneRace);
        System.out.println(simulateRaces(NUMBER_OF_RACES, LENGTH_100));
        System.out.println(simulateRaces(NUMBER_OF_RACES_1000, LENGTH_100));
    }
}
