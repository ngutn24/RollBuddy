package main.java;

/**
 * The Dice ENUM encompasses the 8 different types of Dice
 * available to a player in D and D 5E. Each ENUM has an attached
 * integer value in accordance with dice type.
 */

public enum Dice {
    D4(4, "d4"),
    D6(6, "d6"),
    D8(8, "d8"),
    D10(10, "d10"),
    D12(12, "d12"),
    D20(20, "d20"),
    D100(100, "d100");

    /**
     * Each Dice enum as a corresponding integer value which
     * numerically represents the dice type
     */
    public final int range;
    public final String diceType;

    private Dice(final int range, String diceType) {
        this.range = range;
        this.diceType = diceType;
    }

    public static Dice fromString(final String enteredType) {
        for (Dice d : Dice.values()) {
            if (d.diceType.equals(enteredType)) {
                return d;
            }
        }
        return null;
    }
}
