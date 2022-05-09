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
  return (
    <Row style={statusRow}>
      <Col lg={4} style={{ textAlign: "left" }}>
        <p style={hpText}>HP:</p>
        <input style={hpInput} />
        <p style={hpText}>/</p>
        <input style={hpInput} />
      </Col>
      <Col lg={2} align="center">
        <input style={input} />
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
        <input style={input} />
        <h4>Speed</h4>
      </Col>
    </Row>
  );
};

export default CharacterStatus;
