package Labs.lab06;
/*
 * Written By Ian Kruger, CSCE 146
 */
public class GenManager 
{
    private GenLL<String> strings;


    public GenManager()
    {
        this.init();
    }

    private void init()
    {
        strings = new GenLL<String>();
    }


    public void addToList(String input) // adds to the list
    {
        int count = searchAndSort.linearSearchForSORT(input); // calls the seperate search and sort algorithm to search each word for a count value before adding to the list.
        strings.add(input,count);
    }

    // following commands call refernces to the Linked List
    public void sortList()
    {
        strings.quickSort();
    }

    public void printList()
    {
        strings.print();
    }

    public void resetList()
    {
        strings.reset();
    }


    
}
