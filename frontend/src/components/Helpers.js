export const calculateMod = (score) => {
  // Calculate how far from baseMod the abilityScore is
  const baseMod = 10;
  const deviation = score - baseMod;

  if (deviation >= 0) {
    return parseInt(deviation / 2);
  } else {
    return parseInt((deviation + 1) / 2 - 1);
  }
};
