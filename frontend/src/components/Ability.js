import React from "react";
import { Button, Container } from "react-bootstrap";

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

  return (
    <div style={{ maxWidth: "15rem", outline: "black solid 2px" }}>
      <h1>{abilityName}</h1>
      <input
        onChange={setAbilitiesHandler}
        type="text"
        className="abilityText"
        value={inputText}
        style={{
          width: "10rem",
          padding: "12px 20px",
          margin: "8px 0",
          boxSizing: "border-box",
        }}
      />
      <Button>+</Button>
    </div>
  );
};

export default Ability;
