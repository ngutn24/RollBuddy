package main.java;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import spark.Spark;

import java.io.FileInputStream;
import java.io.IOException;

public class RollbuddyServer {

    public static void main(String[] args) throws IOException {
        CORSFilter filter = new CORSFilter();
        filter.apply();// make this easier to use in development
        // this would be disabled in production

        // Firestore Credential file, change if local user
        FileInputStream serviceAccount = new FileInputStream("Backend/RollbuddyFirestoreCredentials.json");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        DiceRoller dice = new DiceRoller();

        /**
         * returns the roll based on the associated Character (using id), and the
         * number of dice (count), ability type (mod), and dice type (dice)
         * returns a bad roll requst if dice type or ability type are not given
         */
        Spark.get("/roll", (req, res) -> {

            String userId = req.queryParams("id");
            int count = 0;
            try{
                count = Integer.parseInt(req.queryParams("count"));
            }catch(NumberFormatException ex){
                res.status(400);
                return "Not Proper Roll Request";
            }

            String abilityType = req.queryParams("mod");
            String diceType = req.queryParams("dice");


            if (userId == null || abilityType == null || diceType == null) {
                res.status(400);
                return String.format("Not Proper Roll Request");
            }

            Dice diceTypeEnum = Dice.fromString(diceType);
            if (count < 0 || diceTypeEnum == null ){
                res.status(400);
                return "Query Values Invalid";
            }

            DocumentReference userInfo = db.collection("CharacterSheets").document(userId);

            ApiFuture<DocumentSnapshot>  futureUserDoc = userInfo.get();

            DocumentSnapshot sheetDoc = futureUserDoc.get();

            if(!sheetDoc.exists()){
                res.status(400);
                return "Character Sheet Doesn't Exist";
            }else{
                Long score = sheetDoc.getLong(abilityType);
                if (score == null){
                    res.status(400);
                    return "Invalid Ability Type";
                }

                return dice.Roll(count, AbilityModifer.generateModifier(score.intValue()), diceTypeEnum);
            }
        });
    }
}
