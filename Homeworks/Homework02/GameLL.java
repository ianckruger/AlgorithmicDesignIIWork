package Homeworks.Homework02;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/*
 * Written by Ian Kruger, CSCE 146
 */
public class GameLL {

    private class ListNode //private list node class for the LL
    {
        Game data;
        ListNode next;

        public ListNode(Game aGame, ListNode aNext)
        {
            this.data = aGame;
            this.next = aNext;
        }
    }
    ListNode head;
    ListNode current;
    ListNode previous;
    int size;
    private CurrGameLL searchedGames; // creates instance of the searched games LL

    public GameLL() //initializing the searched games LL and the current nodes for this LL
    {
        head = current = previous = null;
        size = 0;
        searchedGames = new CurrGameLL();
    }

    public void addGameFromFile(Game aData) // Adds a game from the read file to this linked list
    {
        ListNode newNode = new ListNode(aData, null);
        if(head == null)
        {
            head = current = newNode;
            this.size = 1;
            return;
        }
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        this.size ++;
    }

    public void reset() // resets the linked list back to null
    {
        previous = head = current = null;
    }

    public void searchForGameAndConsole(String aName, String aConsole) // searches the current linked list for games inputted from user, adds them to a seperate linked list
    {
        ListNode temp = head;
        while(temp != null)
        {
            if(temp.data.nameEquals(aName) && temp.data.consoleEquals(aConsole))
            {
                searchedGames.addGamesToSearched(temp.data);
            }
            temp = temp.next;
        }
        searchedGames.printGameList();
    }

    public void printCurrent() // prints the Searched linked list 
    {
        searchedGames.printGameList();
    }

    public void resetSearchedLL() // resets the searched linked list 
    {
        searchedGames.reset();
    }

    public void fileWriter(String fileName, boolean append) // writes to a file based on the information in the searched linked list.
    // this function is used in here to avoid complication from the game manager not having direct access to the searched LL.
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName,append));
            searchedGames.goToFirst();
            while(searchedGames.hasMore())
            {
                Game currGame = searchedGames.getCurrent();
                fileWriter.println(currGame.getName()+"\t"+currGame.getConsole());
                searchedGames.goToNext();
            }
            fileWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    
}
