import {React, useState, useEffect} from "react";
import {DropdownButton, Dropdown, ButtonGroup} from "react-bootstrap";
import {baseURL} from "./CharacterSheet";
import axios from "axios";
import border from '../assets/window_bg.png'

import { AwesomeButton } from "react-awesome-button";
import "react-awesome-button/dist/styles.css";
import 'react-awesome-button/dist/themes/theme-red.css';

const RollWindow = {
    display: "block",
    overflow: "auto",
    outline: "black solid 2px",
    borderRadius: "20px",
    backgroundColor: "white",
    margin: "1rem 1rem 1rem 1rem",
    backgroundImage: `url(${border})`,
    backgroundPosition: "center",
    backgroundSize: "cover",
    boxShadow: "2px 2px 4px #000000",
    border: "double",
};

const RollInputCount = {
    width: "6rem",
    height: "4rem",
    margin: "0rem 0.5rem 0rem 0.5rem",
    fontSize: "2rem",
    textAlign: "right",
};

const abilityCode = {
    Strength: "str",
    Dexterity: "dex",
    Constitution: "con",
    Intelligence: "int",
    Wisdom: "wis",
    Charisma: "cha",
};

const rollButtonFont = {
    margin: "1rem",
    width: "80%",
    height: "5rem",
    fontSize: "2rem",
};



