import { useState, useEffect } from "react";
import { Container, Row, Col } from "react-bootstrap";
import AbilityList from "./AbilityList.js";
import { Character } from "../character.js";
import { auth, db } from "../firestore.js";
import {
  doc,
  getDoc,
  setDoc,
  addDoc,
  updateDoc,
  collection,
} from "firebase/firestore";
import { signInAnonymously } from "firebase/auth";
import CharacterInfo from "./CharacterInfo.js";
import CharacterStatus from "./CharacterStatus.js";
import RollMenu from "./RollMenu.js";
import MiscMenu from "./MiscMenu.js";
// import axios from "axios";
import TabMenu from "./TabMenu.js";

export const baseURL = process.env.REACT_APP_API_URL;

const CharacterSheet = () => {
  // stores ID used to reference current character in *all* API calls.
  // const [characterID, setCharacterID] = useState();
  const [charAttributes, setCharAttributes] = useState(Character); // default to uninitialize char
  const [charID, setCharID] = useState(); // default to uninitialize char
  // const [abilities, setAbilities] = useState({
  //   STR: 10,
  //   DEX: 10,
  //   CON: 10,
  //   INT: 10,
  //   WIS: 10,
  //   CHA: 10,
  // });
  // const isMounted = useRef(false); // used to skip effects on initial render.

  // // fetch character data from the API, will initialize a new character if not found.
  // const fetchCharacter = () => {
  //   const characterID = JSON.parse(localStorage.getItem("characterID"));

  //   let id = "";
  //   if (characterID != null) {
  //     setCharacterID(characterID);
  //     id = "?id=" + characterID;
  //   }

  //   // TODO: cleanup url construction/definition to ensure safety.
  //   const url = encodeURI(baseURL + "/character" + id);

  //   console.log("fetching URL: ", url);

  //   axios
  //     .get(url, {
  //       withCredentials: true,
  //     })
  //     .then((res) => {
  //       console.log(res.data);

  //       // set character ID if this call initializes a new character
  //       if (characterID === null) {
  //         console.log("Setting the chartacterID: ", res.data.id);
  //         setCharacterID(res.data.id);
  //       }

  //       setAbilities({
  //         STR: res.data.character.STR.abilityScore,
  //         DEX: res.data.character.DEX.abilityScore,
  //         CON: res.data.character.CON.abilityScore,
  //         INT: res.data.character.INT.abilityScore,
  //         WIS: res.data.character.WIS.abilityScore,
  //         CHA: res.data.character.CHA.abilityScore,
  //       });
  //     });
  // };

  const anonAuthFetch = async () => {
    try {
      // authenticate the user anonymously
      await signInAnonymously(auth);
      const id = auth.currentUser.uid;
      console.log("[DEBUG] Successfully Authenticated.", id);
      // use auth id to access corresponding document in the "user" collection
      const userDoc = await getDoc(doc(db, "users", id));
      let charRef = doc(db, "characterSheets", "0"); // this ref is invalid
      // attempt to read characterSheet reference from user doc.
      if (userDoc.exists()) {
        console.log(userDoc.data());
        let data = userDoc.data();
        charRef = data.sheets[0]; // valid ref
        setCharID(charRef.id);
      } else {
        // handle case where this is a user's first login and initialize user doc.
        await setDoc(doc(db, "users", auth.currentUser.uid), { sheets: [] });
      }
      // attemps to read charachterSheet doc
      // TODO: subscribe to this doc for realtime updates (only makes sense with email/google auth)
      let charDoc = await getDoc(charRef);
      // update state if a valid character doc is found
      if (charDoc.exists()) {
        setCharAttributes(charDoc.data());
      } else {
        // c
        let charRef = await addDoc(
          collection(db, "characterSheets"),
          charAttributes
        );
        setCharID(charRef.id);
        await updateDoc(doc(db, "users", auth.currentUser.uid), {
          sheets: [charRef],
        });
      }
      console.log(
        "[DEBUG] Character Attributes from firestore:",
        charDoc.data()
      );
    } catch (e) {
      const errorCode = e.code;
      const errorMessage = e.message;
      console.log(
        "[ERROR] Failed to authenticate and initialize character.",
        errorCode,
        errorMessage
      );
    }
  };

  // // post abilities to API, updating backend representation of the character.
  // const updateAbilities = () => {
  //   if (characterID == null) {
  //     console.log("[ERROR] No valid character ID found. Cannot update values.");
  //     return;
  //   }

  //   // TODO: cleanup url construction/definition to ensure safety.
  //   let url = encodeURI(
  //     baseURL +
  //       "/update" +
  //       "?id=" +
  //       characterID +
  //       "&stats=" +
  //       JSON.stringify(abilities)
  //   );

  //   axios
  //     .get(url, {
  //       withCredentials: true,
  //     })
  //     .then((res) => {
  //       console.log("[DEBUG] Updated character for session: ", res.data);
  //     });
  // };

  // Runs once: Initialize session, save id, and request initial data.
  useEffect(() => {
    // signInAnonymously(auth)
    //   .then(() => {
    //     const id = auth.currentUser.uid;
    //     console.log("[DEBUG] Successfully Authenticated.", id);
    //     setUserID(id);
    //     return getDoc(doc(db, "users", id));
    //   })
    //   .then(async (userDoc) => {
    //     let charRef = doc(db, "characterSheets", "0");
    //     if (userDoc.exists()) {
    //       // const id = doc.snap
    //       // setCharacterID()
    //       console.log(userDoc.data());
    //       let data = userDoc.data();
    //       charRef = data.sheets[0];
    //     } else {
    //       await setDoc(doc(db, "users", auth.currentUser.uid), { sheets: [] });
    //     }
    //     return getDoc(charRef);
    //   })
    //   .then(async (charDoc) => {
    //     if (charDoc.exists()) {
    //       setCharAttributes(charDoc.data());
    //     } else {
    //       let charId = await addDoc(
    //         collection(db, "characterSheets"),
    //         charAttributes
    //       );
    //       await updateDoc(doc(db, "users", auth.currentUser.uid), {
    //         sheets: [charId],
    //       });
    //     }
    //     console.log(
    //       "[DEBUG] Character Attributes from firestore:",
    //       charAttributes
    //     );
    //   })
    //   .catch((error) => {
    //     const errorCode = error.code;
    //     const errorMessage = error.message;
    //     console.log("[ERROR] Failed to authenticate.", errorCode, errorMessage);
    //   });
    anonAuthFetch();
    // fetchCharacter();
    //console.log("[DEBUG] character imported or something... ", Character);
    // eslint-disable-next-line
  }, []);

  // // when any ability updates, push to backend via API.
  // // TODO: there is room for optimization here. possibly batching and/or timers?
  // useEffect(() => {
  //   if (isMounted.current) {
  //     console.log("[DEBUG] Abilities after mount:", abilities);
  //     updateAbilities();
  //   } else {
  //     isMounted.current = true;
  //   }
  //   // eslint-disable-next-line
  // }, [abilities]);

  // save characterID to localstorage when state is updated.
  // useEffect(() => {
  //   localStorage.setItem("characterID", JSON.stringify(characterID));
  // }, [characterID]);

  //save characterID to localstorage when state is updated.
  useEffect(() => {
    if (auth.currentUser && charID !== null) {
      console.log("Updated char sheet", charID, charAttributes);
      setDoc(doc(db, "characterSheets", charID), charAttributes);
    } else {
      console.log("Not yet authenticated");
    }
    // eslint-disable-next-line
  }, [charAttributes]);

  return (
    <Container style={{ padding: "20px" }}>
      <Row>
        <CharacterInfo
          attributes={charAttributes}
          setAttributes={setCharAttributes}
        />
      </Row>
      <Row>
        <CharacterStatus />
      </Row>
      <Row>
        <Col sm={8}>
          <Row>
            <AbilityList
              attributes={charAttributes}
              setAttributes={setCharAttributes}
            />
          </Row>
          <Row className="flex-column-reverse flex-md-row">
            <Col>
              <MiscMenu />
            </Col>
            <Col>
              <RollMenu id={charID} />
            </Col>
          </Row>
        </Col>
        <Col sm={4}>
          <TabMenu />
        </Col>
      </Row>
    </Container>
  );
};

export default CharacterSheet;
