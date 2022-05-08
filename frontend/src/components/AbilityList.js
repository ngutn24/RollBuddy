import { React, useState } from "react";
import Ability from "./Ability.js";

const AbilityList = () => {
  const [abilities, setAbilities] = useState(
      { 
        str: 10, 
        dex: 10, 
        con: 10, 
        int: 10, 
        wis: 10, 
        cha: 10 
      }
    );

  // Map from key to display name
  const abilityDisplayNames = {
    str: "Strength",
    dex: "Dexterity",
    con: "Constitution",
    int: "Intelligence",
    wis: "Wisdom",
    cha: "Charisma"
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
