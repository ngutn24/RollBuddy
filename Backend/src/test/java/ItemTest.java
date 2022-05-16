package test.java;

import main.java.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * JUnit test suite to verify that an item object functions properly
 */
public class ItemTest {

    /**
     * Test when an item with an empty name is created
     */
    @Test
    public void testEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Item("", "test", 1)
        );

        String expectMsg = "Name field cannot be empty";
        assertEquals(expectMsg, exception.getMessage());
    }

    /**
     * Test when an item with an empty description is created
     */
    @Test
    public void testEmptyDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Item("test", "", 1)
        );

        String expectMsg = "Description field cannot be empty";
        assertEquals(expectMsg, exception.getMessage());
    }

    /**
     * Test when an item with an item count lower than 1 is created
     */
    @Test
    public void testZeroItemCount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Item("test", "test", 0)
        );

        String expectMsg = "Item count field must be > 0";
        assertEquals(expectMsg, exception.getMessage());
    }

    /**
     * Test when a proper item is created
     */
    @Test
    public void testItem() {
        Item test = new Item("testName", "testDescription", 1);
        assertEquals("testName", test.getName());
        assertEquals("testDescription", test.getDescription());
        assertEquals(1, test.getItemCount());
    }

    /**
     * Test that setting an item field updates field
     */
    @Test
    public void testSetters() {
        Item test = new Item("testName", "testDescription", 1);
        test.setName("newName");
        test.setDescription("newDescription");
        test.setItemCount(2);

        assertEquals("newName", test.getName());
        assertEquals("newDescription", test.getDescription());
        assertEquals(2, test.getItemCount());

    }
}
