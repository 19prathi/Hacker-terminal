/**
 * Prints ASCII art and small "hacker terminal" effects.
 * Uses only System.out, loops, and Thread.sleep.
 */
public class TerminalArt {

    // Short pause so loading text feels animated.
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // If sleep is interrupted, just continue the program.
        }
    }

    // Push old text off the screen without special libraries.
    public static void clearScreen() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    public static void printBanner() {
        System.out.println(" ============================================================");
        System.out.println(" ||                                                        ||");
        System.out.println(" ||    _   _    _    ____ _  _______ ____                  ||");
        System.out.println(" ||   | | | |  / \\  / ___| |/ / ____|  _ \\                 ||");
        System.out.println(" ||   | |_| | / _ \\| |   | ' /|  _| | |_) |                ||");
        System.out.println(" ||   |  _  |/ ___ \\ |___| . \\| |___|  _ <                 ||");
        System.out.println(" ||   |_| |_/_/   \\_\\____|_|\\_\\_____|_| \\_\\                ||");
        System.out.println(" ||                                                        ||");
        System.out.println(" ||              T E R M I N A L   v1.0                    ||");
        System.out.println(" ||         [ SIMULATION ONLY - NOT REAL HACKING ]         ||");
        System.out.println(" ||                                                        ||");
        System.out.println(" ============================================================");
    }

    public static void printBoxTitle(String title) {
        System.out.println();
        System.out.println(" +----------------------------------------------------------+");
        System.out.println(" |  " + padRight(title, 54) + "  |");
        System.out.println(" +----------------------------------------------------------+");
    }

    // Print one character at a time (typewriter effect).
    public static void typeLine(String text, int delayMs) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            pause(delayMs);
        }
        System.out.println();
    }

    // Fake progress bar using a loop and String concatenation.
    public static void progressBar(String label, int steps) {
        System.out.print(" " + label + " [");
        for (int i = 0; i < steps; i++) {
            System.out.print("#");
            pause(80);
        }
        System.out.println("] 100%");
    }

    public static void printMenu() {
        printBoxTitle("MAIN TERMINAL");
        System.out.println(" |  [1] System Scan          (simulated)                    |");
        System.out.println(" |  [2] Random Password Generator                           |");
        System.out.println(" |  [3] Fake IP Information                                 |");
        System.out.println(" |  [4] System Information                                  |");
        System.out.println(" |  [5] Command History                                     |");
        System.out.println(" |  [6] Exit                                                |");
        System.out.println(" +----------------------------------------------------------+");
        System.out.print(" operator@sim-terminal:~$ ");
    }

    // Helper: add spaces so titles line up inside the box.
    private static String padRight(String text, int length) {
        if (text.length() >= length) {
            return text.substring(0, length);
        }
        String result = text;
        while (result.length() < length) {
            result = result + " ";
        }
        return result;
    }
}
