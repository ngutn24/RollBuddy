package main.java;

public class AbilityModifer {
    private static final int BASE_MOD = 10;

    /**
     * Take an ability score input and mathematically calculate the associated
     * modifier
     *
     * @param abilityScore The ability score tied to a specific modifer
     * @return Modifier based on ability score
     */
    public static int generateModifier(int abilityScore) {
        // Calculate how far from baseMod the abilityScore is
        int deviation = abilityScore - BASE_MOD;

        if (deviation >= 0) {
            return deviation / 2;
        } else {
            return (deviation + 1) / 2 - 1;
        }
    }
}
