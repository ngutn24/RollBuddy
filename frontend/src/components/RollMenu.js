import { React, useState } from 'react';
import {
    DropdownButton,
    Dropdown,
    Button,
    ButtonGroup,
  } from "react-bootstrap";

  var RollWindow = {
    maxWidth: "25rem", 
    outline: "black solid 2px", 
    borderRadius: "20px", 
    backgroundColor: "white", 
    margin: "1rem 1rem 1rem 1rem",
  }

  const RollMenu = () => {
    const [rollType, setRollType] = useState("Attack");
    const handleSelectRollType = (e) => {
        setRollType(e);
    }

    const [rollCondition, setRollCondition] = useState("Normal");
    const handleSelectRollCondition = (e) => {
        setRollCondition(e);
    }

    const [rollAbility, setRollAbility] = useState("Strength");
    const handleSelectRollAbility = (e) => {
        setRollAbility(e);
    }

    const [rollProficiency, setRollProficiency] = useState("Proficent");
    const handleSelectRollProficiency = (e) => {
        setRollProficiency(e);
    }

    return (
        <div align="center" style={RollWindow}>
            <ButtonGroup>
                <DropdownButton id="roll_Type" title = {rollType} onSelect={handleSelectRollType} style={{margin: "1rem 0.5rem 0.5rem 1rem", width:"100%"}}>
                    <Dropdown.Item eventKey="Attack">Attack</Dropdown.Item>
                    <Dropdown.Item eventKey="Check">Check</Dropdown.Item>
                    <Dropdown.Item eventKey="Saving Throw">Saving Throw</Dropdown.Item>
                    <Dropdown.Item eventKey="No Modifier">No Modifer</Dropdown.Item>
                </DropdownButton>
                <DropdownButton id="roll_Condition" title = {rollCondition} onSelect={handleSelectRollCondition} style={{margin: "1rem 1rem 0.5rem 0.5rem" , width:"100%"}}>
                    <Dropdown.Item eventKey="Normal">Normal</Dropdown.Item>
                    <Dropdown.Item eventKey="Advantage">Advantage</Dropdown.Item>
                    <Dropdown.Item eventKey="Disadvantage">Disadvantage</Dropdown.Item>
                </DropdownButton>
            </ButtonGroup>
            <ButtonGroup>
                <DropdownButton id="roll_Ability" title = {rollAbility} onSelect={handleSelectRollAbility} style={{margin: "0.5rem 0.5rem 1rem 1rem"}}>
                    <Dropdown.Item eventKey="Strength">Strength</Dropdown.Item>
                    <Dropdown.Item eventKey="Dexterity">Dexterity</Dropdown.Item>
                    <Dropdown.Item eventKey="Constitution">Constitution</Dropdown.Item>
                    <Dropdown.Item eventKey="Intelligence">Intelligence</Dropdown.Item>
                    <Dropdown.Item eventKey="Wisdom">Wisdom</Dropdown.Item>
                    <Dropdown.Item eventKey="Charisma">Charisma</Dropdown.Item>
                </DropdownButton>
                <DropdownButton id="roll_Proficiency" title = {rollProficiency} onSelect={handleSelectRollProficiency} style={{margin: "0.5rem 1rem 1rem 0.5rem"}}>
                    <Dropdown.Item eventKey="No">No</Dropdown.Item> {/* +0 */}
                    <Dropdown.Item eventKey="Proficient">Proficient</Dropdown.Item> {/* +2 */}
                    <Dropdown.Item eventKey="Expertise">Expertise</Dropdown.Item> {/* +4 */}
                </DropdownButton>
            </ButtonGroup>
            <br></br>
            <text>Constitution Saving Throw: 13 (1d20) + 2 (proficent) + 2 (CON modifier) =</text> {/* Have this display values used for calculation */}
            <h2>17</h2>
            <Button style={{margin: "1rem", width: "80%", height: "5rem", fontSize: "2rem"}}>ROLL</Button> {/* Have this display the final calculated value */}
        </div>
    );
  };
  
  export default RollMenu;
  