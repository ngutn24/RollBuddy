import { React, useState, useEffect, useRef } from "react";
import { Container, Row, Col } from "react-bootstrap";
import AbilityList from "./AbilityList.js";
import CharacterInfo from "./CharacterInfo.js";
import CharacterStatus from "./CharacterStatus.js";
import RollMenu from "./RollMenu.js";
import MiscMenu from "./MiscMenu.js";
import axios from "axios";
import TabMenu from "./TabMenu.js";

export const baseURL = "http://localhost:4567";

const CharacterSheet = () => {
  // stores ID used to reference current character in *all* API calls.
  const [characterID, setCharacterID] = useState();
  const [abilities, setAbilities] = useState({
    STR: 10,
    DEX: 10,
    CON: 10,
    INT: 10,
    WIS: 10,
    CHA: 10,
  });
  const isMounted = useRef(false); // used to skip effects on initial render.

  // fetch character data from the API, will initialize a new character if not found.
  const fetchCharacter = () => {
    const characterID = JSON.parse(localStorage.getItem("characterID"));

    let id = "";
    if (characterID != null) {
      setCharacterID(characterID);
      id = "?id=" + characterID;
    }

    // TODO: cleanup url construction/definition to ensure safety.
    const url = encodeURI(baseURL + "/character" + id);

    console.log("fetching URL: ", url);

    axios
      .get(url, {
        withCredentials: true,
      })
      .then((res) => {
        console.log(res.data);

        // set character ID if this call initializes a new character
        if (characterID === null) {
          console.log("Setting the chartacterID: ", res.data.id);
          setCharacterID(res.data.id);
        }

        setAbilities({
          STR: res.data.character.STR.abilityScore,
          DEX: res.data.character.DEX.abilityScore,
          CON: res.data.character.CON.abilityScore,
          INT: res.data.character.INT.abilityScore,
          WIS: res.data.character.WIS.abilityScore,
          CHA: res.data.character.CHA.abilityScore,
        });
      });
  };

  // post abilities to API, updating backend representation of the character.
  const updateAbilities = () => {
    if (characterID == null) {
      console.log("[ERROR] No valid character ID found. Cannot update values.");
      return;
    }

    // TODO: cleanup url construction/definition to ensure safety.
    let url = encodeURI(
      baseURL +
        "/update" +
        "?id=" +
        characterID +
        "&stats=" +
        JSON.stringify(abilities)
    );

    axios
      .get(url, {
        withCredentials: true,
      })
      .then((res) => {
        console.log("[DEBUG] Updated character for session: ", res.data);
      });
  };

  // Runs once: Initialize session, save id, and request initial data.
  useEffect(() => {
    fetchCharacter();
    // eslint-disable-next-line
  }, []);

  // when any ability updates, push to backend via API.
  // TODO: there is room for optimization here. possibly batching and/or timers?
  useEffect(() => {
    if (isMounted.current) {
      console.log("[DEBUG] Abilities after mount:", abilities);
      updateAbilities();
    } else {
      isMounted.current = true;
    }
    // eslint-disable-next-line
  }, [abilities]);

  // save characterID to localstorage when state is updated.
  useEffect(() => {
    localStorage.setItem("characterID", JSON.stringify(characterID));
  }, [characterID]);

  return (
    <Container style={{ padding: "20px" }}>
      <Row>
        <CharacterInfo />
      </Row>
      <Row>
        <CharacterStatus />
      </Row>
      <Row>
        <Col sm={8}>
          <Row>
            <AbilityList abilities={abilities} setAbilities={setAbilities} />
          </Row>
          <Row className="flex-column-reverse flex-md-row">
            <Col>
              <MiscMenu />
            </Col>
            <Col>
              <RollMenu id={characterID} />
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
