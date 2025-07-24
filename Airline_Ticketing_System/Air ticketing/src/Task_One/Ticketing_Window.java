package Task_One;

import java.util.Scanner;

public class Ticketing_Window {

    // Main method to start the program
    public static void main(String[] args) {

        // Display the menu options to the user
        System.out.println("Menu:");
        System.out.println("View all windows : 100");
        System.out.println("View all empty windows : 101");
        System.out.println("Add passenger to a window : 102");
        System.out.println("Remove passenger from a window : 103");
        System.out.println("View passengers sorted : 104");
        System.out.println("Exit programme : 999");

        // Initialize all windows to "empty"
        initializeWindows();

        // Start the ticketing system
        runSystem(Window);
    }

    // Array to hold the names of passengers at each window
    static String[] Window = new String[6];


     //Displays the status of all windows, showing either the passenger's name or "empty".
    static void viewAllWindows(String[] Window) {
        for (int i = 0; i < Window.length; i++) {
            System.out.println("Window " + i + " : " + Window[i]);
        }
    }


    //Adds a passenger to a specified window
    static void addPassengers(Scanner input) {
        System.out.println("Enter window number (0-5): ");
        int windowNumber = input.nextInt();

        // Validate window number
        if (windowNumber < 0 || windowNumber >= Window.length) {
            System.out.println("Invalid window number!");
            return;
        }

        // Check if the window is already booked
        if (!Window[windowNumber].equals("empty")) {
            System.out.println("Window already booked");
            return;
        }

        // Get passenger details
        System.out.print("Enter passenger first name: ");
        String passengerFirstName = input.next();
        System.out.print("Enter passenger last name: ");
        String passengerLastName = input.next();

        // Add passenger to the specified window
        Window[windowNumber] = passengerFirstName + " " + passengerLastName;
        System.out.println("Passenger added to window " + windowNumber);
    }


     //Displays all currently empty windows.
    static void viewEmptyWindow(String[] Window) {
        for (int i = 0; i < Window.length; i++) {
            if (Window[i].equals("empty")) {
                System.out.println("Window " + i + " is empty");
            }
        }
    }


     //Sorts and displays the names of passengers in alphabetical order
    static void sortPassengers() {
        String[] sorted = new String[6];
        int count = 0;

        // Collect non-empty passenger names
        for (String passenger : Window) {
            if (!passenger.equals("empty")) {
                sorted[count++] = passenger;
            }
        }

        // Sort the collected passenger names using bubble sort
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (sorted[j].compareToIgnoreCase(sorted[j + 1]) > 0) {
                    String temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }

        // Display sorted passenger names
        System.out.println("Sorted Passengers:");
        for (int i = 0; i < count; i++) {
            System.out.println(sorted[i]);
        }
    }


     // Removes a passenger from a specified window
    static void removePassengers(Scanner input) {
        System.out.println("Enter window number to remove passenger (0-5):");
        int removeWindow = input.nextInt();

        // Validate window number
        if (removeWindow < 0 || removeWindow >= Window.length) {
            System.out.println("Invalid window number!");
        } else {
            // Set the window to "empty" to remove the passenger
            Window[removeWindow] = "empty";
            System.out.println("Passenger removed from window " + removeWindow);
        }
    }


     // Initializes all windows to "empty"
    static void initializeWindows() {
        for (int i = 0; i < Window.length; i++) {
            Window[i] = "empty";
        }
    }


     // Runs the main system loop, allowing user interaction
    static void runSystem(String[] Window) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println(" ");
            System.out.print("Enter number to get service: ");
            int number = input.nextInt();


            // Process user selection
            switch (number) {
                case 100:
                    viewAllWindows(Window);
                    break;
                case 101:
                    viewEmptyWindow(Window);
                    break;
                case 102:
                    addPassengers(input);
                    break;
                case 103:
                    removePassengers(input);
                    break;
                case 104:
                    sortPassengers();
                    break;
                case 999:
                    System.out.println("Exiting Program...");
                    return;
                default:
                    System.out.println("Invalid Selection.");
            }
        }
    }
}
