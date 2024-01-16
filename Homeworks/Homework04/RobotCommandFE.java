package Homeworks.Homework04;
import java.util.Scanner;

/*
 * Written by Ian Krugers
 */
public class RobotCommandFE 
{
    public static RobotCommandManager manager = new RobotCommandManager();
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) // main argument
    {
        System.out.println("Welcome to the robot board game!");
        boolean active = true;
        while(active) // a loop to keep the robot board going
        {
            manager.reset();
            boolean board = enterBoardFile(); // returns as booleans to ensure user does something besides press enter
            boolean robot = enterRobotFile();
            if(robot!=true||board!=true) // if user just presses enter
            {
                System.out.println("Please enter a filename.");
            }
            else
            {
                manager.moveRobot();
                active = playAgain();
            }
        }
    }

    public static boolean enterBoardFile() // prompts user to enter board file then runs it through the manager file reader
    {
        try
        {
            System.out.println("Enter file for the Board");
            String fileName = keyboard.nextLine();  
            if(fileName.isEmpty()) // if user just presses enter return false
                return false;

            else
            {
                manager.fileBoardReader(fileName);
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean enterRobotFile() // prompts user to enter robot file then runs it through the manager file reader
    {
        try
        {
            System.out.println("Enter file for the Robot Commands");
            String fileName = keyboard.nextLine();
            if(fileName.isEmpty()) // if user just presses enter return false
                return false;
            else
            {
                manager.fileRobotRead(fileName);
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean playAgain() // asks the user if they want to continue, and returns a boolean that is set to the active variable to continue
    {
        System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
        String item = keyboard.nextLine();
        if(item.equalsIgnoreCase("true"))
        {
            System.out.println("\nGoodbye!");
            return false;
        }
        return true;
    }
}
 