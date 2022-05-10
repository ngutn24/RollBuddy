import { React, useState, useEffect, useRef } from "react";
import { Container, Row, Col } from "react-bootstrap";
import AbilityList from "./AbilityList.js";
import CharacterInfo from "./CharacterInfo.js";
import CharacterStatus from "./CharacterStatus.js";
import RollMenu from "./RollMenu.js";
import axios from "axios";

const CharacterSheet = () => {
  const [abilities, setAbilities] = useState({});
  const isMounted = useRef(false); // used to skip effects on initial render.

  // fetch character data from the API, will initialize a new character if not found.
  const fetchCharacter = () => {
    axios
      .get("http://localhost:4567/character", {
        withCredentials: true,
      })
      .then((res) => {
        setAbilities({
          STR: res.data.STR.abilityScore,
          DEX: res.data.DEX.abilityScore,
          CON: res.data.CON.abilityScore,
          INT: res.data.INT.abilityScore,
          WIS: res.data.WIS.abilityScore,
          CHA: res.data.CHA.abilityScore,
        });
      });
  };

  // post abilities to API, updating backend representation of the character.
  const updateAbilities = () => {
    axios
      .get(
        "http://localhost:4567/update?stats=" +
          encodeURIComponent(JSON.stringify(abilities)),
        {
          withCredentials: true,
        }
      )
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

  return (
    <Container style={{ padding: "20px" }}>
      <Row>
        <CharacterInfo />
      </Row>
      <Row>
        <CharacterStatus />
      </Row>
      <Row>
        <AbilityList abilities={abilities} setAbilities={setAbilities} />
      </Row>
      <Row className="flex-column-reverse flex-md-row">
        <Col></Col>
        <RollMenu />
      </Row>
    </Container>
  );
};

export default CharacterSheet;
