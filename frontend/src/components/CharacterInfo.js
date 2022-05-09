import { useState, useEffect } from "react";
import { Row, Col } from "react-bootstrap";

const CharacterInfo = () => {
  const [name, setName] = useState("");
  const [campaign, setCampaign] = useState("");
  const [charClass, setCharClass] = useState("");
  const [race, setRace] = useState("");
  const [bg, setBg] = useState("");
  const [alignment, setAlignment] = useState("");
  const [exp, setExp] = useState(0);

  useEffect(() => {
    const localCharInfo = JSON.parse(localStorage.getItem("charInfo"));
    if (localCharInfo) {
      console.log("Loading charInfo from storage... ", localCharInfo);
      setName(localCharInfo.name);
      setCampaign(localCharInfo.campaign);
      setCharClass(localCharInfo.charClass);
      setRace(localCharInfo.race);
      setBg(localCharInfo.bg);
      setAlignment(localCharInfo.alignment);
      setExp(localCharInfo.exp);
    }
  }, []);

  useEffect(() => {
    const charInfo = {
      name: name,
      campaign: campaign,
      charClass: charClass,
      race: race,
      bg: bg,
      alignment: alignment,
      exp: exp,
    };
    localStorage.setItem("charInfo", JSON.stringify(charInfo));
  }, [name, campaign, charClass, race, bg, alignment, exp]);

  const updateStateHandler = (setState) => (e) => {
    setState(e.target.value);
  };

  return (
    <Row>
      <Col lg={3}>
        <h1>Name:</h1>
        <input value={name} onChange={updateStateHandler(setName)} />
        <h3>Campaign Name:</h3>
        <input value={campaign} onChange={updateStateHandler(setCampaign)} />
      </Col>
      <Col lg={6}>
        <Row>
          <Col>
            <h1>Class & Level:</h1>
            <input
              value={charClass}
              onChange={updateStateHandler(setCharClass)}
            />
            <h1>Race:</h1>
            <input value={race} onChange={updateStateHandler(setRace)} />
          </Col>{" "}
          <Col>
            <h1>BG:</h1>
            <input value={bg} onChange={updateStateHandler(setBg)} />
            <h1>Alignment:</h1>
            <input
              value={alignment}
              onChange={updateStateHandler(setAlignment)}
            />
          </Col>
        </Row>
      </Col>
      <Col lg={3}>
        <h1>EXP:</h1>
        <input value={exp} onChange={updateStateHandler(setExp)} />
      </Col>
    </Row>
  );
};

export default CharacterInfo;
