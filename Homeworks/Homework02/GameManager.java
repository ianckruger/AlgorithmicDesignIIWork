package Homeworks.Homework02;
import java.io.*;
import java.util.Scanner;
/*
 * Written by Ian Kruger, CSCE 146
 */
public class GameManager 
{
    public static final String DELIM = "\t";
    public static final int BODY_FIELD_AMOUNT = 2;
    private static GameLL games;

    public GameManager()
    {
        games = new GameLL(); // create instance of the File Linked List for the manager, but not of the searched, as the searched linked list is derived from the original one
    }


    public void fileReader(String inputFile) // reads the file inputted from the user and converts it into various arrays of strings for searching
    {
        try
        {
            games.reset();
            Scanner fileScanner = new Scanner(new File(inputFile)); 
            while(fileScanner.hasNextLine())
            {
                String fileLine = fileScanner.nextLine();
                String[] splitLine = fileLine.split(DELIM);
                if (splitLine.length >= 2)
                {
                    String gameName = splitLine[0];
                    String consoleName = splitLine[1];
                    Game aGame = new Game(gameName, consoleName);
                    games.addGameFromFile(aGame);
                }
                
            }
        fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void fileWriter(String fileName, boolean append) // calls on file writed from the File linked list as it contains the searched linked list
    {
       games.fileWriter(fileName, append);
    }

    public void userSearchRequest(String gameName, String consoleName) // goes into the file linked list to search for specific games
    { 
        resetSearchedLL();
        games.searchForGameAndConsole(gameName, consoleName);
    }


    public static void resetfileLL() // calls to reset file LL
    {
        games.reset();
    }

    public void resetSearchedLL() // calls to reset the searched games LL
    {
        games.resetSearchedLL();
    }

    public void printSearchedLL()  // calls to print the searched games LL
    {
        games.printCurrent();
    }

}
