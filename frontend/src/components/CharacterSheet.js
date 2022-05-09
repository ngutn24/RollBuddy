import { React, useState, useEffect } from "react";
import { Container, Row } from "react-bootstrap";
import AbilityList from "./AbilityList.js";
import CharacterInfo from "./CharacterInfo.js";
import axios from "axios";

const CharacterSheet = () => {
  const [characterID, setCharacterID] = useState();

  // JS Logic
  // Runs once: get sessionID from local storage (if found), otherwise request a new session.
  useEffect(() => {
    const id = JSON.parse(localStorage.getItem("characterID"));
    if (id) {
      console.log("Loading id from storage... ", id);
      setCharacterID(id);
    } else {
      // TODO: Hardcoded URL, use github env variables in the future?
      // NOTE: withCredentials will store the session cookie for later
      axios
        .get("http://localhost:4567/create", { withCredentials: true })
        .then(async (res) => {
          const session = res.data;
          localStorage.setItem("characterID", JSON.stringify(session));
          await setCharacterID(id); // TODO may not be a best practice to mix await/async with .then
        });

      console.log("Fetched id from api...", characterID);
    }

    axios
      .get("http://localhost:4567/character", { withCredentials: true })
      .then(async (res) => {
        const data = res.data;
        await console.log(data); // TODO may not be a best practice to mix await/async with .then
      });
    // eslint-disable-next-line
  }, []); // run hook only once on mount, not on change to state. ignore this hook dependency warning.

  return (
    <Container style={{ padding: "20px" }}>
      <Row>
        <CharacterInfo />
      </Row>
      <Row>
        <AbilityList />
      </Row>
    </Container>
  );
};

export default CharacterSheet;
