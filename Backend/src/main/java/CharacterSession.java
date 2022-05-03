package main.java;
import java.time.Instant;
import com.google.gson.Gson;


public class CharacterSession {
    //TODO: Add Character Sheet object field
    public final int sessionID;
    private Instant lastUpdated;
    private final Gson jsonConverter;

    /**
     * Initializes a character session instance
     * @param sessionID the session ID tying to this particular session
     * There is no unique session ID checker, it is up to the client to ensure
     * unique IDs
     */
    public CharacterSession(final int sessionID){
        this.sessionID = sessionID;
        this.lastUpdated = Instant.now();
        this.jsonConverter = new Gson();
    }

    /**
     * Getter function for checking the session ID attached to this character session
     *
     * @return The integer session ID for this instance
     */
    public int getSessionID(){
        return sessionID;
    }

    /**
     * Getter function for checking the last time this instance was mutatated/updated
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
    public void generateCharacter(String characterData){
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
        //TODO: Do character sheet json conversion
        return "TO BE CHARACTER JSON STRING";
    }
}
