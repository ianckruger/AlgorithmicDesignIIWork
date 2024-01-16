

import java.util.Scanner;
import java.io.*;

public class ShrekAnalyzer {
    
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Shrek Analyzed \n Enter a word and we will count the number of times it happens in the script.");
        String word = keyboard.nextLine();
        System.out.println("The word " +word+ " was found "+ lookForWord(word)+" times.");

    }
    public static int lookForWord(String word)
    {
        if (word == null)
        return 0;
        int ret = 0;
        try
        {
            Scanner fileScanner = new Scanner(new File("C:\\Users\\iankr\\OneDrive\\Desktop\\CSCE146\\Week3\\Shrek.txt"));
            while(fileScanner.hasNext())
            {
                String next = fileScanner.next();
                //if(next.equals(word))
                //if(next.equalsIgnoreCase(word))
                if(next.toUpperCase().contains(word.toUpperCase()))
                    ret++;
            }    
            fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
}
