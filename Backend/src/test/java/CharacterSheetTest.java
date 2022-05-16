package test.java;

import main.java.CharClass;
import main.java.CharacterSheet;
import main.java.Item;
import main.java.Modifier;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * JUnit test suite encompassing the CharacterSheet class
 * which tests that functionalities work properly
 */
public class CharacterSheetTest {

    private CharacterSheet characterSheet;

    private final int strScore = 23;
    private final int strMod = 6;
    private final int dexScore = 13;
    private final int dexMod = 1;
    private final int conScore = 10;
    private final int conMod = 0;
    private final int intScore = 15;
    private final int intMod = 2;
    private final int wisScore = 20;
    private final int wisMod = 5;
    private final int chaScore = 19;
    private final int chaMod = 4;

    private final String name = "testName";
    private final String race = "testRace";
    private final String campaign = "testCampaign";
    private final String alignment = "testAlignment";
    private final String background = "testBackground";
    private final String mainClassName = "mainClass";
    private final String subClassName = "subClass";

    private final int hitPoints = 50;
    private final int speed = 30;
    private final int goldCount = 100;
    private final int armorClass = 15;
    private final int exp = 2000;
    private final int mainLevel = 4;
    private final int subLevel = 1;

    @Before
    public void Setup() {
        characterSheet = new CharacterSheet(strScore, dexScore, conScore, intScore, wisScore, chaScore,
                name, race, campaign, alignment, background, hitPoints, speed, goldCount, armorClass, exp,
                mainClassName, mainLevel, subClassName, subLevel);
    }

    @Test
    public void testCharacterSheet() {
        // Tons of asserts to make sure everything is properly generated and stored
        Modifier Str = characterSheet.getSTR();
        Modifier Dex = characterSheet.getDEX();
        Modifier Con = characterSheet.getCON();
        Modifier Int = characterSheet.getINT();
        Modifier Wis = characterSheet.getWIS();
        Modifier Cha = characterSheet.getCHA();
        // Assert correct ability scores are stored based on ability scores
        assertEquals(strScore, Str.getAbilityScore());
        assertEquals(dexScore, Dex.getAbilityScore());
        assertEquals(conScore, Con.getAbilityScore());
        assertEquals(intScore, Int.getAbilityScore());
        assertEquals(wisScore, Wis.getAbilityScore());
        assertEquals(chaScore, Cha.getAbilityScore());
        // Assert correct modifiers are generated
        assertEquals(strMod, Str.getMod());
        assertEquals(dexMod, Dex.getMod());
        assertEquals(conMod, Con.getMod());
        assertEquals(intMod, Int.getMod());
        assertEquals(wisMod, Wis.getMod());
        assertEquals(chaMod, Cha.getMod());
        // Assert basic information
        assertEquals(name, characterSheet.getName());
        assertEquals(race, characterSheet.getRace());
        assertEquals(campaign, characterSheet.getCampaign());
        assertEquals(alignment, characterSheet.getAlignment());
        assertEquals(background, characterSheet.getBackground());
        // Assert sheet generated numbers
        assertEquals(3, characterSheet.getProfBonus());
        assertEquals(1, characterSheet.getInitiative());
        // Assert more basic information
        assertEquals(hitPoints, characterSheet.getHp());
        assertEquals(speed, characterSheet.getSpeed());
        assertEquals(goldCount, characterSheet.getGold());
        assertEquals(armorClass, characterSheet.getAC());
        assertEquals(exp, characterSheet.getExp());
        // Assert classes
        CharClass mainClass, subClass;
        mainClass = characterSheet.getMainClass();
        subClass = characterSheet.getSubClass();
        assertEquals(mainClassName, mainClass.getClassName());
        assertEquals(mainLevel, mainClass.getLevel());
        assertEquals(subClassName, subClass.getClassName());
        assertEquals(subLevel, subClass.getLevel());
    }

    @Test
    public void testSetStr() {
        assertEquals(23, characterSheet.getSTR().getAbilityScore());
        assertEquals(6, characterSheet.getSTR().getMod());
        characterSheet.setSTR(25);
        assertEquals(25, characterSheet.getSTR().getAbilityScore());
        assertEquals(7, characterSheet.getSTR().getMod());
    }

    @Test
    public void testSetDex() {
        assertEquals(13, characterSheet.getDEX().getAbilityScore());
        assertEquals(1, characterSheet.getDEX().getMod());
        assertEquals(1, characterSheet.getInitiative());
        characterSheet.setDEX(16);
        assertEquals(16, characterSheet.getDEX().getAbilityScore());
        assertEquals(3, characterSheet.getDEX().getMod());
        assertEquals(3, characterSheet.getInitiative());
    }

    @Test
    public void testSetCon() {
        assertEquals(10, characterSheet.getCON().getAbilityScore());
        assertEquals(0, characterSheet.getCON().getMod());
        characterSheet.setCON(15);
        assertEquals(15, characterSheet.getCON().getAbilityScore());
        assertEquals(2, characterSheet.getCON().getMod());
    }

