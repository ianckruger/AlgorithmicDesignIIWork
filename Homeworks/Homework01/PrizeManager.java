package Homeworks.Homework01;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
/*
 * Written by Ian Kruger CSCE146
 */

public class PrizeManager {

    public static final String DELIM = "\t";
    public static final int BODY_FIELD_AMT = 2;
    private LinkedList<Prize> prizes;

    public PrizeManager()
    {
        prizes = new LinkedList<Prize>();
    }

    public void addPrize(Prize aPrize)
    {
        prizes.add(aPrize);
        this.sortPrizes();
    }

    private void sortPrizes()
    {
        boolean swapped = true;
        while(swapped)
        {
            swapped=false;
            for(int i=0;i<prizes.getSize();i++)
            {
                if(prizes.getAt(i+1) == null)
                    break;
                if(prizes.getAt(i).getPrice() > prizes.getAt(i+1).getPrice())
                {
                    Prize temp = prizes.getAt(i);
                    prizes.setAt(i, prizes.getAt(i+1));
                    prizes.setAt(i+1,temp);
                    swapped = true;
                }
                
            }
        }
    }

    public void readPrizeFile(String aName) // function reads through the txt file list for prizes to make a list of
    {
        try
        {
            Set<Integer> randomLineNumbers = new HashSet<>(); // ensures there are no repeats
            Random random = new Random(); // to determine the prize line numbers
            int currentLine = 0;

            while (randomLineNumbers.size() < 5) { // chooses 5 random numbers from 1 to 53
                int randomLineNumber = random.nextInt(53) + 1;
                randomLineNumbers.add(randomLineNumber);

            }
            Scanner fileScanner = new Scanner(new File(aName));
            while(fileScanner.hasNextLine()) //iterates through the file
            {
                String fileLine = fileScanner.nextLine();
                currentLine++; //tracks what the file line number is
                if (randomLineNumbers.contains(currentLine)) // if the file line number is one of the 5 random variables add the prize data in
                {
                    String[] splitLines = fileLine.split(DELIM); // splits the string at the delim

                    if(splitLines.length == BODY_FIELD_AMT)
                    {
                        String name = splitLines[0];
                        double price = Double.parseDouble(splitLines[1]);
                        Prize aPrize = new Prize(name, price);
                        // System.out.println("Name: " + name + ", Price: " + price); used for debugging
                        this.addPrize(aPrize);
                    }
                }
                
            }
            this.sortPrizes(); // sorts them to avoid any mess
            fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void printPrizes() // prints all of the prizes
    {
        prizes.print();
    }

    public double getTotalPrices()
    {
        double cost = prizes.getTotalPrice();
        return cost;
    }
    
    public void resetPrizeList()
    {
        prizes.reset();
    }
}
