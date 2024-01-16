package Homeworks.Homework00;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Written By Ian Kruger, 9-1-23, CSCE146
 */

public class main {

    static Scanner keyboard = new Scanner(System.in);

    public static int giveMenu()
    {
        while(true)
        {
            try
            {
                System.out.println("\nEnter \"1\". to add 2 vectors. \nEnter \"2\". to subtract 2 vectors. \nEnter \"3\". to get the Magnitude of a vector \nEnter \"4\". to exit the program.\n");
                int choice = keyboard.nextInt(); // Gets the next int entered to determine what the program does next
                return choice;
            }
            catch( InputMismatchException e)
            {
                System.out.println("Please only enter 1-4");
                keyboard.next(); // Prevents an infite loop (Learned the hard way)
            }
        }

    }

    public static void addVector()
    {
        System.out.println("Remember, Vectors must be the same length. \n Set Vector One: ");
        Vector v1 = new Vector();
        v1.setLength();
        v1.setVector();

        System.out.println("Set Vector 2: ");
        Vector v2 = new Vector();
        v2.setLength();
        v2.setVector();

        int length1 = v1.getLength();
        int length2 = v2.getLength();

        if (length1 == length2 && length1 >= 1)
        {
            System.out.println("\nResult: ");
            for (int i=0; i < length1; i++ ) // run through the index of each vector for vector addition
            {
                double[] temp1 = v1.getVector();
                double[] temp2 = v2.getVector();

                double j = temp1[i];
                double k = temp2[i];

                double end = j + k;
                System.out.println(end);
            }
        }

        else
        {
            System.out.println("Please enter two vectors, both greater than 0, and both of the same length. Try again!");
        }
    }

    public static void subtractVector()
    {
        System.out.println("Remember, Vectors must be the same length. \n Set Vector One: ");
        Vector v1 = new Vector();
        v1.setLength();
        v1.setVector();

        System.out.println("Set Vector 2: ");
        Vector v2 = new Vector();
        v2.setLength();
        v2.setVector();

        int length1 = v1.getLength();
        int length2 = v2.getLength();

        if (length1 == length2 && length1 >= 1) // Tests if the length of the vectors are equal and are greater than 0. Both must be true to work.
        {
            System.out.println("\nResult: ");
            for (int i=0; i < length1; i++ )
            {
                double[] temp1 = v1.getVector();
                double[] temp2 = v2.getVector();

                double j = temp1[i];
                double k = temp2[i];

                double end = j - k;
                System.out.println(end);
            }
        }
        else
        {
            System.out.println("Please enter two vectors, both greater than 0, and both of the same length. Try again!");
        }

    }

    public static void magnitudeVector()
    {
        System.out.println("Set Vector: ");
        Vector v1 = new Vector();
        v1.setLength();
        v1.setVector();


        int length1 = v1.getLength();

        if (length1 >= 1)
        {
            System.out.println("\nResult: ");
            double end = 0.00;
            for (int i=0; i < length1; i++ )
            {
                double[] temp1 = v1.getVector();

                double j = temp1[i];
                end += Math.pow(j,2.0);

            }
            end = Math.sqrt(end);
            System.out.println(end);
        }
        else
        {
            System.out.println("Please ensure that the vector is greater than 0. Try again!");
        }

    }
    
    public static void main(String[] args) //main command
    {
        int choice;
        do // loops until the user exits the program themselves. Does it once before it begins looping
        {
            choice = giveMenu();
            if (choice == 1)
            {
                addVector();
            }
            else if (choice ==2)
            {
                subtractVector();
            }
            else if (choice == 3)
            {
                magnitudeVector();
            }
            else if (choice == 4)
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            else
            {
                System.out.println("Only enter a number 1-4."); // re-inforces that only 1-4 are valid entries.
            }
        } while (choice != 4);
    }
}
