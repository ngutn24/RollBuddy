package main.java;

import spark.Spark;

import java.util.HashMap;
import java.util.Map;

public class Session {

    public static void main(String[] args) {
        Map<String, CharacterSession> sess = new HashMap<>();
        
        /*
         * Allow CORS for API clients, by default this must allowed for authentication cookies required for session id storage.
         */
        Spark.after((Filter) (request, response) -> {
            // this will need to be updated in the future, since sessions require setting a cookie, we must define
            // an origin, but we do not yet have an api endpoint.
            response.header("Access-Control-Allow-Origin", "http://localhost:3000");
            response.header("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
            response.header("Access-Control-Allow-Credentials", "true");
        });

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
        Spark.get("/update/:stats", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            currSession.generateCharacter(req.params(":stats"));
            return req.session().id();
        });

        /*
         * returns the stats for the current session
         */
        Spark.get("/character", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            return currSession.getCharacterData();
        });

        Spark.get("/roll/:count/:mod/:dice", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            return currSession.rollDice(Integer.parseInt(req.params(":count")), req.params(":mod"),
                    req.params(":dice"));
        });
        //Spark.stop();
    }
}
