import { useState, useEffect } from "react";
import { Row, Col, DropdownButton, Dropdown } from "react-bootstrap";

var charDetails = {
  maxWidth: "100%",
  outline: "black solid 2px",
  borderRadius: "20px",
  backgroundColor: "white",
  margin: "0.5rem 0.5rem 0.5rem 0.5rem",
  padding: "1rem 1rem 1rem 1rem"
};

const CharacterInfo = () => {
  const [name, setName] = useState("");
  const [campaign, setCampaign] = useState("");
  const [charClass, setCharClass] = useState("");
  const [charClassLvl, setCharClassLvl] = useState(0);
  const [charSubClass, setCharSubClass] = useState("");
  const [charSubClassLvl, setCharSubClassLvl] = useState(0);
  const [race, setRace] = useState("");
  const [bg, setBg] = useState("");
  const [alignment, setAlignment] = useState("True Neutral");
  const [exp, setExp] = useState(0);

  let alignments = [
    { label: "Lawful Good" }, 
    { label: "Neutral Good" }, 
    { label: "Chaotic Good" }, 
    { label: "Lawful Neutral" }, 
    { label: "True Neutral" }, 
    { label: "Chaotic Neutral" }, 
    { label: "Lawful Evil" }, 
    { label: "True Evil" }, 
    { label: "Chaotic Evil" }
  ]

  useEffect(() => {
    const localCharInfo = JSON.parse(localStorage.getItem("charInfo"));
    if (localCharInfo) {
      console.log("Loading charInfo from storage... ", localCharInfo);
      setName(localCharInfo.name);
      setCampaign(localCharInfo.campaign);
      setCharClass(localCharInfo.charClass);
      setCharClassLvl(localCharInfo.charClassLvl);
      setCharSubClass(localCharInfo.charSubClass);
      setCharSubClassLvl(localCharInfo.charSubClassLvl);
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
      charClassLvl: charClassLvl,
      charSubClass: charSubClass,
      charSubClassLvl: charSubClassLvl,
      race: race,
      bg: bg,
      alignment: alignment,
      exp: exp,
    };
    localStorage.setItem("charInfo", JSON.stringify(charInfo));
  }, [name, campaign, charClass, charClassLvl, charSubClass, charSubClassLvl, race, bg, alignment, exp]);

  const updateStateHandler = (setState) => (e) => {
    setState(e.target.value);
  };

  const updateDropdownStateHandler = (setState) => (e) => {
    setState(e);
  };

  return (
    <Row>
      <Col lg={3} style={charDetails}>
        <h1>Name:</h1>
        <input value={name} onChange={updateStateHandler(setName)} />
        <h3>Campaign Name:</h3>
        <input value={campaign} onChange={updateStateHandler(setCampaign)} />
      </Col>
      <Col lg={6} style={charDetails}>
        <Row>
          <Col>
            <h3>Classes - Lvls:</h3>
            <input
              value={charClass}
              onChange={updateStateHandler(setCharClass)}
              style={{maxWidth: "60%"}}
            />
            <input
              value={charClassLvl}
              onChange={updateStateHandler(setCharClassLvl)}
              style={{maxWidth: "20%"}}
            />
            <input
              value={charSubClass}
              onChange={updateStateHandler(setCharSubClass)}
              style={{maxWidth: "60%"}}
            />
            <input
              value={charSubClassLvl}
              onChange={updateStateHandler(setCharSubClassLvl)}
              style={{maxWidth: "20%"}}
            />
            <h3>Race:</h3>
            <input value={race} onChange={updateStateHandler(setRace)} />
          </Col>{" "}
          <Col>
            <h3>Background:</h3>
            <input value={bg} onChange={updateStateHandler(setBg)} />
            <h3>Alignment:</h3>
            <DropdownButton
              title={alignment}
              onSelect={updateDropdownStateHandler(setAlignment)}
            >
              {alignments.map((align) => <Dropdown.Item key={align.label} eventKey={align.label}>{align.label}</Dropdown.Item>)}
            </DropdownButton>
          </Col>
        </Row>
      </Col>
      <Col lg={2} style={charDetails}>
        <h3>EXP:</h3>
        <input value={exp} onChange={updateStateHandler(setExp)} style={{maxWidth: "100%"}}/>
      </Col>
    </Row>
  );
};

export default CharacterInfo;
