import { render, screen } from "@testing-library/react";
import App from "./App";
import Logo from "./assets/rollbuddy_logo.png";

describe("Logo in NavBar", () => {
  test('App must contain logo that has src = "/rollbuddy_logo.png" and alt = "logo"', () => {
    render(<App />);
    const logo = screen.getByRole("img");
    expect(logo).toHaveAttribute("src", Logo, { exact: false });
    expect(logo).toHaveAttribute("alt", "RollBuddy logo");
  });
});
