import java.util.Random;
import java.util.Scanner;

/**
 * Hacker Terminal - beginner console project.
 * All "hacking" screens are pretend. Safe to run locally.
 */
public class HackerTerminal {

    // Demo login (not a real security system).
    static final String DEMO_USER = "operator";
    static final String DEMO_PASS = "access123";

    // Command history stored in a simple array (no ArrayList yet).
    static final int HISTORY_SIZE = 10;
    static String[] history = new String[HISTORY_SIZE];
    static int historyCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        bootSequence();

        boolean loggedIn = login(scanner);
        if (!loggedIn) {
            System.out.println();
            System.out.println(" ACCESS DENIED. Session locked.");
            System.out.println(" (Demo account is operator / access123)");
            scanner.close();
            return;
        }

        mainMenu(scanner, random);
        scanner.close();
        System.out.println();
        System.out.println(" [SESSION CLOSED]  Stay curious. Stay legal.");
    }

    // Feature 1: fake boot / loading animation
    public static void bootSequence() {
        TerminalArt.clearScreen();
        TerminalArt.printBanner();
        System.out.println();
        TerminalArt.typeLine(" > connecting to local simulator...", 18);
        TerminalArt.pause(250);
        TerminalArt.typeLine(" > loading kernel modules........ OK", 12);
        TerminalArt.pause(200);
        TerminalArt.progressBar("boot", 18);
        TerminalArt.typeLine(" > firewall: TRAINING MODE (no real network)", 12);
        TerminalArt.pause(400);
        System.out.println();
        System.out.println(" SYSTEM READY.");
        TerminalArt.pause(500);
    }

    // Feature 2: login with username and password
    public static boolean login(Scanner scanner) {
        TerminalArt.printBoxTitle("SECURE LOGIN  (demo)");
        System.out.println("  Hint: username = operator   password = access123");
        System.out.println();

        int attemptsLeft = 3;
        while (attemptsLeft > 0) {
            System.out.print("  USERNAME : ");
            String username = scanner.nextLine().trim();

            System.out.print("  PASSWORD : ");
            String password = scanner.nextLine().trim();

            // equals() compares the actual text
            if (username.equals(DEMO_USER) && password.equals(DEMO_PASS)) {
                System.out.println();
                TerminalArt.typeLine("  AUTH OK. Welcome, " + username + ".", 15);
                addHistory("LOGIN success");
                TerminalArt.pause(400);
                return true;
            }

            attemptsLeft--;
            System.out.println("  Invalid credentials. Attempts left: " + attemptsLeft);
            System.out.println();
        }
        addHistory("LOGIN failed");
        return false;
    }

    // Feature 3: main terminal menu
    public static void mainMenu(Scanner scanner, Random random) {
        boolean running = true;

        while (running) {
            TerminalArt.printMenu();
            String choiceText = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(choiceText);
            } catch (NumberFormatException e) {
                System.out.println("  Please type a number from 1 to 6.");
                pauseForEnter(scanner);
                continue;
            }

            switch (choice) {
                case 1:
                    addHistory("System Scan");
                    FakeModules.systemScan(random);
                    pauseForEnter(scanner);
                    break;
                case 2:
                    addHistory("Password Generator");
                    FakeModules.passwordGenerator(scanner, random);
                    pauseForEnter(scanner);
                    break;
                case 3:
                    addHistory("Fake IP Information");
                    FakeModules.fakeIpInfo(random);
                    pauseForEnter(scanner);
                    break;
                case 4:
                    addHistory("System Information");
                    FakeModules.systemInformation(random);
                    pauseForEnter(scanner);
                    break;
                case 5:
                    addHistory("View History");
                    showHistory();
                    pauseForEnter(scanner);
                    break;
                case 6:
                    addHistory("Exit");
                    running = false;
                    break;
                default:
                    System.out.println("  Unknown command. Choose 1-6.");
                    pauseForEnter(scanner);
                    break;
            }
        }
    }

    // Feature 8: keep the last HISTORY_SIZE commands
    public static void addHistory(String command) {
        if (historyCount < HISTORY_SIZE) {
            history[historyCount] = command;
            historyCount++;
            return;
        }

        // Array is full: shift everything left, drop the oldest item.
        for (int i = 0; i < HISTORY_SIZE - 1; i++) {
            history[i] = history[i + 1];
        }
        history[HISTORY_SIZE - 1] = command;
    }

    public static void showHistory() {
        TerminalArt.printBoxTitle("COMMAND HISTORY");
        if (historyCount == 0) {
            System.out.println("  (empty)");
            return;
        }

        for (int i = 0; i < historyCount; i++) {
            System.out.println("  " + (i + 1) + ". " + history[i]);
        }
        System.out.println();
        System.out.println("  Newest is at the bottom. Max " + HISTORY_SIZE + " entries.");
    }

    public static void pauseForEnter(Scanner scanner) {
        System.out.println();
        System.out.print("  Press ENTER to return to the menu...");
        scanner.nextLine();
    }
}
