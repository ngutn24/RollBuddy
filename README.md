[![CI](https://github.com/ngutn24/RollBuddy/actions/workflows/main.yml/badge.svg)](https://github.com/ngutn24/RollBuddy/actions/workflows/main.yml)
[![CD](https://github.com/ngutn24/RollBuddy/actions/workflows/cd.yml/badge.svg)](https://github.com/ngutn24/RollBuddy/actions/workflows/cd.yml)
[![pages-build-deployment](https://github.com/ngutn24/RollBuddy/actions/workflows/pages/pages-build-deployment/badge.svg)](https://github.com/ngutn24/RollBuddy/actions/workflows/pages/pages-build-deployment)

# RollBuddy User Manual

**RollBuddy is a virtual Dungeons and Dragons character sheet service that does most of the management associated with a pen-and-paper character sheet for you. It allows users to enter in all the important information such as character stats, skills, and gear and then calculates the roll modifiers and bonuses that are used for various actions in the game. It also allows users to roll various dice in the app so that they do not need to bring physical dice in order to play.**

**Compare to other existing DND character sheet services, RollBuddy is a much more straightforward service that helps you create your character quickly and get you rolling to play the game. Besides the essential functionality, the character's information is stored on the server like many other systems, so it is easier for the user to access it anywhere.**

## Software installation and set up

The service is being hosted on the [GitHub Pages](https://ngutn24.github.io/RollBuddy/)
of this repository, there is no need to set anything up to use this service.

If you would like to edit the code for this service and run it locally on your end, here are steps for setting it up:

### IDE of your choice

To conveniently edited, build and run the code, it is essential to have an IDE to handle those for you. There are a lot of choices, below are some suggestions. You could follow the download page instruction to install the corresponding version for your system:

- ##### Jetbrains IntelliJ (https://www.jetbrains.com/idea/download/#section=windows)

  IntelliJ is one of the most powerful and popular Integrated Development Environments (IDE) for Java.

- ##### Visual studio Code (https://code.visualstudio.com/)
  Visual Studio Code is a code editor redefined and optimized for building and debugging modern web and cloud applications. Visual Studio Code is free and available on your favorite platform - Linux, macOS, and Windows.

### JAVA JDK version 8 or above (https://adoptopenjdk.net/)

In order to run **Gradle** and execute **Java** code of RollBuddy system, it requires at least **JAVA JDK version 8** or above. Follow the instructions in the link.

### Gradle version 7.1.1 or above (https://gradle.org/install/)

**Gradle** will help you to install all other dependency Rollbuddy required. Running the `./gradlew` script for any task should install gradle. If not, you can install it yourself

- After install all the necessary software, run Gradle full_build either through IDE command line, `./gradlew full_build` or on the IntelliJ sidebar, and it will install the rest of the dependency library for the project.

## How to report a bug

**We use GitHub issues to track our bugs!**

To report a bug, visit the issues page on the repository and create an issue using the **Bug Report** template

## Known bugs

[Github Bug Issues](https://github.com/ngutn24/RollBuddy/issues?q=is%3Aopen+is%3Aissue+label%3Abug)

## Features

- [x] Editing Sheet: Users can change the ability scores of their character, and it will reflect across the rest of the system (i.e. dice rolls, ability modification).

- [x] Persistent Data: If a user refreshes their page or closes their page and reopens, their character data will still be there.

- [x] Rolling Dice: Users can do dice rolls which is affected by their character's current stats. They can specify which attribute to use for their dice roll.

- [ ] Database Support: Character Sheets can exist in a DB non-volatile storage, meaning if the character is still held, the character can be pulled form a database.

- [ ] Account System: Users can have their own accounts which tie them to all the character sheets they have created.

# Developer Manual

## Repository Layout

The service is split into 2 systems:

### Frontend

This is where the user facing code will be held:

- What the user will interact with
- How it is presented to them, each individual part elements is break into part in the components file

### Backend

This is code involving information and systems not directly shown to the user:

- User Account System
- Campaign Ruleset System

Documentation for these two systems can be found in their READMEs:

- [Backend](/Backend/README.md)
- [Frontend](/frontend/README.md)

## Building, Testing, and Executing

Rollbuddy uses **Gradle** to automate building, testing, and running the systems of
the platform

Each process of the workflow is handled by a gradle task(ex: `assemble`)

### Running gradle tasks

Gradle tasks can be executed by doing `./gradlew {task_name}`

### Building

Both frontend and backend have their own respective build tasks:

- `build_frontend`
- `build_backend`

But they can both be run with the `full_build` task

### Testing

Both frontend and backend have their own respective test tasks:

- `test_frontend`
- `test_backend`

But they can both be run with the `full_test` task

These test tasks will make sure everything is built first before running the test
suites

#### Adding to Backend

JUnit is used for testing backend code and is stored in `Backend/src/main/test/java`.
Adding new JUnit files in that directory will make sure those tests are run on the `test_backend` task

#### Adding to Frontend

All frontend code and resources can be found in the `frontend` folder. Note: if you are running any `npm` or `npx` commands, your current working directy must be the same `frontend` folder.

- Application code is found in `frontend/src`, with all components being contained in `frontend/src/components`.
- Assests such as logos and images are stored in `frontend/src/assets`.
- Tests are found alongside application code in `frontend/src` and `frontend/src/components`. For example, if you are writing tests for a JavaScript file named `Counter.js`, all tests covering that file should be in a file named `Counter.test.js` in the same directory.

For more information regarding frontend development, see the documentation [here](/frontend/README.md)

### Executing

Executing the systems of this service require different steps:

#### Frontend

1. The `build_frontend` task needs to be run, to create a static build
2. Running the `npm_start` task will run a local server

#### Backend

1. Run the `run_backend` Gradle task to start the backend.

_Alternatively_, you can run it in Intellij:

> Press the green button next to the `main` method in `Session.java` and the server will be executed:
> ![executionImage](readmeresources/backendexecution.png)
