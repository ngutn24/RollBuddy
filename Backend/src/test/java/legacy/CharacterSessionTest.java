package test.java.legacy;

import main.java.legacy.CharacterSession;
import org.junit.*;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class CharacterSessionTest {
    private static CharacterSession session;


    @DataPoints("Session IDs")
    public static String[] ids = new String[] {"0", "1", "123", "456", "25a98721", "999999999"};

    @DataPoint("Character Session JSON")
    public static String[] expectedJsonKeys = new String[]
            {"id","character","profBonus", "items", "name", "race", "campaign", "alignment",
                    "background", "initiative", "hitPoints", "speed", "armorClass", "goldCount",
                    "exp", "mainClass", "subClass", "charClass", "level", "baseMod", "abilityScore", "mod",
                    "STR", "DEX", "CON", "INT", "WIS", "CHA"};

    @Before
    public void Setup(){
        session = new CharacterSession("12345");
    }

    @Theory
    public void TestSessionID(@FromDataPoints("Session IDs") String ID){
        System.out.println("Testing Session ID: " + ID);
        CharacterSession session = new CharacterSession(ID);
        Assert.assertEquals(ID, session.getSessionID());
        System.out.println("SESSION ID TEST PASSED");
    }

    //TODO: This test will need to be updated when generateCharacter() is fully implemented
    @Test
    public void testSessionUpdateTime(){
        System.out.println("Testing Session Update Time");
        String preTime = session.getLastUpdated();
        session.generateCharacter("{\"STR\":2,\"CHA\":0,\"DEX\":1,\"CON\":5,\"INT\":1,\"WIS\":5}");
        String postTime = session.getLastUpdated();
        Assert.assertNotEquals(postTime, preTime);
        System.out.println("SESSION UPDATE TIME TEST PASSED");
    }

    @Theory
    public void testDefaultCharacterSheetJson(@FromDataPoints("Character Session JSON") String[] keyList){
        System.out.println("Testing Default Character Sheet Json Conversion");
        String json = session.getCharacterData();
        for(String key : keyList){
            System.out.println("Checking for: " + key);
            Assert.assertTrue(json.contains(key));
        }
        System.out.println("TESTING DEFAULT CHARACTER SHEET JSON PASSED");
    }

    @Test
    public void testInvalidDiceRollInputs(){
        System.out.println("Testing Invalid Dice Inputs");

        System.out.println("Testing Invalid Dice Count");
        RuntimeException thrown =
                Assert.assertThrows("Exception from dice rolling was expected",
                RuntimeException.class,
                () -> session.rollDice(-1, "str", "d4"));

        Assert.assertEquals("Invalid Dice Count Input", thrown.getMessage());

        System.out.println("INVALID DICE COUNT TEST PASSED");

        System.out.println("Testing Invalid modifier option");

        thrown = Assert.assertThrows("Exception from dice rolling was expected",
                        RuntimeException.class,
                        () -> session.rollDice(2, "asd", "d4"));

        Assert.assertEquals("Invalid Modifier Option Inputted", thrown.getMessage());

        System.out.println("INVALID MODIFIER OPTION TEST PASSED");

        System.out.println("Testing Invalid dice type input");

        thrown = Assert.assertThrows("Exception from dice rolling was expected",
                RuntimeException.class,
                () -> session.rollDice(2, "str", "d654"));

        Assert.assertEquals("Invalid Dice Type Inputted", thrown.getMessage());

        System.out.println("INVALID DICE TYPE INPUT PASSED");

        System.out.println("INVALID DICE INPUTS PASSED");

    }

}
