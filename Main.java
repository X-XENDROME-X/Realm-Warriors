import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        char input;
        String line;
        String inputInfo;

        ArrayList<PlayerEntity> playerList = new ArrayList<>();

        try {
            System.out.println("Welcome to the battle stats simulator!");
            printMenu();

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);
                if (line.length() == 1) {
                    switch (input) {
                        case 'A':
                            System.out.println("Please enter your hero stats:");
                            inputInfo = stdin.readLine().trim();
                            PlayerEntity newPlayer = PlayerParser.parseNewPlayer(inputInfo);
                            playerList.add(newPlayer);

                            break;

                        case 'C':
                            System.out.println("Combat points computed");
                            for (int i = 0; i < playerList.size(); i++) {
                                playerList.get(i).computeCombatPower();
                            }
                            break;

                        case 'D':
                            System.out.print("Please enter a minimum combat points you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;

                            for (int i = 0; i < playerList.size(); i++) {
                                if (playerList.get(i).getCombatPoints() >= min) {
                                    count++;
                                }
                            }
                            System.out.println(
                                    "The number of heroes with " + min + " combat points or more is: " + count);
                            break;

                        case 'L':
                            if (playerList.size() <= 0)
                                System.out.print("No heroes in guild yet.\n");
                            else {
                                for (int i = 0; i < playerList.size(); i++) {
                                    System.out.print(playerList.get(i).toString());
                                }
                            }
                            break;

                        case 'Q':
                            break;

                        case '?':
                            printMenu();
                            break;

                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                } else
                    System.out.println("Unknown action");

            } while (input != 'Q');
            System.out.println("Thanks for playing!");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Hero\n" +
                "C\t\tCompute Combat Points\n" +
                "D\t\tCount Heroes with Minimum Combat Points\n" +
                "L\t\tList Heroes\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
