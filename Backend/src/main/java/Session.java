package main.java;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class Session {

    private static Map<String, CharacterSession> sess;

    public static void main(String[] args) {

        /*
         * For testing purposes. go to http://localhost:4567/hello to see if the server
         * is running
         */
        get("/hello", (req, res) -> {
            String name = req.queryParams("name");
            return "Hello, " + (name != null ? name : "friend");
        });

        sess = new HashMap<>();
        /*
         * creates a session for a character
         */
        post("/character/create", (req, res) -> {
            CharacterSession currSession = new CharacterSession(req.session().id());
            sess.put(req.session().id(), currSession); // can change the characterSession constructor to String
            return req.session().id();
        });

        /*
         * updates the session's character sheet based on stats which will be in the
         * format of a % seperated string with STR, DEX, CON, INT, WIS, CHA, Level,
         * hitPoints,
         * gold, armor, main class, subclass
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

        get("/roll/:count/:mod/:dice", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            return currSession.rollDice(Integer.parseInt(req.params(":count")), req.params(":mod"),
                    req.params(":dice"));
        });

    }
}
