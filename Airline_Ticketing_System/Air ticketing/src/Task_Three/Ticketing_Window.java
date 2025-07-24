package Task_Three;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Represents the passengers variables
class Passenger {
    private String fName;
    private String lName;
    private String passportNumber;
    private String classOfPassenger;


    //Constructor to initialize passenger details
    public Passenger(String firstName, String lastName, String passportNumber, String classOfPassenger) {
        this.fName = firstName;
        this.lName = lastName;
        this.passportNumber = passportNumber;
        this.classOfPassenger = classOfPassenger;
    }


     //return Full name combining first(fname) and last name(lname)
    public String getFullName() {
        return fName + " " + lName;
    }


     //return Passenger's passport number
    public String getPassportNumber() {
        return passportNumber;
    }


    //return Passenger's travel class
    public String getClassOfPassenger() {
        return classOfPassenger;
    }
}


 //Manages the ticketing window operations and passenger data
class TicketingWindow {
    private List<Passenger> passengers;


     //Initializes the ticketing windows
    public TicketingWindow() {
        passengers = new ArrayList<>(6);
        // Initialize with 6 null values representing empty windows
        for (int i = 0; i < 6; i++) {
            passengers.add(null);
        }
    }


     //Displays the status of all windows
    public void viewAllWindows() {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i) == null) {
                System.out.println("Window " + i + ": empty");
            } else {
                Passenger passenger = passengers.get(i);
                System.out.println("Window " + i + ": (Name: " + passenger.getFullName() +
                        ", Passport Number: " + passenger.getPassportNumber() +
                        ", Class: " + passenger.getClassOfPassenger() + ")");
            }
        }
    }


     //Adds a passenger to a specific window
    public void addPassenger(int windowNumber, Passenger passenger) {
        if (windowNumber >= 0 && windowNumber < 6) {
            if (passengers.get(windowNumber) != null) {
                System.out.println("Window already booked");
            } else {
                passengers.set(windowNumber, passenger);
                System.out.println("Passenger added to window " + windowNumber + " successfully");
            }
        } else {
            System.out.println("Invalid window number!");
        }
    }


     //Displays all currently empty windows
    public void viewEmptyWindows() {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i) == null) {
                System.out.println("Window " + i + " is empty");
            }
        }
    }


     //Displays passengers sorted alphabetically by name
    public void sortPassengers() {
        List<Passenger> sortedPassengers = new ArrayList<>();
        // First collect all non-null passengers
        for (Passenger passenger : passengers) {
            if (passenger != null) {
                sortedPassengers.add(passenger);
            }
        }

        // Sort collected passengers by name
        sortedPassengers.sort((p1, p2) -> p1.getFullName().compareToIgnoreCase(p2.getFullName()));

        System.out.println("Sorted Passengers:");
        for (Passenger passenger : sortedPassengers) {
            System.out.println(passenger.getFullName());
        }
    }


     // Removes passenger from specified window
    public void removePassenger(int windowNumber) {
        if (windowNumber >= 0 && windowNumber < 6) {
            if (passengers.get(windowNumber) != null) {
                passengers.set(windowNumber, null);
                System.out.println("Passenger removed from window " + windowNumber + " successfully");
            } else {
                System.out.println("No passenger to remove from window " + windowNumber);
            }
        } else {
            System.out.println("Invalid window number!");
        }
    }
}



public class Ticketing_Window {

      //Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicketingWindow ticketingWindow = new TicketingWindow();

        // Display main menu
        System.out.println("Menu:");
        System.out.println("View all windows : 100");
        System.out.println("View all empty windows : 101");
        System.out.println("Add passenger to a window : 102");
        System.out.println("Remove passenger from a window : 103");
        System.out.println("View passengers sorted : 104");
        System.out.println("Exit programme : 999");

        // Main program loop
        while (true) {
            System.out.print("Enter the number to get service: ");
            int number = input.nextInt();

            // Process user selection
            switch (number) {
                case 100: // View all windows
                    ticketingWindow.viewAllWindows();
                    break;
                case 101: // View empty windows
                    ticketingWindow.viewEmptyWindows();
                    break;
                case 102: // Add passenger
                    System.out.print("Enter window number (0-5): ");
                    int windowNumber = input.nextInt();
                    input.nextLine(); // Consume newline
                    System.out.print("Enter passenger first name: ");
                    String firstName = input.nextLine();
                    System.out.print("Enter passenger last name: ");
                    String lastName = input.nextLine();
                    System.out.print("Enter passenger passport number: ");
                    String passportNumber = input.nextLine();
                    System.out.print("Enter passenger class (Economy/Business/First): ");
                    String classOfPassenger = input.nextLine();
                    Passenger passenger = new Passenger(firstName, lastName, passportNumber, classOfPassenger);
                    ticketingWindow.addPassenger(windowNumber, passenger);
                    break;
                case 103: // Remove passenger
                    System.out.print("Enter window number to remove passenger (0-5): ");
                    int removeWindow = input.nextInt();
                    ticketingWindow.removePassenger(removeWindow);
                    break;
                case 104: // Sort passengers
                    ticketingWindow.sortPassengers();
                    break;
                case 999: // Exit program
                    System.out.println("Exit Programme");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid Selection.");
            }
        }
    }
}
