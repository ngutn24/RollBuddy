package test.java.legacy;

import main.java.legacy.CharClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test suite to make sure CharClass functions properly
 */
public class CharClassTest {

    @Test
    public void testCharClass() {
        CharClass testClass = new CharClass("Barbarian", 5);
        assertEquals("Barbarian", testClass.getClassName());
        assertEquals(5, testClass.getLevel());
    }

    @Test
    public void testEmptyOrNull() {
        CharClass testClass = new CharClass("", 5);
        assertEquals("Undecided", testClass.getClassName());
        assertEquals(0, testClass.getLevel());

        testClass = new CharClass(null, 5);
        assertEquals("Undecided", testClass.getClassName());
        assertEquals(0, testClass.getLevel());
    }

    @Test
    public void testCharClassSetters() {
        CharClass testClass = new CharClass("Barbarian", 5);
        testClass.setClassName("Wizard");
        testClass.setLevel(10);

        assertEquals("Wizard", testClass.getClassName());
        assertEquals(10, testClass.getLevel());
    }
}
