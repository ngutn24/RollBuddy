import { React, useEffect } from "react";
import { Container, Row, Col } from "react-bootstrap";
import AbilityList from "./AbilityList.js";
import CharacterInfo from "./CharacterInfo.js";
import RollMenu from "./RollMenu.js";

const CharacterSheet = () => {
  //const [characterID, setCharacterID] = useState("");

  // JS Logic
  // Runs once: get todos from local storage upon app launch, otherwise
  // initialize empty list.
  useEffect(() => {
    const id = JSON.parse(localStorage.getItem("characterID"));
    if (id) {
      console.log("Loading id from storage... ", id);
      // setCharacterID(id);
    } else {
      localStorage.setItem("characterID", JSON.stringify(id));
    }
  }, []);

  // //Save todos to local storage
  // useEffect(() => {

  //   localStorage.setItem("todos", JSON.stringify(todos));
  // }, [setTodo]);

  return (
    <Container style={{ padding: "20px" }}>
      <Row>
        <CharacterInfo />
      </Row>
      <Row>
        <Col>

        </Col>
        <AbilityList />
      </Row>
      <Row>
        <Col>
        
        </Col>
        <RollMenu />
      </Row>
    </Container>
  );
};

export default CharacterSheet;
