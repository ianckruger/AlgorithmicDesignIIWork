package Homeworks.Homework06;

import java.util.Scanner;

public class BSTFE 
{
    public static Scanner keyboard = new Scanner(System.in); 
    public static BSTManager manager = new BSTManager();

    public static void main(String[] args) // main argument
    {
        System.out.println("Welcome to the shape tree!");
        boolean active = true;
        while(active) // a loop to keep the robot board going
        {
            active = printChoices();
        }
        System.out.println("Goodbye!");
    }

    public static boolean printChoices()
    {
        try
        {
            System.out.println("Enter 1. To Read a Shape Tree from a File.\r\n" + //
                "Enter 2. To Print a Tree Traversal to the Console\r\n" + //
                "Enter 3. To Add a Shape.\r\n" + //
                "Enter 4. To Remove a Shape.\r\n" + //
                "Enter 5. To Search for a Shape.\r\n" + //
                "Enter 6. To Find the Shape with the Max Area.\r\n" + //
                "Enter 7. To Remove All Shapes Greater than an Area.\r\n" + //
                "Enter 8. To Print Shape Tree to File.\r\n" + //
                "Enter 0. To Quit.");
            int choice = keyboard.nextInt();
            if(choice ==0)
            {
                return false;
            }
            else if(choice ==1)
            {
                System.out.println("Enter a filename");
                keyboard.nextLine();
                
                String fileName = keyboard.nextLine();
                manager.fileReader(fileName);
                return true;
            }
            else if(choice ==2)
            {
                manager.print();
                return true;
            }
            else if(choice ==3)
            {
                manager.addShape();
                return true;
            }
            else if(choice ==4)
            {
                manager.remove();
                return true;
            }
            else if(choice ==5)
            {
                manager.search();
                return true;
            }
            else if(choice ==6)
            {
                manager.search();
                return true;
            }
            else if(choice ==7)
            {
                manager.removeGreaterThanArea();
                return true;
            }
            else if(choice ==8)
            {
                manager.printToFile();
                return true;
            }
            else
            {
                System.out.println("Enter a number 0-8 only");
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return true;
        }
    }
}
