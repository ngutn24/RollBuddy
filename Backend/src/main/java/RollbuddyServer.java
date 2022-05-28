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
import java.util.ArrayList;
import java.util.List;

public class RollbuddyServer {

    public static void main(String[] args) throws IOException {
        CORSFilter filter = new CORSFilter();
        filter.apply();// make this easier to use in development
        // this would be disabled in production

        // TODO: NEEDS TO BE CHANGE TO ACCESS ENV VARIABLES BEFORE PRODUCTION
        FileInputStream serviceAccount = new FileInputStream("/Users/esauabraham/Downloads/rollbuddy-21bea-firebase-adminsdk-tssj9-c8d5b562d2.json");
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
            int characterSheetIdx = 0;
            int count = 0;
            try{
                characterSheetIdx = Integer.parseInt(req.queryParams("charactersheet"));
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

            DocumentReference userInfo = db.collection("Users").document(userId);

            ApiFuture<DocumentSnapshot>  futureUserDoc = userInfo.get();

            DocumentSnapshot userDoc = futureUserDoc.get();

            if(!userDoc.exists()){
                res.status(400);
                return "User Doesn't Exist";
            }else{
                @SuppressWarnings("unchecked")
                ArrayList<DocumentReference> characterSheets = ((ArrayList<DocumentReference>) userDoc.get("CharacterSheets"));

                if(characterSheetIdx < 0 || characterSheetIdx > characterSheets.size() - 1){
                    res.status(400);
                    return "Invalid Character Sheet Index";
                }

                ApiFuture<DocumentSnapshot> futureSheet = characterSheets.get(characterSheetIdx).get();
                DocumentSnapshot sheet = futureSheet.get();

                Long score = sheet.getLong(abilityType);
                if (score == null){
                    res.status(400);
                    return "Invalid Ability Type";
                }

                return dice.Roll(count, AbilityModifer.generateModifier(score.intValue()), diceTypeEnum);
            }
        });
    }
}
