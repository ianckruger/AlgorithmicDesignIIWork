package Homeworks.Homework02;

import java.util.Scanner;

/*
 * Written by Ian Kruger, CSCE146
 */
public class Game {
    
    private String name;
    private String console;
    private final String DELIM = "\\s+";

    public Game() // creates default instances of game node
    {
        this.name = "none";
        this.console = "none";
    }

    public Game(String aName, String aConsole) // initializes game node based on user input
    {
        this.setName(aName);
        this.setConsole(aConsole);
    }

    public void setName(String aName)
    {
        if (aName != null)
            this.name = aName;

        else
            this.name = "none";
    }

    public void setConsole(String aConsole)
    {
        if (aConsole != null)
            this.console = aConsole;

        else
            this.console = "none";
    }

    public String getName()
    {
        return this.name;
    }

    public String getConsole()
    {
        return this.console;
    }

    public String toString()
    {
        return "Name: "+this.name+" Console: "+this.console;
    }

    public boolean nameEquals(String aName) // Used to determine if the name enter by user for searching matches the game name
    {
        if(aName == null)
        {
            return false;
        }
        if (aName.equals("*")) // Returns true automatically if the user inputted a * to signify all games
        {
            return true;
        }
        String[] nameWords = split(this.name); // divide the game name into seperate words to check for all instances of the input
        String[] words = split(aName);
        for(int i = 0; i < nameWords.length; i++) // nested for loop to check each word in this game node, and each word in the user inputted word
        {
            for(int j=0;j<words.length;j++)
            {
                if(nameWords[i].equalsIgnoreCase(words[j]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean consoleEquals(String aConsole) // Same as the name equals function
    {
        if(aConsole == null)
        {
            return false;
        }
        if(aConsole.equals("*"))
        {
            return true;
        }
        String[] consoleWords = split(this.console);
        String[] words = split(aConsole);
        for(int i = 0; i < consoleWords.length; i++)
        {
            for(int j=0;j<words.length;j++)
            {
                if(consoleWords[i].equalsIgnoreCase(words[j]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public String[] split(String aLine) // seperate instance used to split a line up, for the game name in this object and in user inputted name
    {
        try
        {
            Scanner fileScanner = new Scanner(aLine);
            String fileLine = fileScanner.nextLine();

            String[] splitLine = fileLine.split(DELIM);
            fileScanner.close();
            return splitLine;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
