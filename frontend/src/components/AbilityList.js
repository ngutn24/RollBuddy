import Ability from "./Ability.js";

export const AbilityList = ({ attributes, setAttributes }) => {
  // Map from key to display name
  const abilityDisplayNames = {
    STR: "Strength",
    DEX: "Dexterity",
    CON: "Constitution",
    INT: "Intelligence",
    WIS: "Wisdom",
    CHA: "Charisma",
  };

  const abilityKeys = ["STR", "DEX", "CON", "INT", "WIS", "CHA"];

  const setAbilityScore = (id, score) => {
    setAttributes({
      ...attributes,
      [id]: {
        ...attributes[id],
        abilityScore: parseInt(score),
      },
    });
  };

  return (
    <>
      {abilityKeys.map((item) => (
        <Ability
          displayName={abilityDisplayNames[item]}
          score={attributes[item].abilityScore}
          id={item}
          setAbilityScore={setAbilityScore}
          key={item}
        />
      ))}
    </>
  );
};

export default AbilityList;
