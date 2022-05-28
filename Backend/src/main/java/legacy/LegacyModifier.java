package main.java.legacy;

/**
 * In Dungeons and Dragon, every character has 6 ability scores (STR, DEX, CON,
 * INT, WIS, CHA)
 * Generally, the stats range from 1 to 20 but theoretically can be any number
 * An ability score of 10 is the average, which nets you a modifier of +0 to
 * that ability
 * Example:
 * Strength ability score = 10
 * Strength modifier = + 0
 * <p>
 * Starting from 10, every increment of 2 gives you a +1 to your modifier
 * <p>
 * Example:
 * Strength ability score = 15
 * Strength modifier = +2
 * <p>
 * Strength ability score = 16
 * Strength modifier = +3
 * <p>
 * Should your modifier be 9, you get a -1 to your modifier. Every decrement of
 * 2 from 9 gives you a subsequent -1
 * <p>
 * Example:
 * Strength ability score = 9
 * Strength modifier = -1
 * <p>
 * Strength ability score = 8
 * Strength modifier = -1
 * <p>
 * Strength ability score = 7
 * Stregnth modifier = -2
 */

public class LegacyModifier {
    private final int baseMod = 10;

    private int abilityScore;
    private int mod;

    /**
     * Intialize a Modifier object containing the ability and corresponding modifier
     *
     * @param abilityScore Specified ability score
     */
    public LegacyModifier(int abilityScore) {
        this.abilityScore = abilityScore;
        this.mod = generateModifier(abilityScore);
    }

    /**
     * Take an ability score input and mathematically calculate the associated
     * modifier
     *
     * @param abilityScore The ability score tied to a specific modifer
     * @return Modifier based on ability score
     */
    private int generateModifier(int abilityScore) {
        // Calculate how far from baseMod the abilityScore is
        int deviation = abilityScore - baseMod;

        if (deviation >= 0) {
            return deviation / 2;
        } else {
            return (deviation + 1) / 2 - 1;
        }
    }

    /**
     * Set the new ability score and calculate the new modifier
     *
     * @param abilityScore The new ability score
     */
    public void setAbilityScore(int abilityScore) {
        this.abilityScore = abilityScore;
        this.mod = generateModifier(abilityScore);
    }

    /**
     * Get the ability score
     */
    public int getAbilityScore() {
        return this.abilityScore;
    }

    /**
     * Get the modifier
     */
    public int getMod() {
        return this.mod;
    }
}