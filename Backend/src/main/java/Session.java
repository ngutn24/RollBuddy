package main.java;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class Session {

    private static Map<String, CharacterSession> sess;

    public static void main(String[] args) {
        sess = new HashMap<>();
        /*
         * creates a session for a character based on stats which will be in the
         * format of a comma seperated string with STR, DEX, CON, INT, WIS, CHA, Level,
         * hitPoints,
         * gold, armor, main class, subclass
         */
        post("/character/:stats", (req, res) -> {
            CharacterSession currSession = new CharacterSession(Integer.parseInt(req.session().id()));
            currSession.generateCharacter(req.params(":stats"));
            sess.put(req.session().id(), currSession); // can change the characterSession constructor to String
            return req.session().id();
        });

        /*
         * updates the session's character sheet using the same stats format as creating
         */
        put("/update/:stats", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            currSession.generateCharacter(req.params(":stats"));
            return req.session().id();
        });

        /*
         * returns the stats for the current session
         */
        get("/character", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            return currSession.getCharacterData();
        });

    }
}
