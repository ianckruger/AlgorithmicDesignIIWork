package Homeworks.Homework01;
import java.util.Scanner;
/*
 * Written by Ian Kruger, CSCE146
 */

public class PrizeManagerFE {
    
    private static Scanner keyboard = new Scanner(System.in);
    private static PrizeManager prizeManager = new PrizeManager(); // creates constant instance of a prize manager

    public static void main(String[] args)
    {
        boolean active = true;
        printGreeting();
        while (active)
        {
            playGame();
            active = playAgain(); // sets the returned boolean to the active variable to save a line of code
        }
        System.out.println("Goodbye!");
    }


    public static void printGreeting() // greets user
    {
        System.out.println("Welcome to the showcase show down!");
    }

    public static void playGame() // activates the actual showcase part of the game
    {
        try
        {
            String filename = "Homeworks\\Homework01\\prizeFile.txt";
            prizeManager.readPrizeFile(filename); // reads file to randomly choose 5 prizes
            System.out.println("Your prizes are: \n");
            prizeManager.printPrizes();
            System.out.print("You must guess the total cost of the prizes without going over and within $1,300 of its actual price \n Enter your guess\n");
            double useranswer = keyboard.nextDouble(); // gets users answer for prize cost
            double answer = prizeManager.getTotalPrices(); // calls on the prize manager to iterate through prizes and their cost
            System.out.println("The actual cost was "+answer);
            // start of if else logical statements to determine the users status in the game
            if(answer < useranswer)
                System.out.println("Your guess was over the amount. You lose");
            else if ((answer -1300)>useranswer)
                System.out.println("You guessed too low. You lose");
            else
                System.out.println("Congrats! You guessed within 1300 below the answer!");
            prizeManager.resetPrizeList();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static boolean playAgain() // function to ask the user if they want to continue
    {
        keyboard.nextLine();
        System.out.println("\nWould you like to quit? \n Put \'yes\' to quit."); // only requires the user to enter yes to quit, and not no to keep playing for less code
        String play = keyboard.nextLine();
        if(play.equalsIgnoreCase("yes"))// allows any variation of yes.
            return false; //returns a boolean for the while loop 
        else
            return true;
    }

}
