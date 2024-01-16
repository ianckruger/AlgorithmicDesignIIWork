package Labs.Lab03;
/*
 * Written by Ian Kruger CSCE146
 */

public class GroceryList {
    
    private class ListNode // this creates a linked list for the grocery list so it can stay flexible and maintain adaptibility for any new or future groceries
    {
        GroceryItem data;
        ListNode next;
        public ListNode(GroceryItem aData, ListNode anext)
        {
            data = aData;
            next = anext;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public GroceryList() // initializes the list
    {
        head = current = previous = null;
    }

    public void gotoNext() //this function provides the ability to manuver throughout the list
    {
        if (current.next == null)
            return;
        
        previous = current;
        current = current.next;
    }

    public GroceryItem getCurrent() // this code gets the current item that the linked list is on
    {
        if (current != null)
            return current.data;
        return null;
    }

    public void setCurrent(GroceryItem aNode) // this code sets the current item to the given input node
    {
        if(aNode != null && current != null)
        {
            current.data = aNode;
        }
    }

    public void addItem(GroceryItem aItem) // this code allows the user to add a given item into the list, assumed to be the end of the list
    {
        if (aItem == null)
            return;
        ListNode newNode = new ListNode(aItem,null);
        if (head==null)
        {
            current = head = newNode;
            return;    
        }

        else
        {
            ListNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        
    }

    public void addItemAfterCurrent(GroceryItem aItem) // this function does the same thing as the above function but targets the current item instead 
    {
        if (aItem == null)
            return;
        ListNode newNode = new ListNode(aItem, null);
            if(current == null)
                current.data = aItem;
            else
            {
                if (current.next == null)
                    current.next = newNode;
                else
                {
                    ListNode temp = current.next;
                    newNode.next = temp;
                    current.next = newNode;
                }
            }
    }

    public void removeCurrent() // this function removes the current item of linked list
    {
        if(current == head)
        {
            head = current.next;
            current = head;
        }
        else
        {
            previous.next = current.next;
            current = current.next;
        }

    }

    public void showList() // this function shows the entire grocery list with all the given items
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public boolean contains(GroceryItem aItem) // this function searches the list for the inputted item to see if it is actually in the list
    {
        ListNode temp = head;
        while (temp != null)
        {
            if (temp.data.equals(aItem))
                return true;
            else
                temp = temp.next;
        }
        return false;
    }

    public double totalCost() // this function iterates through the list to determine the total cost of all the items in the list
    {
        if (head == null)
            return 0.0;
        
        ListNode temp = head;
        double total = 0.0;
        while (temp != null)
        {
            double tempPrice = temp.data.getPrice();
            total += tempPrice;
            temp = temp.next;
        }
        return total;
    }


}
