[![CI](https://img.shields.io/github/workflow/status/ngutn24/RollBuddy/CI)](https://github.com/ngutn24/RollBuddy/actions/workflows/main.yml)

# RollBuddy
**Roll Buddy is a virtual Dungeons and Dragons character sheet service that does most of the management associated with a pen-and-paper character sheet for you. It allows users to enter in all the important information such as character stats, skills, and gear and then calculates the roll modifiers and bonuses that are used for various actions in the game. It also allows users to roll various dice in the app so that they do not need to bring physical dice in order to play.**

## Repository Layout
The service is split into 2 systems:

### Frontend
This is where the user facing code will be held:
- What the user will interact with
- How it is presented to them 


### Backend
This is code involving information and systems not directly shown to the user:

- User Account System
- Campaign Ruleset System


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

These build tasks will make sure all dependencies are done before performing 
the build process.

### Testing
Both frontend and backend have their own respective test tasks:
- `test_frontend`
- `test_backend`

But they can both be run with the `full_test` task

These test tasks will make sure everything is built first before running the test
suites

### Executing
Executing the systems of this service require different steps:

#### Frontend
1. The `build_frontend` task needs to be run, to create a static build
2. Running the `npm_start` task will run a local server 

#### Backend
1. The easiest way to run the backend server is to open up the project in IntelliJ
2. Press the green button next to the `main` method in `Session.java` and the backend server should run
![executionImage](readmeresources/backendexecution.png)

## Current Working Use Case
### Editing Sheet
Users can change the ability scores of their character and it will reflect across the rest of the system (i.e. dice rolls)

### Persistent Data
If a user refreshes their page or closes their page and reopens, their character data will still be there

### Rolling Dice
Users can do dice rolls which is affected by their character's current stats. They can specify which attribute to use for their dice roll