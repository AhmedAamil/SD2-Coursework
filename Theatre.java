/* I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. Any code taken from other sources is referenced within my code solution.
Student ID / @author : 20211096 / W1953895 / Aamil Aliyar
Date: 20.03.2023
@version 2023-03-22 */

import java.util.*;  // Import Java Utility Package
import java.io.*;   // Importing I/O Package for file handling

public class Theatre {
    // Defining 3 arrays for each row
    static final int[] row1 = new int[12]; // For Row 1
    static final int[] row2 = new int[16]; // For Row 2
    static final int[] row3 = new int[20]; // For Row 3

    // Initializing variable to validate user I/O
    static int seatSelect;
    static int[] rowSelect;
    static int maxNum;
    static ArrayList<Ticket> tickets = new ArrayList<>(); // Creating an ArrayList of tickets to save all the Ticket information.

    public static void main(String[] args) {
        // Initialize all the seats to 0 using Array fill method (1 indicates an occupied (Sold) seat)
        Arrays.fill(row1, 0);
        Arrays.fill(row2, 0);
        Arrays.fill(row3, 0);

        boolean runProgram = true;
        while (runProgram) {
            Scanner input = new Scanner(System.in);  // Declaration of Scanner class
            System.out.println("\n'Welcome to the New Theatre'"); // Display Welcome message
            System.out.println("--------------------------------------------------------");
            System.out.println("Please Select an option (0-8):");
            System.out.println("""
                     \t1) Buy a Ticket
                     \t2) Print Seating Area
                     \t3) Cancel Ticket
                     \t4) List available seats
                     \t5) Save
                     \t6) Load
                     \t7) Print Ticket Information and Total Price
                     \t8) Sort Tickets by Price
                     \t\t0) Quit""");
            System.out.println("---------------------------------------------------------");

            // Initializing variable 'Option' to -1 for validation purposes
            byte option = -1;
            boolean valid = false;

            while (!valid) {
                System.out.print("Enter an Option: ");
                try {
                    option = Byte.parseByte(input.nextLine().trim());
                    if (option < 0 || option > 8) {
                        System.out.println("\nTry again. Select an option between 0 and 8.");
                    } else {
                        valid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input. Please enter a number between 0 and 8.");
                }
            }

            // Control Structure using Switch Cases to check users' Option
            switch (option) {
                case 1:
                    // Option 1: Buying a Ticket
                    System.out.println("You're going to buy a ticket");
                    buy_ticket();
                    break;
                case 2:
                    // Option 2: Printing Seating Area
                    System.out.println("Printing your seating area(s)");
                    print_seating_area();
                    break;
                case 3:
                    // Option 3: Canceling Ticket(s)
                    System.out.println("We are going to cancel your ticket");
                    cancel_ticket();
                    break;
                case 4:
                    // Option 4: Showing the list of Available Seats
                    System.out.println("Here's the list of available seats");
                    show_available();
                    break;
                case 5:
                    // Option 5: Saving the progress
                    System.out.println("Saving your tickets");
                    save();
                    break;
                case 6:
                    // Option 6: Loading the progress
                    System.out.println("Loading tickets");
                    load();
                    break;
                case 7:
                    // Option 7: Printing ticket information and total price
                    System.out.println("Print ticket information and total price option selected");
                    show_tickets_info();
                    break;
                case 8:
                    // Option 8: Sorting Tickets by price
                    System.out.println("Sort tickets by price option selected");
                    sort_tickets();
                    break;
                case 0:
                    // Option 9: Quiting the Theater program
                    System.out.println("Quitting the program...\n\"Thanks for Using the 'New Theatre' program\"");
                    runProgram = false;
                    System.exit(0);
                    break;
                default: // Default case # Extra Validation
                    System.out.println("Please try again. Select a valid option.");
                    break;
            }
            // Looping the Theater program to continue
            valid = false;
            while (!valid) {
                try {
                    System.out.print("\nDo you want to continue the Program (Y/N): ");
                    char response = input.nextLine().toUpperCase().charAt(0);
                    if (response == 'Y') {
                        System.out.println("\nRestarting the program");
                        break;
                    } else if (response == 'N') {
                        valid = true;
                        System.out.println("\nQuitting the program...\n\"Thanks for Using the 'New Theatre' Program\"");
                        System.exit(0);
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid option (Yes or No).");
                        continue;
                    }
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("\nPlease enter (Y/N) to continue.");
                }

            }
        }
    }

    public static void seat_validation (int[] rowInput){
        // Creating a Method to Validate ROW number (1-3) and SEAT number (1-20) # Optimizations
        Scanner input = new Scanner(System.in); // Declaration of Scanner class
        while (true) {
            System.out.print("Enter seat number (1-" + rowInput.length + "): ");
            while (!input.hasNextInt()){
                System.out.print("\nSorry, Try again. Enter seat number (1-" + rowInput.length + "):  ");
                input.next();
            }
            seatSelect = input.nextInt();
            rowSelect = rowInput;
            maxNum = rowInput.length;

            if (seatSelect < 1 || seatSelect > maxNum) {
                System.out.print("\nSorry, Incorrect seat. ");
                continue;
            } else {
                break; // Breaking the loop
            }
        }
    }
    public static void available_rows (int[] rowInput){
        // Creating a Method to show available seats using for loop # Optimizations
        for (int i = 0; i < rowInput.length; i++) {
            if (rowInput[i] == 0) {
                System.out.print("" + (i+1) + ", ");
            }
        }
        System.out.print("\b\b.");
        System.out.println(" ");
    }
    public static void buy_ticket() {
        // Creating a Method to Buy Ticket(s)
        Scanner input = new Scanner(System.in); // Declaration of Scanner class
        double price; // Initializing Price for the Ticket.

        // Asking for 'Person's Information (Task 13)
        System.out.print("\nEnter your First Name: ");
        String name = input.nextLine();

        System.out.print("Enter your Surname: ");
        String surName = input.nextLine();

        System.out.print("Enter your email: ");
        String email = input.nextLine();

        Person person = new Person(name, surName, email); // creating a Person object

        while (true) {
            // Input Row Number (1-3)
            System.out.print("Enter row number (01-03): ");

            while (!input.hasNextInt()){
                System.out.print("\nSorry, Try again. Enter row number (01-03):   ");
                input.next();
            }
            int row = input.nextInt();

            // Validating the row number and seat number
            if (row == 1) {
                price = 39.00;
                seat_validation(row1);
            } else if (row == 2) {
                price = 69.00;
                seat_validation(row2);
            } else if (row == 3) {
                price = 99.00;
                seat_validation(row3);
            } else {
                System.out.print("\nSorry, Incorrect Row number. ");
                continue;
            }
            // Checking whether the seat is available.
            boolean seatAvailable = false;
            while (!seatAvailable) {
                if (rowSelect[seatSelect - 1] == 1) {
                    System.out.println("\nSeat is not available, and already occupied.");
                    seat_validation(rowSelect);
                    continue;
                } else {
                    seatAvailable = true;
                    break; // Breaking the loop
                }
            }
            // Creating a new Ticket object and adding information to ticket ArrayList
            Ticket ticket = new Ticket(row,seatSelect,price, person);
            tickets.add(ticket);

            // Buying Ticket(s)
            rowSelect[seatSelect - 1] = 1;
            System.out.println("\nThanks for Buying the Ticket \n"+ "Seat: " + seatSelect + ", Row: " + row + ", Price: £" + price);
            break; // Breaking the loop
        }
    }
    public static void print_seating_area() {
        // Creating a Method to Print Seating Area with the character ‘O’ and the sold seats with ‘X’
        System.out.println("     ***********\n     *  STAGE  *\n     ***********");
        // Row 1
        System.out.printf("    ");
        for (int i = 0; i < row1.length; i++) {
            if (i == 6){
                System.out.print(" ");
            } if (row1[i] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();

        // Row 2
        System.out.printf("  ");
        for (int i = 0; i < row2.length; i++) {
            if (i == 8){
                System.out.print(" ");
            } if (row2[i] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();

        // Row 3
        for (int i = 0; i < row3.length; i++) {
            if (i == 10){
                System.out.print(" ");
            } if (row3[i] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
    }
    public static void cancel_ticket() {
        // Creating a Method to Cancel Ticket(s)
        Scanner input = new Scanner(System.in); // Declaration of Scanner class

        while (true) {
            // Input Row Number (1-3)
            System.out.print("Enter row number (01-03): ");
            while (!input.hasNextInt()){
                System.out.print("\nSorry, Try again. Enter row number (01-03):   ");
                input.next();
            }
            int row = input.nextInt();
            // Validating the row number and seat number
            if (row == 1) {
                seat_validation(row1);
            } else if (row == 2) {
                seat_validation(row2);
            } else if (row == 3) {
                seat_validation(row3);
            } else {
                System.out.println("\nSorry, Incorrect Row number");
                continue;
            }
            // Checking Seat that's not available.
            if (rowSelect[seatSelect - 1] == 0) {
                System.out.println("Seat is not occupied, It's already available; Cancellation Unsuccessful");
                return;
            }
            // Removing a Ticket Object from the ArrayList
            Iterator<Ticket> iterator = tickets.iterator();
            while (iterator.hasNext()) {
                Ticket ticket = iterator.next();
                if (ticket.getRow() == row && ticket.getSeat() == seatSelect) {
                    iterator.remove();
                }
            }
            // Cancelling Ticket(s)
            rowSelect[seatSelect - 1] = 0;
            System.out.println("We Cancelled your ticket \n"+ "Seat: " + seatSelect + ", Row: " + row);
            break; // Break the loop
        }
    }
    public static void show_available() {
        // Creating a Method to Show Available Seats
        // Printing 1st row
        System.out.print("Seats available in row 1: " );
        available_rows(row1);

        // Printing 2nd row
        System.out.print("Seats available in row 2: " );
        available_rows(row2);

        // Printing 3rd row
        System.out.print("Seats available in row 3: " );
        available_rows(row3);
    }
    public static void save() {
        // Creating a Method to Save the 3 arrays with the row’s information.
        try {
            FileWriter writer = new FileWriter("rows.txt");
            BufferedWriter file = new BufferedWriter(writer); // BufferedWriter provides efficient writing of single characters etc.
            // Row 01
            for (int i = 0; i < row1.length; i++) {
                file.write(row1[i] + "\t"+ "");
            }
            file.newLine();
            // Row 02
            for (int i = 0; i < row2.length; i++) {
                file.write(row2[i] + "\t"+ "");
            }
            file.newLine();
            // Row 03
            for (int i = 0; i < row3.length; i++) {
                file.write(row3[i] + "\t"+ "");
            }
            file.newLine();
            file.close(); // Closing the file
            System.out.println("Data has saved to a file.");
        }
        catch (IOException e){
            System.out.println("Sorry, An error occurred: " + e.getMessage());
        }
    }
    public static void load() {
        // Creating a Method for loading and restoring the 3 rows
        try {
            File file = new File("rows.txt");
            Scanner input = new Scanner(file); // Declaration of Scanner class

            // Row 01
            String line = input.nextLine();
            String[] parts = line.split("\t");
            for (int i = 0; i < parts.length; i++) {
                row1[i] = Integer.parseInt(parts[i]);
            }
            // Row 02
            line = input.nextLine();
            parts = line.split("\t");
            for (int i = 0; i < parts.length; i++) {
                row2[i] = Integer.parseInt(parts[i]);
            }
            // Row 03
            line = input.nextLine();
            parts = line.split("\t");
            for (int i = 0; i < parts.length; i++) {
                row3[i] = Integer.parseInt(parts[i]);
            }
            input.close(); // Close File
            System.out.println("Row Information has restored.");
        }
        catch (IOException e){
            System.out.println("Sorry, An error occurred: " + e.getMessage());
        }
    }
    public static void show_tickets_info(){
        // Creating a Method to show ticket information
        double total_cost = 0.0;
        System.out.println("\n--------------------Ticket Information--------------------");
        for (int i = 0; i < tickets.size();i++) {
            Ticket ticket = tickets.get(i);
            System.out.println("\nTicket " + (i+1) +  "-------------\n" + tickets.get(i).print());
            total_cost += ticket.getPrice();
        }
        System.out.println("\nTotal price of all the Tickets: £" + total_cost);
    }
    public static ArrayList<Ticket> sort_tickets(){
        // Crating a Method to sort tickets // Referred from Java T Point (https://www.javatpoint.com/bubble-sort-in-java)
        ArrayList<Ticket> sortedTickets = new ArrayList<>(tickets); // Creating a copy of the Original ArrayList
        int size = sortedTickets.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (sortedTickets.get(j).getPrice() > sortedTickets.get(j + 1).getPrice()) {
                    // If current element is greater than the next element, swap the adjacent element
                    Ticket tempTicket = sortedTickets.get(j);
                    sortedTickets.set(j, sortedTickets.get(j + 1));  // Swap the next element
                    sortedTickets.set(j + 1, tempTicket);
                }
            }
        }

        // Printing the sorted tickets list
        System.out.println("\n---------------------Sorted Ticket Information---------------------");
        double total_cost = 0.0;
        for (int i = 0; i < sortedTickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            System.out.println("\nTicket " + (i + 1) + "---------------\n" + sortedTickets.get(i).print());
            total_cost += ticket.getPrice();
        }
        System.out.println("\nTotal price of all the Tickets: £" + total_cost);

        return sortedTickets;
    }
}