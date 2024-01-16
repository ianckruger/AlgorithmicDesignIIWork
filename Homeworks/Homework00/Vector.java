package Homeworks.Homework00;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Written By Ian Kruger, 9-1-23, CSCE146
 */

public class Vector {
    private double[] array; // encapsulation
    private int length;

    Scanner keyboard = new Scanner(System.in);

    public Vector()
    {
        this.setVector();
    }

    public void setLength()
    {
        while(true)
        {
            try
            {
                System.out.println("\nHow long is this vector?: ");
                int length = keyboard.nextInt();
                this.length = length;
                break;
                
            }
            catch( InputMismatchException e)
            {
                System.out.println("Please only enter a number.");
                keyboard.next(); // Prevents an infite loop 
            }
        }
    }

    public int getLength()
    {
        return this.length;
    }

    public void setVector()
    {
        this.array = new double[this.length];
        for (int i = 0; i < this.length; i++) //cycles through vector length to fill the array up.
        {
            while(true)
            {
                try
                {
                    System.out.println("\nEnter a float for index "+i+" in the array.");
                    this.array[i] = keyboard.nextDouble();
                    keyboard.nextLine();
                    break;
                    
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Only enter a double/float.");
                    keyboard.next();
                }
            }
        }
    }
    public double[] getVector()
    {
        return this.array;
    }
}
