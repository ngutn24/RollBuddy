import './App.css';

const Character = (props) => {
    return (
        <>
            <h1>Name: {props.name}</h1>
            <h1>Strength: {props.strength}</h1>
            <h2>Dexterity: {props.dexterity}</h2>
            <h2>Constitution : {props.constitution}</h2>
            <h2>Intelligence : {props.intelligence}</h2>
            <h2>Wisdom : {props.wisdom}</h2>
            <h2>Charisma : {props.charisma}</h2>
        </>
    )
}


function App() {
    return (
        <div className="App">

            <Character name={"Arnazall"} strength={10} dexterity={15} constitution={5} intelligence={20} wisdom={25}
                       charisma={3}/>


        </div>
    );
}

export default App;
