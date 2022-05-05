import { render, screen } from "@testing-library/react";
import App from "./App";
import Logo from "./assets/rollbuddy_logo.png";
import Background from "./assets/rollbuddy_bg.png";

describe("App", () => {
  test('App must contain logo that has src = "/rollbuddy_logo.png" and alt = "logo"', () => {
    render(<App />);
    const logo = screen.getByRole("img");
    expect(logo).toHaveAttribute("src", "rollbuddy_logo.png", { exact: false });
    expect(logo).toHaveAttribute("alt", "logo");
  });
});
