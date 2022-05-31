import { useState, useEffect } from "react";
import { Button } from "react-bootstrap";
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

var checkBox = {
  transform: "scale(1.5)",
  outline: "black solid 1px",
  margin: "1rem 1rem 1rem 1rem",
};

var textLabel = {
  fontWeight: "400",
  fontSize: "1.5rem",
  display: "inline",
};

var buttonPlusAndMinus = {
  width: "2.5rem",
  textShadow: "2px 2px 2px black",
  borderRadius: "10",
  raised: "true",
  margin: "0.2rem 0rem 0.5rem 0.2rem",
  color: "antiquewhite",
  fontSize: "1.8rem",
  padding: "0rem",
};

const MiscMenu = () => {
  const [hasInspiration, setHasInspiration] = useState(false);
  const [deathSuccesses, setDeathSuccesses] = useState(0);
  const [deathFailures, setDeathFailures] = useState(0);

  // load state from local storage
  useEffect(() => {
    const localmiscInfo = JSON.parse(localStorage.getItem("miscInfo"));
    if (localmiscInfo) {
      console.log("Loading miscInfo from storage... ", localmiscInfo);
      setHasInspiration(localmiscInfo.hasInspiration);
      setDeathSuccesses(localmiscInfo.deathSuccesses);
      setDeathFailures(localmiscInfo.deathFailures);
    }
  }, []);

  // store state to local storage
  useEffect(() => {
    const miscInfo = {
      hasInspiration: hasInspiration,
      deathSuccesses: deathSuccesses,
      deathFailures: deathFailures,
    };
    localStorage.setItem("miscInfo", JSON.stringify(miscInfo));
  }, [hasInspiration, deathSuccesses, deathFailures]);

  const handleCheckBox = () => {
    setHasInspiration(!hasInspiration);
  };

  const incrementSuccessHandler = () => {
    if (deathSuccesses < 3) {
      setDeathSuccesses(deathSuccesses + 1);
    }
  };

  const decrementSuccessHandler = () => {
    if (deathSuccesses > 0) {
      setDeathSuccesses(deathSuccesses - 1);
    }
  };

  const incrementFailureHandler = () => {
    if (deathFailures < 3) {
      setDeathFailures(deathFailures + 1);
    }
  };

  const decrementFailureHandler = () => {
    if (deathFailures > 0) {
      setDeathFailures(deathFailures - 1);
    }
  };

  function createDeathcheckBoxes(numRolled, type) {
    var outcomes = [];
    for (var i = 1; i <= 3; i++) {
      outcomes.push(
        <input
          key={type + i}
          type="checkbox"
          checked={i <= numRolled}
          style={checkBox}
          readOnly
        ></input>
      );
    }
    return outcomes;
  }

  var successes = createDeathcheckBoxes(deathSuccesses, "deathSuccesses");
  var failures = createDeathcheckBoxes(deathFailures, "deathFailures");

  return (
    <div>
      <div id="inspiration" style={ComponentWindow}>
        <input
          type="checkbox"
          checked={hasInspiration}
          onChange={handleCheckBox}
          style={checkBox}
        ></input>
        <label style={textLabel}>Inspiration</label>
      </div>
      <div id="deathSaves" style={ComponentWindow}>
        <div style={{ float: "right" }}>
          <label style={textLabel}>Successes</label>
          <div style={{ float: "right" }}>
            {successes}
            <Button
              style={buttonPlusAndMinus}
              onClick={decrementSuccessHandler}
            >
              -
            </Button>
            <Button
              style={buttonPlusAndMinus}
              onClick={incrementSuccessHandler}
            >
              +
            </Button>
          </div>
        </div>
        <br></br>
        <div>
          <div style={{ float: "right" }}>
            <label style={textLabel}>Failures</label>
            {failures}
            <Button
              style={buttonPlusAndMinus}
              onClick={decrementFailureHandler}
            >
              -
            </Button>
            <Button
              style={buttonPlusAndMinus}
              onClick={incrementFailureHandler}
            >
              +
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MiscMenu;
