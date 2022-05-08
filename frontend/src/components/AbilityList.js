import { React, useState } from "react";
import { Col } from "react-bootstrap";
import Ability from "./Ability.js";

const AbilityList = () => {
  const [abilities, setAbilities] = useState({ str: 100, stam: 20, int: 0 });

  // Map from key to display name
  const abilityDisplayNames = {
    int: "Intelligence",
    stam: "Stamina",
    str: "Strenght",
  };

  return (
    <>
      {Object.keys(abilities).map((item) => (
        <Ability
          abilityName={abilityDisplayNames[item]}
          inputText={abilities[item]}
          abilities={abilities}
          setAbilities={setAbilities}
          abilityID={item}
          key={item}
        />
      ))}
    </>
  );
};

export default AbilityList;
