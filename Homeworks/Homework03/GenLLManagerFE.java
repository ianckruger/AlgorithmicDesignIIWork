package Homeworks.Homework03;
import java.util.Scanner;
/*
 * Written by Ian Kruger, CSCE 146
 */
public class GenLLManagerFE 
{
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean active = true;
        GenLLManager genManager = new GenLLManager();
        System.out.println("Welcome to the Task Organizer");
        while(active)
        {
            printMenu(); //prints the menu
            int choice = keyboard.nextInt();
            keyboard.nextLine(); //absorbs the next line to avoid errors when calling the functions
            active = makeChoice(choice, genManager); //sets the users choice to the active loop boolean to keep the program running or not
        }
    }


    public static void printMenu()
    {
        System.out.println("Enter 1. To Add a Task\nEnter 2. To Remove a Task\nEnter 3. To Print Tasks To Console\nEnter 4. To Read from a Task File\nEnter 5. To Write to a Task File\nEnter 9. To Quit\n");
    }
    
    public static boolean makeChoice(int choice, GenLLManager genManager) // passes through the game manager to keep everything running
    {
        if (choice==9)
        {
            System.out.println("Goodbye.");
            return false;
        }
        else if (choice ==1)
        {
            genManager.addToTasks();
            return true;
        }
        else if (choice ==2)
        {
            genManager.removeTask();
            return true;
        }
        else if (choice ==3)
        {
            genManager.printLists();
            return true;
        }
        else if (choice ==4)
        {
            System.out.println("Please type out the name of the file you would like to read\n");
            String fileName = keyboard.nextLine();
            genManager.fileReader(fileName);
            return true;
        }
        else if (choice ==5)
        {
            System.out.println("Please type out the name of the file you would like to write to");
            String fileName = keyboard.nextLine();
            genManager.fileWriter(fileName);
            return true;
        }
        else
        {
            System.out.println("Please enter 1-5 or 9");
            return true;
        }
    }
    
}
