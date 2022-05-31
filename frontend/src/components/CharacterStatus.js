import { Row, Col } from "react-bootstrap";
import { calculateMod } from "./Helpers";
import border from "../assets/window_bg.png";

var statusRow = {
  width: "100%",
  // height: "8rem",
  outline: "black solid 2px",
  borderRadius: "20px",
  backgroundColor: "white",
  margin: "1rem 0.5rem 1rem 0.5rem",
  padding: "1rem 1rem 1rem 1rem",
  backgroundImage: `url(${border})`,
  backgroundPosition: "center",
  backgroundSize: "cover",
  boxShadow: "2px 2px 4px #000000",
  border: "double",
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

const CharacterStatus = ({ attributes, setAttributes }) => {
  // input: key must be a string, corresponding to the value's key you wish to update.
  // TODO: consolidate duplicate code: this method is also defined in CharacterInfo
  const setAttributeIntHandler = (key) => (e) => {
    const re = RegExp(/^[0-9\b]+$/);
    // if blank, set value to 0 (avoids NaN). otherwise, if the input value is a valid int, update states.
    if (e.target.value === "") {
      setAttributes({ ...attributes, [key]: 0 });
    } else if (re.test(e.target.value)) {
      setAttributes({ ...attributes, [key]: parseInt(e.target.value) });
    }
  };

  return (
    <Row style={statusRow}>
      <Col lg={4} style={{ textAlign: "left" }}>
        <p style={hpText}>HP:</p>
        <input
          style={hpInput}
          value={attributes.currentHitPoints}
          onChange={setAttributeIntHandler("currentHitPoints")}
        />
        <p style={hpText}>/</p>
        <input
          style={hpInput}
          value={attributes.hitPoints}
          onChange={setAttributeIntHandler("hitPoints")}
        />
      </Col>
      <Col lg={2} align="center">
        <input
          style={input}
          value={attributes.armorClass}
          onChange={setAttributeIntHandler("armorClass")}
        />
        <h4>Armor Class</h4>
      </Col>
      <Col lg={2} align="center">
        <h4>
          {attributes.profBonus > -1 ? "+" : ""}
          {attributes.profBonus}
        </h4>
        <h4>Profiency Bonus</h4>
      </Col>
      <Col lg={2} align="center">
        <h4>
          {calculateMod(attributes.DEX) > -1 ? "+" : ""}
          {calculateMod(attributes.DEX)}
        </h4>
        <h4>Initiative</h4>
      </Col>
      <Col lg={2} align="center">
        <input
          style={input}
          value={attributes.speed}
          onChange={setAttributeIntHandler("speed")}
        />
        <h4>Speed</h4>
      </Col>
    </Row>
  );
};

export default CharacterStatus;
