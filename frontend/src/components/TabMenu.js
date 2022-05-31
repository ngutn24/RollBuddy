import { useState } from "react";
import { Tab, Tabs } from "react-bootstrap";
import { calculateMod } from "./Helpers";
import border from "../assets/window_bg.png";

var ComponentWindow = {
  display: "block",
  overflow: "auto",
  outline: "black solid 2px",
  borderRadius: "20px",
  backgroundColor: "white",
  margin: "1rem 1rem 1rem 1rem",
  padding: "1rem 1rem 1rem 1rem",
  backgroundImage: `url(${border})`,
  backgroundPosition: "center",
  backgroundSize: "cover",
  boxShadow: "2px 2px 4px #000000",
  border: "double",
};

const TabMenu = ({ attributes, setAttributes }) => {
  const [key, setKey] = useState("proficiencies");

  // TODO: add field for which data to get from the backend
  let skills = [
    { label: "Acrobatics", abilityType: "STR" },
    { label: "Animal Handling", abilityType: "WIS" },
    { label: "Arcana", abilityType: "INT" },
    { label: "Deception", abilityType: "CHA" },
    { label: "History", abilityType: "INT" },
    { label: "Insight", abilityType: "WIS" },
    { label: "Intimidation", abilityType: "CHA" },
    { label: "Investigation", abilityType: "INT" },
    { label: "Medicine", abilityType: "WIS" },
    { label: "Perception", abilityType: "WIS" },
    { label: "Performance", abilityType: "CHA" },
    { label: "Persuasion", abilityType: "CHA" },
    { label: "Religion", abilityType: "INT" },
    { label: "Slight of Hand", abilityType: "DEX" },
    { label: "Stealth", abilityType: "DEX" },
    { label: "Survival", abilityType: "WIS" },
  ];

  // input: key must be a string, corresponding to the value's key you wish to update.
  const setAttributeHandler = (key) => (e) => {
    setAttributes({ ...attributes, [key]: e.target.value });
  };

  return (
    <div style={ComponentWindow}>
      <Tabs activeKey={key} onSelect={(k) => setKey(k)} className="mb-3">
        <Tab eventKey="proficiencies" title="Proficiencies">
          {skills.map((skill) => (
            <div>
              <label
                style={{
                  font: "bold 18px cursive",
                }}
              >
                {skill.label} ({skill.abilityType}):
              </label>{" "}
              <label>
                {calculateMod(attributes[skill.abilityType]) > -1 ? "+" : ""}
                {calculateMod(attributes[skill.abilityType])}
              </label>
            </div>
          ))}
        </Tab>
        <Tab eventKey="items" title="Items">
          <textarea
            style={{ width: "100%", height: "24rem" }}
            value={attributes.items}
            onChange={setAttributeHandler("items")}
          ></textarea>
        </Tab>
      </Tabs>
    </div>
  );
};

export default TabMenu;
