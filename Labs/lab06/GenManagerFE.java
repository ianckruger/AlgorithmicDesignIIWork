package Labs.lab06;
import java.util.Scanner;
/*
 * Written By Ian Kruger, CSCE 146
 */
public class GenManagerFE 
{
    public static Scanner keyboard = new Scanner(System.in);
    public static GenManager manager = new GenManager();
    
    public static void main(String[] args) // main argument that calls the below explained actions
    {
        greeting();
        boolean stop = false;
        while(!stop)
        {
            manager.resetList(); //resets the list each time
            getSentences();
            stop = goAgain();
        }
        System.out.println("Goodbye!");
    }

    public static void greeting() //prints the greeting
    {
        System.out.println("Enter any number of strings and I will sort by SORTs.  Once youre done entering sentences enter \"quit\".");
    }

    public static void getSentences() // gets the sentences from the user and enters them into the managers linked list
    {
        System.out.println("Start Entering Sentences: ");
        boolean stop = false;
        while(!stop)
        {
            String input = keyboard.nextLine();
            if(input.equalsIgnoreCase("quit"))
                stop = true;
            else
            {
                manager.addToList(input);
            }
        }
        manager.sortList(); //sort the list
        System.out.println("\n"); // print it out with a space to seperate
        manager.printList();
    }
    public static boolean goAgain() // determines if the user wants to go again
    {
        System.out.println("Would you like to sort more strings?(Enter \"false\" to stop.)");
        String again = keyboard.nextLine();
        if(again.equalsIgnoreCase("false"))
            return true;
        return false;
    }
}
;