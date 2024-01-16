package Homeworks.Homework07;
import java.util.Scanner;

public class SheepFE 
{
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Welcome!");
        boolean active = true;
        while(active)
        {
            runProgram();
            System.out.println("Would you like to run program again?(true/false)");
            active = keyboard.nextBoolean();
            keyboard.nextLine();
        }
        

    }

    public static void runProgram()
    {
        try
        {
            SchedulingSheep scheduler = new SchedulingSheep();
            System.out.println("Please enter a Sheep File: ");
            String fileName = keyboard.nextLine();
            scheduler.fileReader(fileName);
            boolean active = true;
            while(active)
            {
                if(scheduler.noMoreSheep())
                {
                    return;
                }
                scheduler.advanceOneMinute();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }


}
/*
 *if(heap.peek()!=null)
 */