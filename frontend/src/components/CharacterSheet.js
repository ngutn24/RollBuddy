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
import TabMenu from "./TabMenu.js";

export const baseURL = process.env.REACT_APP_API_URL;

const CharacterSheet = () => {
  const [charAttributes, setCharAttributes] = useState(Character); // default to uninitialize char
  const [charID, setCharID] = useState(); // default to uninitialize char

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

  // Runs once: Initialize session, save id, and request initial data.
  useEffect(() => {
    anonAuthFetch();
    // eslint-disable-next-line
  }, []);

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
        <CharacterStatus
          attributes={charAttributes}
          setAttributes={setCharAttributes}
        />
      </Row>
      <Row>
        <Col sm={8}>
          <Row>
            <AbilityList
              attributes={charAttributes}
              setAttributes={setCharAttributes}
            />
          </Row>
          <Row>
            <Col>
              <MiscMenu />
            </Col>
            <Col>
              <RollMenu id={charID} />
            </Col>
          </Row>
        </Col>
        <Col lg={4} md={12}>
          <TabMenu
            attributes={charAttributes}
            setAttributes={setCharAttributes}
          />
        </Col>
      </Row>
    </Container>
  );
};

export default CharacterSheet;
