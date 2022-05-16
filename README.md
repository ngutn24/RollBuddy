[![CI](https://img.shields.io/github/workflow/status/ngutn24/RollBuddy/CI)](https://github.com/ngutn24/RollBuddy/actions/workflows/main.yml)

# RollBuddy
**Roll Buddy is a virtual Dungeons and Dragons character sheet service that does most of the management associated with a pen-and-paper character sheet for you. It allows users to enter in all the important information such as character stats, skills, and gear and then calculates the roll modifiers and bonuses that are used for various actions in the game. It also allows users to roll various dice in the app so that they do not need to bring physical dice in order to play.<br>
Compare to other existing DND character sheet services, RollBuddy is a much more straightforward service that helps you create your character quickly and get you rolling to play the game. Besides the essential functionality, the character's information is stored on the server like many other systems, so it is easier for the user to access it anywhere. **

## Software installation and set up

### IDE of your choice
To conviently edited, build and run the code, it is essential to have a IDE to handle those for you. There are a lot of choices, below are some suggestions. You could follow the download page instruction to install the corresponding version for your system:
##### Jetbrains IntelliJ (https://www.jetbrains.com/idea/download/#section=windows)
IntelliJ is one of the most powerful and popular Integrated Development Environments (IDE) for Java. 

##### Visual studio Code (https://code.visualstudio.com/)
Visual Studio Code is a code editor redefined and optimized for building and debugging modern web and cloud applications. Visual Studio Code is free and available on your favorite platform - Linux, macOS, and Windows.IntelliJ is one of the most powerful and popular Integrated Development Environments (IDE) for Java.

### JAVA JDK version 8 or above (https://adoptopenjdk.net/)
In order to run **Gradle** and execute **Java** code of RollBuddy system, it required at least **JAVA JDK version 8** or above. Follow the install instruction in the link.  

### Gradle version 7.1.1 or above (https://adoptopenjdk.net/)
**Gradle** will help you to install all other dependcy Rollbuddy required. You could install gradle with a package maneger or menually as it mention in the link.

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
1. Run the `run_backend` Gradle task to start the backend.

  _Alternatively_, you can run it in Inellij:
> Press the green button next to the `main` method in `Session.java` and the server will be executed:
![executionImage](readmeresources/backendexecution.png)

## Current Working Use Case
### Editing Sheet
Users can change the ability scores of their character and it will reflect across the rest of the system (i.e. dice rolls)

### Persistent Data
If a user refreshes their page or closes their page and reopens, their character data will still be there

### Rolling Dice
Users can do dice rolls which is affected by their character's current stats. They can specify which attribute to use for their dice roll
