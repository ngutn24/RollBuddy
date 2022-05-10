import { React } from "react";
import Ability from "./Ability.js";

const AbilityList = ({ abilities, setAbilities }) => {
  // Map from key to display name
  const abilityDisplayNames = {
    STR: "Strength",
    DEX: "Dexterity",
    CON: "Constitution",
    INT: "Intelligence",
    WIS: "Wisdom",
    CHA: "Charisma",
  };

  return (
    <>
      {Object.keys(abilities).map((item) => (
        <Ability
          displayName={abilityDisplayNames[item]}
          score={abilities[item]}
          abilities={abilities}
          id={item}
          setAbilities={setAbilities}
          key={item}
        />
      ))}
    </>
  );
};

export default AbilityList;
