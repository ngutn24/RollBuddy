import java.util.Random;

/**
 * A local dice roller which generates a random number output based on the
 * requested dice type
 */

public class DiceRoller {

    Random dice;

    /**
     * Initialize a DiceRoller object based on the random library
     */
    public DiceRoller() {
        dice = new Random();
    }

    /**
     * This function represents a dice roll. The theoretical range of the number
     * of sided dice is infinite, so long as it is positive
     * 
     * @param diceCount The number of times we want a specific dice to be rolled
     * @param modifier  The modifer that gets tagged at the end of a "dice roll"
     * @param DiceType  The type of dice being rolled
     * 
     * @return Randomly generated number based on diceCount + the modifier + dice
     *         type
     */
    int Roll(int diceCount, int modifier, int DiceType) {

        assert (diceCount > 0) : "The dice count must be positive";
        assert (DiceType > 0) : "Cannot roll a negative sided dice";

        int total = 0;
        // Roll the dice
        while (diceCount != 0) {
            // Generate random number between 1-4
            total += dice.nextInt(DiceType) + 1;
            diceCount--;
        }
        // Modifiers get added at the end of all total diceRolls in DnD
        return total + modifier;
    }

}