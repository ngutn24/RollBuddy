import { React, useState } from "react";
import { Tab, Tabs } from "react-bootstrap";

var ComponentWindow = {
    display: "block",
    overflow: "auto",
    outline: "black solid 2px",
    borderRadius: "20px",
    backgroundColor: "white",
    margin: "1rem 1rem 1rem 1rem",
    padding: "1rem 1rem 1rem 1rem",
};

const TabMenu = () => {
    
    const [key, setKey] = useState('proficiencies');

    // TODO: add field for which data to get from the backend
    // Proficient field should have values 0 = no proficiency, 1 = proficient, 2 = expertise
    let skills = [
        { label: "Acrobatics", abilityType: "STR", proficient: 0 }, 
        { label: "Animal Handling", abilityType: "WIS", proficient: 0 }, 
        { label: "Arcana", abilityType: "INT", proficient: 0 },
        { label: "Deception", abilityType: "CHA", proficient: 0 },
        { label: "History", abilityType: "INT", proficient: 0 },
        { label: "Insight", abilityType: "WIS", proficient: 0 },
        { label: "Intimidation", abilityType: "CHA", proficient: 0 },
        { label: "Investigation", abilityType: "INT", proficient: 0 },
        { label: "Medicine", abilityType: "WIS", proficient: 0 },
        { label: "Perception", abilityType: "WIS", proficient: 0 },
        { label: "Performance", abilityType: "CHA", proficient: 0 },
        { label: "Persuasion", abilityType: "CHA", proficient: 0 },
        { label: "Religion", abilityType: "INT", proficient: 0 },
        { label: "Slight of Hand", abilityType: "DEX", proficient: 0 },
        { label: "Stealth", abilityType: "DEX", proficient: 0 },
        { label: "Survival", abilityType: "WIS", proficient: 0 }
      ]

    return (
        <div style={ComponentWindow}>
            <Tabs
                activeKey={key}
                onSelect={(k) => setKey(k)}
                className="mb-3"
                >
                <Tab eventKey="proficiencies" title="Proficiencies">
                    <label>P<span>&nbsp;&nbsp;</span>E</label>
                    {skills.map((skill) => 
                        <div>
                            <input type="checkbox"></input> {/* Proficient (+ proficiency bonus) checkbox */}
                            <input type="checkbox"></input> {/* Expertise (+ 2*proficiency bonus) checkbox */}
                            <label>{skill.label} ({skill.abilityType})</label>
                            <label></label> {/* Total modifier (corresponding ability modifier + proficiency/expertise bonus) */}
                        </div>
                    )}
                </Tab>
                <Tab eventKey="items" title="Items">
                    <textarea></textarea>
                </Tab>
            </Tabs>
        </div>
    );
};

export default TabMenu