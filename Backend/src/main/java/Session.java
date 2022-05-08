package main.java;

import spark.Spark;

import java.util.HashMap;
import java.util.Map;

public class Session {

    public static void main(String[] args) {
        
        Map<String, CharacterSession> sess = new HashMap<>();
        /*
         * For testing purposes. go to http://localhost:4567/hello to see if the server
         * is running
         */
        Spark.get("/hello", (req, res) -> {
            String name = req.queryParams("name");
            return "Hello, " + (name != null ? name : "friend");
        });

        /*
         * creates a session for a character
         */
        Spark.get("/create", (req, res) -> {
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
        Spark.get("/update", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            currSession.generateCharacter(req.queryParams("stats"));
            return req.session().id();
        });

        /*
         * returns the stats for the current session
         */
        Spark.get("/character", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            return currSession.getCharacterData();
        });

        Spark.get("/roll", (req, res) -> {

            CharacterSession currSession = sess.get(req.session().id());
            int count = Integer.parseInt(req.queryParams("count"));
            String abilityType = req.queryParams("mod");
            String diceType = req.queryParams("dice");

            if (abilityType == null || diceType == null){
                res.status(400);
                return "Bad Roll Request";
            }
            return currSession.rollDice(Integer.parseInt(req.queryParams("count")), req.queryParams("mod"),
                    req.queryParams("dice"));
        });
        //Spark.stop();
    }
}
