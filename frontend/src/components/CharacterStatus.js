import { useState, useEffect } from "react";
import { Row, Col } from "react-bootstrap";

var statusRow = {
  width: "100%",
  // height: "8rem",
  outline: "black solid 2px",
  borderRadius: "20px",
  backgroundColor: "white",
  margin: "1rem 0.5rem 1rem 0.5rem",
  padding: "1rem 1rem 1rem 1rem",
};

var input = {
  width: "4rem",
  height: "4rem",
  margin: "0rem 0.5rem 0rem 0.5rem",
  fontSize: "2rem",
  textAlign: "center",
};

var hpInput = {
  width: "6rem",
  height: "6rem",
  margin: "0rem 0.5rem 0rem 0.5rem",
  fontSize: "3rem",
  textAlign: "center",
};

var hpText = {
  fontWeight: "400",
  fontSize: "3rem",
  display: "inline",
};

const CharacterStatus = () => {
  const [currentHP, setCurrentHP] = useState("");
  const [maxHP, setMaxHP] = useState("");
  const [armorClass, setArmorClass] = useState("");
  const [speed, setSpeed] = useState("");

  useEffect(() => {
    const localCharStatus = JSON.parse(localStorage.getItem("charStatus"));
    if (localCharStatus) {
      console.log("Loading charStatus from storage... ", localCharStatus);
      setCurrentHP(localCharStatus.currentHP);
      setMaxHP(localCharStatus.maxHP);
      setArmorClass(localCharStatus.armorClass);
      setSpeed(localCharStatus.speed);
    }
  }, []);

  useEffect(() => {
    const charStatus = {
      currentHP: currentHP,
      maxHP: maxHP,
      armorClass: armorClass,
      speed: speed,
    };
    localStorage.setItem("charStatus", JSON.stringify(charStatus));
  }, [currentHP, maxHP, armorClass, speed]);

  const updateStateHandler = (setState) => (e) => {
    setState(e.target.value);
  };

  return (
    <Row style={statusRow}>
      <Col lg={4} style={{textAlign: "left"}}>
        <p style={hpText}>HP:</p>
        <input style={hpInput} value={currentHP} onChange={updateStateHandler(setCurrentHP)} />
        <p style={hpText}>/</p>
        <input style={hpInput} value={maxHP} onChange={updateStateHandler(setMaxHP)} />
      </Col>
      <Col lg={2} align="center">
        <input style={input} value={armorClass} onChange={updateStateHandler(setArmorClass)} />
        <h4>Armor Class</h4>
      </Col>
      <Col lg={2} align="center">
        <h4>+2</h4> {/* Proficiency bonus is calculated based on your level */}
        <h4>Profiency Bonus</h4>
      </Col>
      <Col lg={2} align="center">
        <h4>+2</h4> {/* Initiative is the same as your DEX modifier */}
        <h4>Initiative</h4>
      </Col>
      <Col lg={2} align="center">
        <input style={input} value={speed} onChange={updateStateHandler(setSpeed)} />
        <h4>Speed</h4>
      </Col>
    </Row>
  );
};

export default CharacterStatus;
