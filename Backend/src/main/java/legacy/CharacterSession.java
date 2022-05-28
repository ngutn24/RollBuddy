package main.java.legacy;
import java.time.Instant;
import java.util.Map;

import com.google.gson.Gson;
import main.java.Dice;
import main.java.DiceRoller;

/**
 * An object that represents a user's individual session with the Rollbuddy service.
 * This holds character sheet information and other important metadata related to the user's experience
 */
public class CharacterSession {
    public final String sessionID;
    private Instant lastUpdated;
    private final Gson jsonConverter;
    private CharacterSheet characterSheet;
    private DiceRoller diceRoller;

    /**
     * Initializes a character session instance
     * @param sessionID the session ID tying to this particular session
     * There is no unique session ID checker, it is up to the client to ensure
     * unique IDs
     */
    public CharacterSession(final String sessionID){
        this.sessionID = sessionID;
        this.lastUpdated = Instant.now();
        this.jsonConverter = new Gson();
        this.characterSheet = new CharacterSheet();
        this.diceRoller = new DiceRoller();
    }

    /**
     * Get function for checking the session ID attached to this character session
     *
     * @return The string session ID for this instance
     */
    public String getSessionID(){
        return sessionID;
    }

    /**
     * Get function for checking the last time this instance was mutated/updated
     *
     * @return A string representation of the time this instance was last updated
     */
    public String getLastUpdated(){
        return lastUpdated.toString();
    }

    /**
     * This will update the stored character sheet data based on passed in information
     *
     * @param characterData a json representation of the core ability scores
     */
    public void generateCharacter(final String characterData){
        // Extract Data from characterData
        // Pass the changes from characterSheet class
        Map args = jsonConverter.fromJson(characterData, Map.class);

        // TODO: Write a better way to update character stats
        characterSheet.setSTR(((Double)args.get("STR")).intValue());
        characterSheet.setCHA(((Double)args.get("CHA")).intValue());
        characterSheet.setDEX(((Double)args.get("DEX")).intValue());
        characterSheet.setCON(((Double)args.get("CON")).intValue());
        characterSheet.setINT(((Double)args.get("INT")).intValue());
        characterSheet.setWIS(((Double)args.get("WIS")).intValue());

        lastUpdated = Instant.now();
    }

    /**
     * Will generate a json representation of the currently stored character sheet
     *
     * @return The string json generated, representing the stored character sheet
     */
    public String getCharacterData(){
        return String.format("{\"id\":\"%s\",\"character\":%s}",
                sessionID, jsonConverter.toJson(characterSheet));
    }

    /**
     * Will roll dice based on parameters passed in and return the result
     *
     * @param count The amount of die requested to use
     * @param modifierOption Which character sheet modifier to use
     * @param queriedType What kind die to use (ex: d10, d20)
     * @return The result of running (count) (queriedType) die
     * @throws RuntimeException if any input is invalid
     */
    public int rollDice(final int count, final String modifierOption, final String queriedType){

        if(count < 0){
            throw new RuntimeException("Invalid Dice Count Input");
        }

        Dice diceType = Dice.fromString(queriedType);

        if(diceType == null){
            throw new RuntimeException("Invalid Dice Type Inputted");
        }

        LegacyModifier curLegacyModifier;
        switch (modifierOption.toLowerCase()){
            case "str":
                curLegacyModifier = characterSheet.getSTR();
                break;
            case "dex":
                curLegacyModifier = characterSheet.getDEX();
                break;
            case "int":
                curLegacyModifier = characterSheet.getINT();
                break;
            case "cha":
                curLegacyModifier = characterSheet.getCHA();
                break;
            case "con":
                curLegacyModifier = characterSheet.getCON();
                break;
            case "wis":
                curLegacyModifier = characterSheet.getWIS();
                break;
            default:
                throw new RuntimeException("Invalid Modifier Option Inputted");
        }

        return diceRoller.Roll(count, curLegacyModifier.getMod(), diceType);
    }
}
