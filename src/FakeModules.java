import java.util.Random;
import java.util.Scanner;

/**
 * Simulated tools only.
 * Nothing here contacts other computers or real networks.
 */
public class FakeModules {

    // System Scan: fake files and a loading bar.
    public static void systemScan(Random random) {
        TerminalArt.printBoxTitle("SYSTEM SCAN  //  SIMULATED");
        System.out.println(" |  Target : this training program (not a real network)     |");
        System.out.println(" +----------------------------------------------------------+");
        System.out.println();

        TerminalArt.typeLine(" > initializing dummy probe...", 12);
        TerminalArt.progressBar("scanning", 24);

        // Fake "found" items stored in an array.
        String[] fakeFinds = {
            "cache.tmp",
            "notes.txt",
            "config.bak",
            "photo.jpg",
            "homework.doc"
        };

        System.out.println();
        System.out.println("  SIMULATED RESULTS");
        System.out.println("  -----------------");
        for (int i = 0; i < fakeFinds.length; i++) {
            int fakeSize = 10 + random.nextInt(990);
            String status = random.nextBoolean() ? "OK" : "WATCH";
            System.out.println("  [" + (i + 1) + "] " + fakeFinds[i]
                    + "   size=" + fakeSize + "kb   flag=" + status);
            TerminalArt.pause(120);
        }

        int fakeScore = 70 + random.nextInt(30);
        System.out.println();
        System.out.println("  Threat index (made up): " + fakeScore + "/100");
        System.out.println("  Reminder: this is practice output, not a real scan.");
    }

    // Password generator: loops + char array + Random.
    public static void passwordGenerator(Scanner scanner, Random random) {
        TerminalArt.printBoxTitle("PASSWORD GENERATOR");
        System.out.println("  Characters used: A-Z  a-z  0-9  and a few symbols");
        System.out.print("  Enter length (4 to 20): ");

        String input = scanner.nextLine();
        int length;

        // Type conversion: String -> int
        try {
            length = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("  That was not a number. Using length 12.");
            length = 12;
        }

        if (length < 4) {
            length = 4;
            System.out.println("  Too short. Using 4.");
        }
        if (length > 20) {
            length = 20;
            System.out.println("  Too long. Using 20.");
        }

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%*?";
        String pool = letters + digits + symbols;

        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(pool.length());
            password[i] = pool.charAt(index);
        }

        System.out.println();
        System.out.print("  Generated: ");
        for (int i = 0; i < password.length; i++) {
            System.out.print(password[i]);
        }
        System.out.println();
        System.out.println("  Keep this private. It is only random text.");
    }

    // Fake IP: four random numbers 1-254, plus a city from an array.
    public static void fakeIpInfo(Random random) {
        TerminalArt.printBoxTitle("IP LOOKUP  //  COMPLETELY FAKE");

        int a = 1 + random.nextInt(254);
        int b = random.nextInt(256);
        int c = random.nextInt(256);
        int d = 1 + random.nextInt(254);
        String fakeIp = a + "." + b + "." + c + "." + d;

        String[] cities = {
            "Neo Tokyo",
            "Night City",
            "Port Pixel",
            "Lake Debug",
            "Mount Kernel"
        };
        String[] isps = {
            "ShadowNet Labs",
            "Packet Forest",
            "Null Route ISP",
            "Byte Harbor"
        };

        String city = cities[random.nextInt(cities.length)];
        String isp = isps[random.nextInt(isps.length)];

        System.out.println("  Address  : " + fakeIp);
        System.out.println("  Location : " + city + " (fictional)");
        System.out.println("  Provider : " + isp + " (fictional)");
        System.out.println("  Status   : SIMULATED / NOT A REAL LOOKUP");
        System.out.println();
        System.out.println("  These numbers were rolled with Random.");
        System.out.println("  They do not belong to anyone.");
    }

    // Mix of real local JVM facts and fake flavor text.
    public static void systemInformation(Random random) {
        TerminalArt.printBoxTitle("SYSTEM INFORMATION");

        String javaVersion = System.getProperty("java.version");
        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        String userName = System.getProperty("user.name");

        // Runtime memory is about THIS Java program, not other PCs.
        long freeMb = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long totalMb = Runtime.getRuntime().totalMemory() / (1024 * 1024);

        String[] cpuNames = {
            "Quantum Core (label only)",
            "Neon-9 Processor (label only)",
            "DummyChip 3000 (label only)"
        };

        System.out.println("  Operator alias : " + userName);
        System.out.println("  Host OS        : " + osName + " (" + osArch + ")");
        System.out.println("  Java version   : " + javaVersion);
        System.out.println("  JVM heap       : " + freeMb + " MB free / " + totalMb + " MB total");
        System.out.println("  CPU nickname   : " + cpuNames[random.nextInt(cpuNames.length)]);
        System.out.println();
        System.out.println("  OS/Java lines come from your own computer.");
        System.out.println("  CPU nickname is made up for the theme.");
    }
}
