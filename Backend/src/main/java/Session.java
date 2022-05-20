package main.java;

import spark.Spark;

import java.util.HashMap;
import java.util.Map;

/**
 * The backend server for RollBuddy which is used with Spark Java to send information 
 * and receive information with front end and back end
 */
public class Session {

    
    /** 
     * main runs whenever a request is made to the backend server
     * @param args
     */
    public static void main(String[] args) {
        Map<String, CharacterSession> sess = new HashMap<>();

        /*
         * Allow CORS for API clients, by default this must allowed for authentication
         * cookies required for session id storage.
         */
        // Spark.afterAfter((Filter) (request, response) -> {
        // // this will need to be updated in the future, since sessions require setting
        // a cookie, we must define
        // // an origin, but we do not yet have an api endpoint.
        // response.header("Access-Control-Allow-Origin", "*");
        // response.header("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT,
        // DELETE, OPTIONS");
        // response.header("Access-Control-Allow-Headers", "Origin, Content-Type,
        // X-Auth-Token");
        // response.header("Access-Control-Allow-Credentials", "true");
        // });

        CORSFilter filter = new CORSFilter();
        filter.apply();// make this easier to use in development
        // this would be disabled in production

        /*
         * For testing purposes. go to http://localhost:4567/hello to see if the server
         * is running and should print out "Hello, friend"
         */
        Spark.get("/hello", (req, res) -> {
            String name = req.queryParams("name");
            return "Hello, " + (name != null ? name : "friend");
        });

        /** 
         * creates a CharacterSession and stores it based on a random UUID
         * @returns the new CharacterSessions character data which should be default
         */
        Spark.get("/create", (req, res) -> {
            CharacterSession currSession = new CharacterSession(req.session().id());
            sess.put(req.session().id(), currSession); // can change the characterSession constructor to String
            return req.session().id();
        });

        /**
         * updates the session's character sheet based on stats which is passed in as a query
         * param, this is done by retrieving the CharacterSession associated with the id that
         * is also passed in as a query param
         */
        Spark.get("/update", (req, res) -> {
            CharacterSession currSession = sess.get(req.session().id());
            currSession.generateCharacter(req.queryParams("stats"));
            return req.session().id();
        });

        /**
         * Returns the character data with the associated id
         * id is passed in as a query param and if that id is not stored yet, a new character 
         * session is created and stored with that id
         */
        Spark.get("/character", (req, res) -> {
            String id = req.session().id();
            CharacterSession currSession;
            if (!sess.containsKey(id)) {
                currSession = new CharacterSession(req.session().id());
                sess.put(req.session().id(), currSession);
            } else {
                currSession = sess.get(id);
            }
            return currSession.getCharacterData();
        });

        /**
         * returns the roll based on the associated Character (using id), and the
         * number of dice (count), ability type (mod), and dice type (dice)
         * returns a bad roll requst if dice type or ability type are not given
         */
        Spark.get("/roll", (req, res) -> {

            CharacterSession currSession = sess.get(req.session().id());
            int count = Integer.parseInt(req.queryParams("count"));
            String abilityType = req.queryParams("mod");
            String diceType = req.queryParams("dice");

            if (abilityType == null || diceType == null) {
                res.status(400);
                return "Bad Roll Request";
            }
            return currSession.rollDice(Integer.parseInt(req.queryParams("count")), req.queryParams("mod"),
                    req.queryParams("dice"));
        });
        // Spark.stop();
    }
}
