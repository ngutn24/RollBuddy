// import { useState, useEffect } from "react";
import { Row, Col, DropdownButton, Dropdown } from "react-bootstrap";
import border from "../assets/window_bg.png";

var charDetails = {
  maxWidth: "100%",
  outline: "black solid 2px",
  borderRadius: "20px",
  backgroundColor: "white",
  margin: "0.5rem 0.5rem 0.5rem 0.5rem",
  padding: "1rem 1rem 1rem 1rem",
  backgroundImage: `url(${border})`,
  backgroundPosition: "center",
  backgroundSize: "cover",
  boxShadow: "2px 2px 4px #000000",
  border: "double",
};

var longInputStyle = {
  boxShadow: "0.5px 0.5px 1px #000000",
  textAlign: "center",
  font: "italic bold 15px cursive",
  maxWidth: "60%",
};

var shortInputStyle = {
  boxShadow: "0.5px 0.5px 1px #000000",
  textAlign: "center",
  font: "italic bold 15px cursive",
  maxWidth: "20%",
};

var expInputStyle = {
  boxShadow: "0.5px 0.5px 1px #000000",
  textAlign: "center",
  font: "italic bold 15px cursive",
  maxWidth: "100%",
};

const CharacterInfo = ({ attributes, setAttributes }) => {
  // const [name, setName] = useState("");
  // const [campaign, setCampaign] = useState("");
  // const [charClass, setCharClass] = useState("");
  // const [charClassLvl, setCharClassLvl] = useState(0);
  // const [charSubClass, setCharSubClass] = useState("");
  // const [charSubClassLvl, setCharSubClassLvl] = useState(0);
  // const [race, setRace] = useState("");
  // const [bg, setBg] = useState("");
  // const [alignment, setAlignment] = useState("True Neutral");
  // const [exp, setExp] = useState(0);

  let alignments = [
    { label: "Lawful Good" },
    { label: "Neutral Good" },
    { label: "Chaotic Good" },
    { label: "Lawful Neutral" },
    { label: "True Neutral" },
    { label: "Chaotic Neutral" },
    { label: "Lawful Evil" },
    { label: "True Evil" },
    { label: "Chaotic Evil" },
  ];

  // useEffect(() => {
  //   const localCharInfo = JSON.parse(localStorage.getItem("charInfo"));
  //   if (localCharInfo) {
  //     console.log("Loading charInfo from storage... ", localCharInfo);
  //     setName(localCharInfo.name);
  //     setCampaign(localCharInfo.campaign);
  //     setCharClass(localCharInfo.charClass);
  //     setCharClassLvl(localCharInfo.charClassLvl);
  //     setCharSubClass(localCharInfo.charSubClass);
  //     setCharSubClassLvl(localCharInfo.charSubClassLvl);
  //     setRace(localCharInfo.race);
  //     setBg(localCharInfo.bg);
  //     setAlignment(localCharInfo.alignment);
  //     setExp(localCharInfo.exp);
  //   }
  // }, []);

  // useEffect(() => {
  //   const charInfo = {
  //     name: name,
  //     campaign: campaign,
  //     charClass: charClass,
  //     charClassLvl: charClassLvl,
  //     charSubClass: charSubClass,
  //     charSubClassLvl: charSubClassLvl,
  //     race: race,
  //     bg: bg,
  //     alignment: alignment,
  //     exp: exp,
  //   };
  //   localStorage.setItem("charInfo", JSON.stringify(charInfo));
  // }, [
  //   name,
  //   campaign,
  //   charClass,
  //   charClassLvl,
  //   charSubClass,
  //   charSubClassLvl,
  //   race,
  //   bg,
  //   alignment,
  //   exp,
  // ]);

  // const updateStateHandler = (setState) => (e) => {
  //   setState(e.target.value);
  // };

  // const updateDropdownStateHandler = (setState) => (e) => {
  //   setState(e);
  // };

  // input: key must be a string, corresponding to the value's key you wish to update.
  const setAttributeHandler = (key) => (e) => {
    setAttributes({ ...attributes, [key]: e.target.value });
  };

  // input: key must be a string, corresponding to the value's key you wish to update.
  const setAttributeDropdownHandler = (key) => (e) => {
    setAttributes({ ...attributes, [key]: e });
  };

  // input: key must be a string, corresponding to the value's key you wish to update.
  const setAttributeIntHandler = (key) => (e) => {
    const re = RegExp(/^[0-9\b]+$/);
    // if blank, set value to 0 (avoids NaN). otherwise, if the input value is a valid int, update states.
    if (e.target.value === "") {
      setAttributes({ ...attributes, [key]: 0 });
    } else if (re.test(e.target.value)) {
      setAttributes({ ...attributes, [key]: parseInt(e.target.value) });
    }
  };

  // input: key must be a string, corresponding to the value's key you wish to update.
  const setNestedAttributeHandler = (outerKey, innerKey) => (e) => {
    setAttributes({
      ...attributes,
      [outerKey]: {
        ...attributes[outerKey],
        [innerKey]: e.target.value,
      },
    });
  };

  // input: key must be a string, corresponding to the value's key you wish to update.
  // TODO: clean-up reused code.
  const setNestedAttributeIntHandler = (outerKey, innerKey) => (e) => {
    const re = RegExp(/^[0-9\b]+$/);
    // if blank, set value to 0 (avoids NaN). otherwise, if the input value is a valid int, update states.
    if (e.target.value === "") {
      setAttributes({
        ...attributes,
        [outerKey]: {
          ...attributes[outerKey],
          [innerKey]: 0,
        },
      });
    } else if (re.test(e.target.value)) {
      setAttributes({
        ...attributes,
        [outerKey]: {
          ...attributes[outerKey],
          [innerKey]: parseInt(e.target.value),
        },
      });
    }
  };

  return (
    <Row>
      <Col lg={3} style={charDetails}>
        <h1>Name:</h1>
        <input
          value={attributes.name}
          onChange={setAttributeHandler("name")}
          style={longInputStyle}
        />
        <h3>Campaign Name:</h3>
        <input
          value={attributes.campaign}
          onChange={setAttributeHandler("campaign")}
          style={longInputStyle}
        />
      </Col>
      <Col lg={6} style={charDetails}>
        <Row>
          <Col>
            <h3>Classes - Lvls:</h3>
            <input
              value={attributes.mainClass.charClass}
              onChange={setNestedAttributeHandler("mainClass", "charClass")}
              style={longInputStyle}
            />
            <input
              value={attributes.mainClass.level}
              onChange={setNestedAttributeIntHandler("mainClass", "level")}
              style={shortInputStyle}
            />
            <input
              value={attributes.subClass.charClass}
              onChange={setNestedAttributeHandler("subClass", "charClass")}
              style={longInputStyle}
            />
            <input
              value={attributes.subClass.level}
              onChange={setNestedAttributeIntHandler("subClass", "level")}
              style={shortInputStyle}
            />
            <h3>Race:</h3>
            <input
              value={attributes.race}
              onChange={setAttributeHandler("race")}
              style={longInputStyle}
            />
          </Col>{" "}
          <Col>
            <h3>Background:</h3>
            <input
              value={attributes.background}
              onChange={setAttributeHandler("background")}
              style={longInputStyle}
            />
            <h3>Alignment:</h3>
            <DropdownButton
              title={attributes.alignment}
              onSelect={setAttributeDropdownHandler("alignment")}
            >
              {alignments.map((align) => (
                <Dropdown.Item key={align.label} eventKey={align.label}>
                  {align.label}
                </Dropdown.Item>
              ))}
            </DropdownButton>
          </Col>
        </Row>
      </Col>
      <Col lg={2} style={charDetails}>
        <h3>EXP:</h3>
        <input
          value={attributes.exp}
          onChange={setAttributeIntHandler("exp")}
          style={expInputStyle}
        />
      </Col>
    </Row>
  );
};

export default CharacterInfo;
