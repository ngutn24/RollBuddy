import React from "react";
import { Button } from "react-bootstrap";
import { calculateMod } from "./Helpers";

// Formats ability score component to be a cesntered rounded box with a white background
var AbilityScore = {
  maxWidth: "8rem",
  outline: "black solid 2px",
  borderRadius: "20px",
  backgroundColor: "white",
  margin: "1rem 0.5rem 1rem 0.5rem",
};

const Ability = ({ displayName, score, abilities, setAbilities, id }) => {
  const setAbilitiesHandler = (e) => {
    const re = RegExp(/^[0-9\b]+$/);
    // if blank, set value to 0 (avoids NaN). otherwise, if the input value is a valid int, update states.
    if (e.target.value === "") {
      setAbilities({ ...abilities, [id]: 0 });
    } else if (re.test(e.target.value)) {
      setAbilities({ ...abilities, [id]: parseInt(e.target.value) });
    }
  };

  const decrementHandler = () => {
    const val = parseInt(score) - 1;
    if (val > -1) {
      setAbilities({ ...abilities, [id]: val });
    }
  };

  const incrementHandler = () => {
    const val = parseInt(score) + 1;
    setAbilities({ ...abilities, [id]: val });
  };

  return (
    <div align="center" style={AbilityScore}>
      <h1 style={{ textDecorationLine: "underline", fontSize: "1rem" }}>
        {displayName}
      </h1>
      <h1>
        {calculateMod(score) >= 0 ? "+" : ""}
        {calculateMod(score)}
      </h1>
      {/* This will be the ability score modifier */}
      <input
        onChange={setAbilitiesHandler}
        type="text"
        className="abilityText"
        value={score}
        style={{
          width: "5rem",
          padding: "4px 4px",
          margin: "8px 0",
          boxSizing: "border-box",
          textAlign: "center",
        }}
      />
      <div style={{ display: "inline-block" }}>
        <Button onClick={decrementHandler}>-</Button>
        <Button onClick={incrementHandler}>+</Button>
      </div>
    </div>
  );
};

export default Ability;
