import { Row, Col } from "react-bootstrap";

const CharacterInfo = () => {
  return (
    <Row>
      <Col lg={3}>
        <h1>Name:</h1>
        <input />
        <h3>Campaign Name:</h3>
        <input />
      </Col>
      <Col lg={6}>
        <Row>
          <Col>
            <h1>Class & Level:</h1>
            <input />
            <h1>Race:</h1>
            <input />
          </Col>{" "}
          <Col>
            <h1>BG:</h1>
            <input />
            <h1>Alignment:</h1>
            <input />
          </Col>
        </Row>
      </Col>
      <Col lg={3}>
        <h1>EXP:</h1>
        <input />
      </Col>
    </Row>
  );
};

export default CharacterInfo;