    @Test
    public void testSetInt() {
        assertEquals(15, characterSheet.getINT().getAbilityScore());
        assertEquals(2, characterSheet.getINT().getMod());
        characterSheet.setINT(16);
        assertEquals(16, characterSheet.getINT().getAbilityScore());
        assertEquals(3, characterSheet.getINT().getMod());
    }

    @Test
    public void testSetWis() {
        assertEquals(20, characterSheet.getWIS().getAbilityScore());
        assertEquals(5, characterSheet.getWIS().getMod());
        characterSheet.setWIS(8);
        assertEquals(8, characterSheet.getWIS().getAbilityScore());
        assertEquals(-1, characterSheet.getWIS().getMod());
    }

    @Test
    public void testSetCha() {
        assertEquals(19, characterSheet.getCHA().getAbilityScore());
        assertEquals(4, characterSheet.getCHA().getMod());
        characterSheet.setCHA(8);
        assertEquals(8, characterSheet.getCHA().getAbilityScore());
        assertEquals(-1, characterSheet.getCHA().getMod());
    }

    @Test
    public void testBasicSetters() {
        characterSheet.setName("newName");
        characterSheet.setRace("newRace");
        characterSheet.setCampaign("newCampaign");
        characterSheet.setAlignment("newAlignment");
        characterSheet.setBackground("newBackground");
        characterSheet.setHP(100);
        characterSheet.setSpeed(25);
        characterSheet.setAC(20);
        characterSheet.setGold(1000);
        characterSheet.setExp(30000);

        assertEquals("newName", characterSheet.getName());
        assertEquals("newRace", characterSheet.getRace());
        assertEquals("newCampaign", characterSheet.getCampaign());
        assertEquals("newAlignment", characterSheet.getAlignment());
        assertEquals("newBackground", characterSheet.getBackground());
        assertEquals(100, characterSheet.getHp());
        assertEquals(25, characterSheet.getSpeed());
        assertEquals(20, characterSheet.getAC());
        assertEquals(1000, characterSheet.getGold());
        assertEquals(30000, characterSheet.getExp());
    }

    @Test
    public void testClassSetters() {
        assertEquals(3, characterSheet.getProfBonus());
        characterSheet.setMainClassName("newMainClass");
        characterSheet.setMainClassLevel(6);
        characterSheet.setSubClassName("newSubClass");
        characterSheet.setSubClassLevel(3);

        CharClass mainClass, subClass;
        mainClass = characterSheet.getMainClass();
        subClass = characterSheet.getSubClass();
        assertEquals("newMainClass", mainClass.getClassName());
        assertEquals(6, mainClass.getLevel());
        assertEquals("newSubClass", subClass.getClassName());
        assertEquals(3, subClass.getLevel());
        // Prof bonus should auto update when levels are incremented
        assertEquals(4, characterSheet.getProfBonus());
    }

    @Test
    public void testAddItem() {
        String itemId = "testItemId";
        Item testItem = new Item("testItem", "testDescription", 1);
        characterSheet.addItem(itemId, testItem);

        HashMap<String, Item> items = characterSheet.getItems();
        assertNotNull(items);
        assertNotNull(items.get(itemId));
        Item storedItem = items.get(itemId);
        assertEquals("testItem", storedItem.getName());
        assertEquals("testDescription", storedItem.getDescription());
        assertEquals(1, storedItem.getItemCount());
    }

    @Test
    public void testAddDuplicateItem() {
        String itemId = "testItemId";
        Item testItem = new Item("testItem", "testDescription", 1);
        characterSheet.addItem(itemId, testItem);
        characterSheet.addItem(itemId, testItem);
        HashMap<String, Item> items = characterSheet.getItems();
        Item storedItem = items.get(itemId);
        assertEquals(2, storedItem.getItemCount());
    }

    @Test
    public void testDecrementItem() {
        String itemId = "testItemId";
        testAddDuplicateItem();
        characterSheet.decrementItem(itemId, 1);
        HashMap<String, Item> items = characterSheet.getItems();
        Item storedItem = items.get(itemId);
        assertEquals(1, storedItem.getItemCount());
    }

    @Test
    public void testDecrementItemToZero() {
        String itemId = "testItemId";
        testDecrementItem();
        characterSheet.decrementItem(itemId, 1);
        HashMap<String, Item> items = characterSheet.getItems();
        Item storedItem = items.get(itemId);
        assertNull(storedItem);
        assertFalse(items.containsKey(itemId));
    }

    @Test
    public void testRemoveItem() {
        String itemId = "testItemId";
        testAddDuplicateItem();
        characterSheet.removeItem(itemId);
        HashMap<String, Item> items = characterSheet.getItems();
        Item storedItem = items.get(itemId);
        assertNull(storedItem);
        assertFalse(items.containsKey(itemId));
    }

    @Test
    public void testUpdateItem() {
        String itemId = "testItemId";
        testAddDuplicateItem();
        Item updatedItem = new Item("updatedItem", "updatedDescription", 5);
        characterSheet.updateItem(itemId, updatedItem);
        HashMap<String, Item> items = characterSheet.getItems();
        Item storedItem = items.get(itemId);
        assertEquals("updatedItem", storedItem.getName());
        assertEquals("updatedDescription", storedItem.getDescription());
        assertEquals(5, storedItem.getItemCount());

    }
}
