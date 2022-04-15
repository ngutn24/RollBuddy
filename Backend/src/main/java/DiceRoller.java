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
     * This function represents rolling a D4 (4 sided) dice 
     * 
     * @param diceCount The number of times we want a specific dice to be rolled  
     * @param modifier The modifer that gets tagged at the end of a "dice roll"
     * 
     * @return Randomly generated number based on diceCount + the modifier  
     */
    int D4(int diceCount, int modifier) {
        int total = 0;
        // Roll the dice 
        while (diceCount != 0 ) {
            // Generate random number between 1-4 
            total += dice.nextInt(4) + 1;
            diceCount--;  
        }
        // Modifiers get added at the end of all total diceRolls in DnD
        return total + modifier;
    }

    /**
     * This function represents rolling a D6 (6 sided) dice 
     * 
     * @param diceCount The number of times we want a specific dice to be rolled  
     * @param modifier The modifer that gets tagged at the end of a "dice roll"
     * 
     * @return Randomly generated number based on diceCount + the modifier  
     */
    int D6(int diceCount, int modifier) {
        int total = 0;
        // Roll the dice 
        while (diceCount != 0 ) {
            // Generate random number between 1-6 
            total += dice.nextInt(6) + 1;
            diceCount--;  
        }
        // Modifiers get added at the end of all total diceRolls in DnD
        return total + modifier;
    }

    /**
     * This function represents rolling a D8 (8 sided) dice 
     * 
     * @param diceCount The number of times we want a specific dice to be rolled  
     * @param modifier The modifer that gets tagged at the end of a "dice roll"
     * 
     * @return Randomly generated number based on diceCount + the modifier  
     */
    int D8(int diceCount, int modifier) {
        int total = 0;
        // Roll the dice 
        while (diceCount != 0 ) {
            // Generate random number between 1-4 
            total += dice.nextInt(8) + 1;
            diceCount--;  
        }
        // Modifiers get added at the end of all total diceRolls in DnD
        return total + modifier;
    }

    /**
     * This function represents rolling a D10 (10 sided) dice 
     * 
     * @param diceCount The number of times we want a specific dice to be rolled  
     * @param modifier The modifer that gets tagged at the end of a "dice roll"
     * 
     * @return Randomly generated number based on diceCount + the modifier  
     */
    int D10(int diceCount, int modifier) {
        int total = 0;
        // Roll the dice 
        while (diceCount != 0 ) {
            // Generate random number between 1-10 
            total += dice.nextInt(10) + 1;
            diceCount--;  
        }
        // Modifiers get added at the end of all total diceRolls in DnD
        return total + modifier;
    }

    /**
     * This function represents rolling a D12 (12 sided) dice 
     * 
     * @param diceCount The number of times we want a specific dice to be rolled  
     * @param modifier The modifer that gets tagged at the end of a "dice roll"
     * 
     * @return Randomly generated number based on diceCount + the modifier  
     */
    int D12(int diceCount, int modifier) {
        int total = 0;
        // Roll the dice 
        while (diceCount != 0 ) {
            // Generate random number between 1-12 
            total += dice.nextInt(12) + 1;
            diceCount--;  
        }
        // Modifiers get added at the end of all total diceRolls in DnD
        return total + modifier;
    }

    /**
     * This function represents rolling a D20 (20 sided) dice 
     * 
     * @param diceCount The number of times we want a specific dice to be rolled  
     * @param modifier The modifer that gets tagged at the end of a "dice roll"
     * 
     * @return Randomly generated number based on diceCount + the modifier  
     */
    int D20(int diceCount, int modifier) {
        int total = 0;
        // Roll the dice 
        while (diceCount != 0 ) {
            // Generate random number between 1-20 
            total += dice.nextInt(20) + 1;
            diceCount--;  
        }
        // Modifiers get added at the end of all total diceRolls in DnD
        return total + modifier;
    }

    /**
     * This function represents rolling a D100 (100 sided) dice 
     * 
     * @param diceCount The number of times we want a specific dice to be rolled  
     * @param modifier The modifer that gets tagged at the end of a "dice roll"
     * 
     * @return Randomly generated number based on diceCount + the modifier  
     */
    int D100(int diceCount, int modifier) {
        int total = 0;
        // Roll the dice 
        while (diceCount != 0 ) {
            // Generate random number between 1-100 
            total += dice.nextInt(100) + 1;
            diceCount--;  
        }
        // Modifiers get added at the end of all total diceRolls in DnD
        return total + modifier;
    }
}