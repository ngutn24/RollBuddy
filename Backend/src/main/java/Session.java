package main.java;

import spark.Spark;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Session {

    public static void main(String[] args) {
        Map<String, CharacterSession> sess = new HashMap<>();
        
        /*
         * Allow CORS for API clients, by default this must allowed for authentication cookies required for session id storage.
         */
//        Spark.afterAfter((Filter) (request, response) -> {
//            // this will need to be updated in the future, since sessions require setting a cookie, we must define
//            // an origin, but we do not yet have an api endpoint.
//            response.header("Access-Control-Allow-Origin", "*");
//            response.header("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
//            response.header("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
//            response.header("Access-Control-Allow-Credentials", "true");
//        });

        CORSFilter filter = new CORSFilter();
        filter.apply();// make this easier to use in development
        // this would be disabled in production

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
            String id = UUID.randomUUID().toString();
            CharacterSession currSession = new CharacterSession(id);
            sess.put(id, currSession); // can change the characterSession constructor to String
            return currSession.getCharacterData();
        });

        /*
         * updates the session's character sheet based on stats which will be in the
         * format of a % seperated string with STR, DEX, CON, INT, WIS, CHA, Level,
         * hitPoints,
         * gold, armor, main class, subclass
         */
        Spark.get("/update", (req, res) -> {
            String id = req.queryParams("id");
            CharacterSession currSession = sess.get(id);
            String stats = req.queryParams("stats");

            currSession.generateCharacter(stats);
            return "Update Complete";
        });

        /*
         * returns the stats for the current session. if there is not an active session,
         * create one.
         */
        Spark.get("/character", (req, res) -> {
            String id = req.queryParams("id");
            CharacterSession currSession;
            if (!sess.containsKey(id)) {
                String newId = UUID.randomUUID().toString();
                currSession = new CharacterSession(newId);
                sess.put(newId, currSession);
            } else {
                currSession = sess.get(id);
            }
            return currSession.getCharacterData();
        });

        Spark.get("/roll", (req, res) -> {

            String id = req.queryParams("id");
            CharacterSession currSession = sess.get(id);
            int count = Integer.parseInt(req.queryParams("count"));
            String abilityType = req.queryParams("mod");
            String diceType = req.queryParams("dice");

            if (abilityType == null || diceType == null){
                res.status(400);
                return "Bad Roll Request";
            }
            return currSession.rollDice(count, abilityType,
                    diceType);
        });
        //Spark.stop();
    }
}
