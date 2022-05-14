package test.java;

import main.java.Dice;
import main.java.DiceRoller;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceRollerTest {
    /**
     * JUnit test class verifying outputs for DiceRoller class
     */
    public DiceRoller dice = new DiceRoller();

    /**
     * Tests the 1 case when the input is invalid
     */
    @Test
    public void testInvalidInputs() {
        try {
            dice.Roll(-1, 0, Dice.D4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertEquals("You must roll at least 1 dice. Received input: -1", e.getMessage());
        }
    }

    /**
     * Assert that the output range for D4 is correct
     */
    @Test
    public void testD4Rolls() {

        int output;
        int i;
        // Roll a single dice 100 times.
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(1, 0, Dice.D4);
            assertTrue(output <= 4 && output >= 1);
            // +1 mod
            output = dice.Roll(1, 1, Dice.D4);
            assertTrue(output <= 5 && output >= 2);
            // -1 mod
            output = dice.Roll(1, -1, Dice.D4);
            assertTrue(output <= 3 && output >= 0);
        }

        // Roll multiple (3) dice a 100 times
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(3, 0, Dice.D4);
            assertTrue(output <= 12 && output >= 3);
            // +1 mod
            output = dice.Roll(3, 1, Dice.D4);
            assertTrue(output <= 13 && output >= 4);
            // -1 mod
            output = dice.Roll(3, -1, Dice.D4);
            assertTrue(output <= 11 && output >= 2);
        }
    }

    /**
     * Assert that the output range for D6 is correct
     */
    @Test
    public void testD6Rolls() {

        int output;
        int i;
        // Roll a single dice 100 times.
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(1, 0, Dice.D6);
            assertTrue(output <= 6 && output >= 1);
            // +1 mod
            output = dice.Roll(1, 1, Dice.D6);
            assertTrue(output <= 7 && output >= 2);
            // -1 mod
            output = dice.Roll(1, -1, Dice.D6);
            assertTrue(output <= 5 && output >= 0);
        }

        // Roll multiple (3) dice a 100 times
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(3, 0, Dice.D6);
            assertTrue(output <= 18 && output >= 3);
            // +1 mod
            output = dice.Roll(3, 1, Dice.D6);
            assertTrue(output <= 19 && output >= 4);
            // -1 mod
            output = dice.Roll(3, -1, Dice.D6);
            assertTrue(output <= 17 && output >= 2);
        }
    }

    /**
     * Assert that the output range for D8 is correct
     */
    @Test
    public void testD8Rolls() {

        int output;
        int i;
        // Roll a single dice 100 times.
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(1, 0, Dice.D8);
            assertTrue(output <= 8 && output >= 1);
            // +1 mod
            output = dice.Roll(1, 1, Dice.D8);
            assertTrue(output <= 9 && output >= 2);
            // -1 mod
            output = dice.Roll(1, -1, Dice.D8);
            assertTrue(output <= 7 && output >= 0);
        }

        // Roll multiple (3) dice a 100 times
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(3, 0, Dice.D8);
            assertTrue(output <= 24 && output >= 3);
            // +1 mod
            output = dice.Roll(3, 1, Dice.D8);
            assertTrue(output <= 25 && output >= 4);
            // -1 mod
            output = dice.Roll(3, -1, Dice.D8);
            assertTrue(output <= 23 && output >= 2);
        }
    }

    /**
     * Assert that the output range for D10 is correct
     */
    @Test
    public void testD10Rolls() {

        int output;
        int i;
        // Roll a single dice 100 times.
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(1, 0, Dice.D10);
            assertTrue(output <= 10 && output >= 1);
            // +1 mod
            output = dice.Roll(1, 1, Dice.D10);
            assertTrue(output <= 11 && output >= 2);
            // -1 mod
            output = dice.Roll(1, -1, Dice.D10);
            assertTrue(output <= 9 && output >= 0);
        }

        // Roll multiple (3) dice a 100 times
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(3, 0, Dice.D10);
            assertTrue(output <= 30 && output >= 3);
            // +1 mod
            output = dice.Roll(3, 1, Dice.D10);
            assertTrue(output <= 31 && output >= 4);
            // -1 mod
            output = dice.Roll(3, -1, Dice.D10);
            assertTrue(output <= 29 && output >= 2);
        }
    }

    /**
     * Assert that the output range for D12 is correct
     */
    @Test
    public void testD12Rolls() {

        int output;
        int i;
        // Roll a single dice 100 times.
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(1, 0, Dice.D12);
            assertTrue(output <= 12 && output >= 1);
            // +1 mod
            output = dice.Roll(1, 1, Dice.D12);
            assertTrue(output <= 13 && output >= 2);
            // -1 mod
            output = dice.Roll(1, -1, Dice.D12);
            assertTrue(output <= 11 && output >= 0);
        }

        // Roll multiple (3) dice a 100 times
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(3, 0, Dice.D12);
            assertTrue(output <= 36 && output >= 3);
            // +1 mod
            output = dice.Roll(3, 1, Dice.D12);
            assertTrue(output <= 37 && output >= 4);
            // -1 mod
            output = dice.Roll(3, -1, Dice.D12);
            assertTrue(output <= 35 && output >= 2);
        }
    }

    /**
     * Assert that the output range for D20 is correct
     */
    @Test
    public void testD20Rolls() {

        int output;
        int i;
        // Roll a single dice 100 times.
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(1, 0, Dice.D20);
            assertTrue(output <= 20 && output >= 1);
            // +1 mod
            output = dice.Roll(1, 1, Dice.D20);
            assertTrue(output <= 21 && output >= 2);
            // -1 mod
            output = dice.Roll(1, -1, Dice.D20);
            assertTrue(output <= 19 && output >= 0);
        }

        // Roll multiple (3) dice a 100 times
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(3, 0, Dice.D20);
            assertTrue(output <= 60 && output >= 3);
            // +1 mod
            output = dice.Roll(3, 1, Dice.D20);
            assertTrue(output <= 61 && output >= 4);
            // -1 mod
            output = dice.Roll(3, -1, Dice.D20);
            assertTrue(output <= 59 && output >= 2);
        }
    }

    /**
     * Assert that the output range for D100 is correct
     */
    @Test
    public void testD100Rolls() {

        int output;
        int i;
        // Roll a single dice 100 times.
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(1, 0, Dice.D20);
            assertTrue(output <= 100 && output >= 1);
            // +1 mod
            output = dice.Roll(1, 1, Dice.D20);
            assertTrue(output <= 101 && output >= 2);
            // -1 mod
            output = dice.Roll(1, -1, Dice.D20);
            assertTrue(output <= 99 && output >= 0);
        }

        // Roll multiple (3) dice a 100 times
        for (i = 0; i < 100; i++) {
            // No mod
            output = dice.Roll(3, 0, Dice.D20);
            assertTrue(output <= 300 && output >= 3);
            // +1 mod
            output = dice.Roll(3, 1, Dice.D20);
            assertTrue(output <= 301 && output >= 4);
            // -1 mod
            output = dice.Roll(3, -1, Dice.D20);
            assertTrue(output <= 299 && output >= 2);
        }
    }
}
