import React from "react";
import { Button } from "react-bootstrap";

const Ability = ({
  abilityName,
  inputText,
  abilities,
  setAbilities,
  abilityID,
}) => {
  // TODO: Prune to only allow numerical values, cast to int?
  const setAbilitiesHandler = (e) => {
    console.log(abilities);
    setAbilities({ ...abilities, [abilityID]: e.target.value });
  };

  // Formats ability score component to be a centered rounded box with a white background
  var AbilityScore = {
    maxWidth: "8rem", 
    outline: "black solid 2px", 
    borderRadius: "20px", 
    backgroundColor: "white", 
    margin: "1rem 0.5rem 1rem 0.5rem"
  }

  return (
    <div align="center" style={AbilityScore}>
      <h1 style={{textDecorationLine: "underline", fontSize: "1rem"}}>{abilityName}</h1>
      <h1>+0</h1> {/* This will be the ability score modifier */}
      <input
        onChange={setAbilitiesHandler}
        type="text"
        className="abilityText"
        value={inputText}
        style={{
          width: "5rem",
          padding: "4px 4px",
          margin: "8px 0",
          boxSizing: "border-box",
          textAlign: "center"
        }}
      />
      <div style={{ display: "inline-block" }}>
        <Button>-</Button>
        <Button>+</Button>
      </div>
    </div>
  );
};

export default Ability;
