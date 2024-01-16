package Homeworks.Homework03;
/*
 * Written by Ian Kruger, CSCE146
 */
public class GenLL
{
    private class ListNode
    {
        Task data;
        ListNode next;
        ListNode prev;

        public ListNode(Task aData, ListNode aNext, ListNode aPrev)
        {
            this.data = aData;
            this.next = aNext;
            this.prev = aPrev; //uses a doubly linked list to easily search and remove data.
        }
    }
    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public GenLL()
    {
        head = current = previous = null;
    }

    public void add(Task aData)
    {
        ListNode newNode = new ListNode(aData, null,null);
        if(head== null)
        {
            head = current = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null)
            temp = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        current = newNode;
    }

    public void print()
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

    public Task getCurrent()
    {
        if (current == null)
            return null;
        return current.data;
    }

    public void goToNext()
    {
        if(current == null)
            return;
        previous = current;
        current = current.next;
    }

    public void reset() // since the guidelines of this homework call for the listnode to be reset everytime a file is inputted reset now resets the linked list
    {
        current = head = previous = null;
    }

    public boolean hasMore()
    {
        return current != null;
    }

    public boolean contains(Task aTask) // iterates through the list to check if the inputted data is in the list
    {
        if(head==null)
            return false;
        ListNode temp = head;
        while(temp != null)
        {
            if(temp.data.equalsThis(aTask))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public boolean remove(Task aTask) // removes the node based on the given data
    {
        if(head==null)
            return false;
        for(ListNode temp = head; temp != null;temp = temp.next)
        {
            if(temp.data.equalsThis(aTask))
            {
                if(temp == head)
                    {
                        head = temp.next;
                        return true;
                    }
                ListNode prev = temp.prev;
                ListNode next = temp.next;
                prev.next = next;
                if (next!= null)
                    next.prev = prev;
                return true;
            }
        }
        return false;
    }

    public void goToHead() // used instead of reset to go to the first node of the list
    {
        current = head;
        previous = null;
    }
    
}
