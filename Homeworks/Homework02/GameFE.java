package Homeworks.Homework02;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Written by Ian Kruger, CSCE 146
 */
public class GameFE {
    
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) // Main code function, cycles till user exits, and then terminates program when exited.
    {
        boolean active = true;
        GameManager gameManager = new GameManager(); // create an instance of a game manager to access and mutate linked lists.
        printGreeting();
        while (active)
        {
            boolean cont = SearchSystem(gameManager);// give the manager to the Search System.
            active = cont;

            // sets the returned boolean to the active variable to save a line of code
        }
        System.out.println("Goodbye!");
    }


    public static void printGreeting() // greets user
    {
        System.out.println("Welcome to the game inventory search.");
    }

    public static int menu() // creates a menu of choices for the user in a while loop to prevent infite terminal cycles
    {
        while (true) {
            try 
            {
                System.out.println("Enter 1 to load the video game database\r\n" +
                    "Enter 2 to search the database\r\n" +
                    "Enter 3 to print current results to the console\r\n" +
                    "Enter 4 to print current results to file\r\n" + 
                    "Enter 0 to quit");

                int choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume the newline character
                return choice;
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("Invalid input. Please enter a valid option (0-4).");
                keyboard.nextLine(); // Consume the invalid input
            }
        }
    }

    public static boolean SearchSystem(GameManager gameManager) { //Based on user input from menu, performs a variety of actions
        try {
            int choice = menu(); // call menu for choice
            if (choice == 0)
                return false; //exit loop
            else if (choice == 1) // Get file input from user to give basic inventory for searching --> turns file info into a linked list
            {
                System.out.println("Enter the file name.");
                String filename = keyboard.nextLine();
                gameManager.fileReader(filename);
                return true;
            } 
            else if (choice == 2) // Function to search the file linked list to create seperate linked list of searched games
            {
                System.out.println("Enter the game name");
                String gameName = keyboard.nextLine();
                System.out.println("Enter the console name");
                String consoleName = keyboard.nextLine();
                gameManager.userSearchRequest(gameName, consoleName);
                return true;
            } 
            else if (choice == 3) // prints the searched linked list
            {
                System.out.println("Printing Current Search Results.");
                gameManager.printSearchedLL();
                System.out.println("Done Printing");
                return true;
            } 
            else if (choice == 4) // Gets a file from the user to write the searched linked list games into.
            {
                System.out.println("Enter the file name to write to: ");
                String filename = keyboard.nextLine(); // Consume the newline character
                System.out.println("Would you like to append to the document? Enter 'true' if so, 'false' if not.");
                boolean append = Boolean.parseBoolean(keyboard.nextLine()); // Consume the newline character
                gameManager.fileWriter(filename, append);
                return true;
            }
            System.out.println("Please enter 1-4 next time. \n");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    

}
