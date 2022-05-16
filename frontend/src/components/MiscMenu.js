import { React, useState, useEffect } from "react";
import { Button } from "react-bootstrap";

var ComponentWindow = {
    display: "block",
    overflow: "auto",
    outline: "black solid 2px",
    borderRadius: "20px",
    backgroundColor: "white",
    margin: "1rem 1rem 1rem 1rem",
    padding: "1rem 1rem 1rem 1rem",
};

var checkBox = {
    transform: "scale(1.5)",
    outline: "black solid 1px",
    margin: "1rem 1rem 1rem 1rem",
}

var textLabel = {
    fontWeight: "400",
    fontSize: "1.5rem",
    display: "inline",
}

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

    function createDeathcheckBoxes(numRolled) {
        var outcomes = [];
        for (var i = 1; i <= 3; i++) {
            outcomes.push(<input type="checkbox" checked={i <= numRolled} style={checkBox}></input>)
        }
        return outcomes;
    }

    var successes = createDeathcheckBoxes(deathSuccesses);
    var faiilures = createDeathcheckBoxes(deathFailures);

    return (
        <div>
            <div id = "inspiration" style={ComponentWindow}>
                <input type="checkbox" checked={hasInspiration} onChange={handleCheckBox} style={checkBox}></input>
                <label style={textLabel}>Inspiration</label>
            </div>

            <div id = "deathSaves" style={ComponentWindow}>
                <div>
                    <label style={textLabel}>Successes</label>
                    <div style={{ float: "right" }}>
                        {successes}
                        <Button onClick={decrementSuccessHandler}>-</Button>
                        <Button onClick={incrementSuccessHandler}>+</Button>
                    </div> 
                </div>
                <br></br>
                <label style={textLabel}>Failures</label>
                <div style={{ float: "right" }}>
                    {faiilures}
                    <Button onClick={decrementFailureHandler}>-</Button>
                    <Button onClick={incrementFailureHandler}>+</Button>
                </div>
            </div>
        </div>
    );
};

export default MiscMenu