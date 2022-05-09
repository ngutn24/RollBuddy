import { React, useEffect } from "react";
import { Container, Row, Col } from "react-bootstrap";
import AbilityList from "./AbilityList.js";
import CharacterInfo from "./CharacterInfo.js";
import CharacterStatus from "./CharacterStatus.js";
import RollMenu from "./RollMenu.js";
import axios from "axios";

const CharacterSheet = () => {
  //const [characterID, setCharacterID] = useState();

  // JS Logic
  // Runs once: Initialize session, save id, and request initial data.
  useEffect(() => {
    axios
      .get("http://localhost:4567/character", {
        withCredentials: true,
      })
      .then((res) => {
        console.log("Character data", res.data);
        return axios.get(
          "http://localhost:4567/update?stats=" +
            encodeURIComponent(
              JSON.stringify({
                CHA: 20,
                CON: 20,
                DEX: 20,
                INT: 20,
                STR: 20,
                WIS: 20,
              })
            ),
          {
            withCredentials: true,
            headers: { crossDomain: true },
          }
        );
      })
      .then((res) => {
        return axios.get("http://localhost:4567/character", {
          withCredentials: true,
        });
      })
      .then((res) => {
        console.log("Character data", res.data);
      });
    // eslint-disable-next-line
  }, []); // run hook only once on mount, not on change to state. ignore this hook dependency warning.

  return (
    <Container style={{ padding: "20px" }}>
      <Row>
        <CharacterInfo />
      </Row>
      <Row>
        <CharacterStatus />
      </Row>
      <Row>
        <Col></Col>
        <AbilityList />
      </Row>
      <Row>
        <Col></Col>
        <RollMenu />
      </Row>
    </Container>
  );
};

export default CharacterSheet;