const RollMenu = ({id}) => {
    // Selector states
    const [rollType, setRollType] = useState("Attack");
    const [rollCondition, setRollCondition] = useState("Normal");
    const [rollAbility, setRollAbility] = useState("Strength");
    const [rollProficiency, setRollProficiency] = useState("Proficent");
    const [rollDice, setRollDice] = useState("4");
    // Roller States
    const [count, setCount] = useState(0);
    const [value, setValue] = useState(0);

    const handleSelectState = (setState) => (e) => {
        setState(e);
    };

    const handleInputState = (setState) => (e) => {
        const re = RegExp(/^[0-9\b]+$/);
        // if blank, set value to 0 (avoids NaN). otherwise, if the input value is a valid int, update states.
        if (e.target.value === "") {
            setState(parseInt(0));
        } else if (re.test(e.target.value)) {
            setState(parseInt(e.target.value));
        }
    };

    const fetchDiceRoll = () => {
        // TODO: cleanup url construction/definition to ensure safety.
        const url = encodeURI(
            baseURL +
            "/roll" +
            "?id=" +
            id +
            "&mod=" +
            abilityCode[rollAbility] +
            "&count=" +
            count +
            "&dice=d" +
            rollDice
        );

        axios
            .get(url, {
                withCredentials: true,
            })
            .then((res) => {
                setValue(res.data);
                console.log("[DEBUG] Fetched dice roll: ", {
                    mod: rollAbility,
                    count: count,
                    dice: "d" + rollDice,
                    value: res.data,
                });
            });
    };

    // load state from local storage
    useEffect(() => {
        const localRollInfo = JSON.parse(localStorage.getItem("rollInfo"));
        if (localRollInfo) {
            console.log("Loading rollInfo from storage... ", localRollInfo);
            setRollType(localRollInfo.rollType);
            setRollCondition(localRollInfo.rollCondition);
            setRollAbility(localRollInfo.rollAbility);
            setRollProficiency(localRollInfo.rollProficiency);
            setRollDice(localRollInfo.rollDice);
            setCount(localRollInfo.count);
        }
    }, []);

    // store state to local storage
    useEffect(() => {
        const rollInfo = {
            rollType: rollType,
            rollCondition: rollCondition,
            rollAbility: rollAbility,
            rollProficiency: rollProficiency,
            rollDice: rollDice,
            count: count,
        };
        localStorage.setItem("rollInfo", JSON.stringify(rollInfo));
    }, [rollType, rollCondition, rollAbility, rollProficiency, rollDice, count]);

    return (
        <div align="center" style={RollWindow}>
            <ButtonGroup>
                <DropdownButton
                    id="roll_Type"
                    title={rollType}
                    onSelect={handleSelectState(setRollType)}
                    style={{margin: "1rem 0.5rem 0.5rem 1rem", width: "100%"}}
                >
                    <Dropdown.Item eventKey="Attack">Attack</Dropdown.Item>
                    <Dropdown.Item eventKey="Check">Check</Dropdown.Item>
                    <Dropdown.Item eventKey="Saving Throw">Saving Throw</Dropdown.Item>
                    <Dropdown.Item eventKey="No Modifier">No Modifer</Dropdown.Item>
                </DropdownButton>
                <DropdownButton
                    id="roll_Condition"
                    title={rollCondition}
                    onSelect={handleSelectState(setRollCondition)}
                    style={{margin: "1rem 1rem 0.5rem 0.5rem", width: "100%"}}
                >
                    <Dropdown.Item eventKey="Normal">Normal</Dropdown.Item>
                    <Dropdown.Item eventKey="Advantage">Advantage</Dropdown.Item>
                    <Dropdown.Item eventKey="Disadvantage">Disadvantage</Dropdown.Item>
                </DropdownButton>
            </ButtonGroup>
            <ButtonGroup>
                <DropdownButton
                    id="roll_Ability"
                    title={rollAbility}
                    onSelect={handleSelectState(setRollAbility)}
                    style={{margin: "0.5rem 0.5rem 1rem 1rem"}}
                >
                    <Dropdown.Item eventKey="Strength">Strength</Dropdown.Item>
                    <Dropdown.Item eventKey="Dexterity">Dexterity</Dropdown.Item>
                    <Dropdown.Item eventKey="Constitution">Constitution</Dropdown.Item>
                    <Dropdown.Item eventKey="Intelligence">Intelligence</Dropdown.Item>
                    <Dropdown.Item eventKey="Wisdom">Wisdom</Dropdown.Item>
                    <Dropdown.Item eventKey="Charisma">Charisma</Dropdown.Item>
                </DropdownButton>
                <DropdownButton
                    id="roll_Proficiency"
                    title={rollProficiency}
                    onSelect={handleSelectState(setRollProficiency)}
                    style={{margin: "0.5rem 1rem 1rem 0.5rem"}}
                >
                    <Dropdown.Item eventKey="No">No</Dropdown.Item> {/* +0 */}
                    <Dropdown.Item eventKey="Proficient">Proficient</Dropdown.Item>{" "}
                    {/* + proficiency bonus */}
                    <Dropdown.Item eventKey="Expertise">Expertise</Dropdown.Item>{" "}
                    {/* + 2*proficiency bonus */}
                </DropdownButton>
            </ButtonGroup>
            <div className="roller-inputs" style={{padding: "0.5rem"}}>
                <input
                    type="text"
                    value={count}
                    onChange={handleInputState(setCount)}
                    style={RollInputCount}
                ></input>
                <p style={{display: "inline", fontSize: "2rem"}}>d</p>

                <DropdownButton
                    id="roll_Dice"
                    size="lg"
                    variant="secondary"
                    title={rollDice}
                    onSelect={handleSelectState(setRollDice)}
                    style={{display: "inline", margin: "0rem 0.5rem 0rem 0.5rem"}}
                >
                    <Dropdown.Item eventKey="4">4</Dropdown.Item>
                    <Dropdown.Item eventKey="6">6</Dropdown.Item>
                    <Dropdown.Item eventKey="8">8</Dropdown.Item>
                    <Dropdown.Item eventKey="10">10</Dropdown.Item>
                    <Dropdown.Item eventKey="12">12</Dropdown.Item>
                    <Dropdown.Item eventKey="20">20</Dropdown.Item>
                    <Dropdown.Item eventKey="100">100</Dropdown.Item>
                </DropdownButton>
            </div>
            {/* <p style={{ display: "inline" }}>
        Constitution Saving Throw: 13 (1d20) + 2 (proficent) + 2 (CON modifier)
        =
      </p>{" "} */
                /* TODO: Have this display values used for calculation */}
            <div className="roller-output" style={{padding: "0.5rem"}}>
                <h4>Roll Value: </h4>
                <h2>{value}</h2>
            </div>

            <AwesomeButton
                size= "large"
                type="primary"
                ripple
                style={rollButtonFont}
                onPress={() => {fetchDiceRoll()}}
            >
                ROLL
            </AwesomeButton>{" "}
            {/* Have this display the final calculated value */}
        </div>
    );
};

export default RollMenu;
