package test.java.legacy;

import main.java.legacy.LegacyModifier;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit test suite to verify that a modifier object functions properly
 */
public class ModifierTest {

    /**
     * Test that 0 is the modifier when ability score is 10 (base score)
     */
    @Test
    public void testBaseModifier() {
        LegacyModifier test = new LegacyModifier(10);
        assertEquals(10, test.getAbilityScore());
        assertEquals(0, test.getMod());
    }

    /**
     * Test that correct modifiers are generated as ability
     * score increases
     */
    @Test
    public void testPositiveMod() {
        LegacyModifier test = new LegacyModifier(11);
        assertEquals(0, test.getMod());

        test = new LegacyModifier(12);
        assertEquals(1, test.getMod());

        test = new LegacyModifier(13);
        assertEquals(1, test.getMod());

        test = new LegacyModifier(14);
        assertEquals(2, test.getMod());
    }

    /**
     * Test that correct modifiers are generated as ability
     * score decreases
     */
    @Test
    public void testNegativeMod() {
        LegacyModifier test = new LegacyModifier(9);
        assertEquals(-1, test.getMod());

        test = new LegacyModifier(8);
        assertEquals(-1, test.getMod());

        test = new LegacyModifier(7);
        assertEquals(-2, test.getMod());

        test = new LegacyModifier(6);
        assertEquals(-2, test.getMod());
    }

    /**
     * Test that setAbilityScore() correctly updates the
     * ability score and modifier
     */
    @Test
    public void testSetAbilityScore() {
        LegacyModifier test = new LegacyModifier(10);

        test.setAbilityScore(16);
        assertEquals(16, test.getAbilityScore());
        assertEquals(3, test.getMod());

        test.setAbilityScore(5);
        assertEquals(5, test.getAbilityScore());
        assertEquals(-3, test.getMod());
    }
}
