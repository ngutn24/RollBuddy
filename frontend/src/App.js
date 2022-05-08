import { ThemeProvider } from "react-bootstrap";
import Navigation from "./components/Navigation";
import CharacterSheet from "./components/CharacterSheet";
import "./App.css";

function App() {
  return (
    <ThemeProvider breakpoints={["lg", "md", "sm", "xs", "xxs"]}>
      <Navigation />
      <div className="Main-body">
        <CharacterSheet />
      </div>

      {/* FOOTER */}
      <footer id="sticky-footer" className="py-4 bg-dark text-white-50">
        <div className="container text-center">
          <small>Copyright &copy;2022 RollBuddy</small>
        </div>
      </footer>
    </ThemeProvider>
  );
}

export default App;
