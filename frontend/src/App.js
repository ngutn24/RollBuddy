import { useState } from "react";
import {
  Modal,
  Button,
  Container,
  Row,
  Col,
  ThemeProvider,
} from "react-bootstrap";
import Navigation from "./components/Navigation";
import AbilityList from "./components/AbilityList";
import "./App.css";

function App() {
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  return (
    <ThemeProvider breakpoints={["lg", "md", "sm", "xs", "xxs"]}>
      <div className="Main-body">
        <Navigation />
        {/* container defaults to fluid=lg  */}
        <Container style={{ padding: "20px" }}>
          <Row>
            <Col>
              <Button style={{ width: "100%" }} onClick={handleShow}>
                Button #1
              </Button>
              <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                  <Modal.Title>Test Modal</Modal.Title>
                </Modal.Header>
                <Modal.Body>This is a test modal.</Modal.Body>
                <Modal.Footer>
                  <Button variant="secondary" onClick={handleClose}>
                    Close
                  </Button>
                </Modal.Footer>
              </Modal>
            </Col>
            <Col>
              <p>This is also part of a row.</p>
            </Col>
          </Row>
          <Row>
            <AbilityList />
          </Row>
        </Container>
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
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
