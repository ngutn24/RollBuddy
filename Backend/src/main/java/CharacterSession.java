package main.java;
import java.time.Instant;
import com.google.gson.Gson;

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
        // TODO: Actually implement generating character
        // Extract Data from characterData
        // Pass the changes from characterSheet class
        lastUpdated = Instant.now();
    }

    /**
     * Will generate a json representation of the currently stored character sheet
     *
     * @return The string json generated, representing the stored character sheet
     */
    public String getCharacterData(){
        return jsonConverter.toJson(characterSheet);
    }

    /**
     * Will roll dice based on parameters passed in and return the result
     *
     * @param count The amount of die requested to use
     * @param modifierOption Which character sheet modifier to use
     * @param queriedType What kinf die to use (ex: d10, d20)
     * @return The result of running (count) (queriedType) die
     */
    public int rollDice(final int count, final String modifierOption, final String queriedType){

        if(count < 0){
            throw new RuntimeException("Invalid Dice Count Input");
        }

        Dice diceType = Dice.fromString(queriedType);

        if(diceType == null){
            throw new RuntimeException("Invalid Dice Type Inputted");
        }

        Modifier curModifier;
        switch (modifierOption){
            case "str":
                curModifier = characterSheet.getSTR();
                break;
            case "dex":
                curModifier = characterSheet.getDEX();
                break;
            case "int":
                curModifier = characterSheet.getINT();
                break;
            case "cha":
                curModifier = characterSheet.getCHA();
                break;
            case "con":
                curModifier = characterSheet.getCON();
                break;
            default:
                throw new RuntimeException("Invalid Modifier Option Inputted");
        }

        return diceRoller.Roll(count, curModifier.getMod(), diceType);
    }
}
