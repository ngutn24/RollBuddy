# RollBuddy Frontend

## Run and Build

To run the live development server, build, run tests and install dependencies _without_ gradle, you will need to install Node.js which includes npm: [https://nodejs.org/en/download/](https://nodejs.org/en/download/).

> Note: all of the following commands must be ran from this folder, `frontend`.

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

## Components

The following is the component structure of the frontend, as well as their positions within the application.

![Component Diagram](/frontend/component-diagram.png)

- [App](./src/App.js): The root div, the initial entry point of components.
- [Navigation](./src/components/Navigation.js): Fixed navigation bar, contianing the project logo and links to various pages. Planned to contain user information when accounts and authentication are implemented.
- [CharacterSheet](./src/components/CharacterSheet.js): Contains all other character builder components, also contains API calls to initialize saved data from the backend to state which is passed as a prop to the appropriate components.
- [CharacterInfo](./src/components/CharacterInfo.js): Contains character information such as name, race, alignment, level, etc. Currently, this information is saved to local storage for persistence.
- [CharacterStatus](./src/components/CharacterStatus.js): Contains character attributes such as current and max HP, armor class and speed, as well as the calculated proficiency bonus and initiative. Currently, this information is saved to local storage for persistence.
- [AbilityList](./src/components/AbilityList.js): Simply a container to hold $n$ Abilities (see below). Changes to values in any ability will trigger an API call to update ability scores in the backend.
- [Ability](./src/components/Ability.js): This component corresponds to a single ability and its attributes: a modifier and score. Users can increment the score using the buttons.
- [MiscMenu](./src/components/MiscMenu.js): contains an inspiration modifier, as well as a simple success and failure counter. These values are persisted through local storage.
- [RollMenu](./src/components/RollMenu.js): handles simulating dice rolls, as intended by the user. The type of roll and various attributes are modified through the drop-downs, and the roll value is returned by an API call which uses the stored ability modifiers to add/subtract from the rolled dice as intended. Selected dropdown and textbox values are persisted through local storage.
- [TabMenu](./src/components/TabMenu.js): each tab corresponds to a different function, currently a proficiency tracker (with modifiers) and a textbox to track items. Once again, values are persisted through local storage.
