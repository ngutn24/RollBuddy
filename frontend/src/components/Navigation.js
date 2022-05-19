import {Navbar, Nav, Container} from "react-bootstrap";
import logo from "../assets/rollbuddy_logo.png";

const Navigation = () => {
    return (
        <Navbar bg="dark" sticky="top" variant="dark" expand="md">
            <Container fluid>
                <Navbar.Brand href="#home">
                    <img
                        src={logo}
                        height="40"
                        className="d-inline-block align-top"
                        alt="RollBuddy logo"
                        style={{filter: "invert(85%)"}}
                    />
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Home</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default Navigation;
