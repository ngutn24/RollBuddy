import { useState, useEffect } from "react";
import { Tab, Tabs } from "react-bootstrap";
import border from '../assets/window_bg.png'

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

const TabMenu = () => {
    
    const [key, setKey] = useState('proficiencies');
    const [items, setItems] = useState([]);

    // TODO: add field for which data to get from the backend
    let skills = [
        { label: "Acrobatics", abilityType: "STR" }, 
        { label: "Animal Handling", abilityType: "WIS" }, 
        { label: "Arcana", abilityType: "INT" },
        { label: "Deception", abilityType: "CHA" },
        { label: "History", abilityType: "INT" },
        { label: "Insight", abilityType: "WIS" },
        { label: "Intimidation", abilityType: "CHA" },
        { label: "Investigation", abilityType: "INT" },
        { label: "Medicine", abilityType: "WIS" },
        { label: "Perception", abilityType: "WIS" },
        { label: "Performance", abilityType: "CHA" },
        { label: "Persuasion", abilityType: "CHA" },
        { label: "Religion", abilityType: "INT" },
        { label: "Slight of Hand", abilityType: "DEX" },
        { label: "Stealth", abilityType: "DEX" },
        { label: "Survival", abilityType: "WIS" }
      ]

    // load state from local storage
    useEffect(() => {
        const localtabInfo = JSON.parse(localStorage.getItem("tabInfo"));
        if (localtabInfo) {
            console.log("Loading tabInfo from storage... ", localtabInfo);
            setKey(localtabInfo.key);
            setItems(localtabInfo.items);
        }
    }, []);

    // store state to local storage
    useEffect(() => {
        const tabInfo = {
            key: key,
            items: items
        };
        localStorage.setItem("tabInfo", JSON.stringify(tabInfo));
    }, [key, items]);

    return (
        <div style={ComponentWindow}>
            <Tabs
                activeKey={key}
                onSelect={(k) => setKey(k)}
                className="mb-3"
                >
                <Tab eventKey="proficiencies" title="Proficiencies">
                    {skills.map((skill) => 
                        <div>
                            <label>{skill.label} ({skill.abilityType})</label>
                            <label>: +0</label> {/* TODO: replace with corresponding ability modifier */}
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