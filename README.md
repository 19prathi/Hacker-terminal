# Hacker Terminal

A **beginner Java** console app that *looks* like a hacker terminal.

Everything is **fake / simulated**. It does not hack, scan other computers, or connect to real networks.

## What you will practice

- `Scanner` input
- variables, types, and `Integer.parseInt` conversion
- `if` / `switch` / loops
- methods
- arrays
- `Random`

## Folder structure

```
Hacker-Terminal/
├── README.md
├── .gitignore
└── src/
    ├── HackerTerminal.java   // start here: boot, login, menu
    ├── TerminalArt.java      // ASCII banners and delays
    └── FakeModules.java      // simulated tools
```

## How to run

1. Install Java (JDK 8 or newer).
2. Open a terminal in this folder.
3. Compile:

```bash
javac src/*.java
```

4. Run (from this folder):

```bash
java -cp src HackerTerminal
```

### Demo login

- Username: `operator`
- Password: `access123`

You get 3 attempts.

## Menu

1. System Scan (fake)
2. Random Password Generator
3. Fake IP Information
4. System Information
5. Command History
6. Exit
