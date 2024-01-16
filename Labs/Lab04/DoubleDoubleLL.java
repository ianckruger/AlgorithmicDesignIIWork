package Labs.Lab04;
/*
 * Written by Ian Kruger
 */
public class DoubleDoubleLL  
{
    
    private class ListNode
    {
        double data;
        ListNode linkForward;
        ListNode linkPrev;//previous link
        public ListNode(double aData, ListNode aLinkF, ListNode aLinkB) //initializing the listnode
        {
            data = aData;
            linkForward = aLinkF;
            linkPrev = aLinkB;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public void gotoNext() // goes to the next node, bringing the previous node up with it
    {
        if (current == null)
        return;

        previous = current;
        current = current.linkForward;
    }

    public void gotoPrev() // goes to the previous node through thanks to the provided previous link
    {
        if (previous == null)
            return;
        current = previous;
        previous = previous.linkPrev;

    }

    public void reset() // resets the current pointer to the head
    {
        current = head;
        current.linkPrev = previous;
        previous = null;
    }

    public void gotoEnd() // goes to the end of the linked list
    {
        if(current == null)
            return;
        while(current.linkForward != null)
            current = current.linkForward;
    }

    public boolean hasMore() //returns a boolean based on how much more is left of the loop
    {
        return current != null;
    }
    

    public double getCurrent() // returns the data of the current node
    {
        if(current == null)
            return 0.0;
        return current.data;
    }

    public double getHead()
    {
        return head.data;
    }

    public void setCurrent(double aData) // sets the data of the current node
    {
        if(current==null || aData == 0.0)
            return;
        current.data = aData;
    }
    
    public void add(double aData) // adds a node to the end of the list
    {
        ListNode newNode = new ListNode(aData,null,null);
        if(head == null)
        {
            head = current = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.linkForward != null)
            temp = temp.linkForward;
        newNode.linkPrev = temp;
        temp.linkForward = newNode;
        current = newNode;
    }

    public void addAfterCurrent(double aData) // adds a node after the current node
    {
        if(current == null)
            return;
        
        ListNode newNode = new ListNode(aData,null,null);
        ListNode temp = current.linkForward;

        if (temp!= null)
            temp.linkPrev = newNode;
        
        newNode.linkForward = temp;
        newNode.linkPrev = current;
        current.linkForward = newNode;
    }
    
    public void remove(double aData) // removes the node based on the given data
    {
        if(head==null)
            return;
        for(ListNode temp = head; temp != null;temp = temp.linkForward)
        {
            if(temp.data ==aData)
            {
                if(temp == head)
                    {
                        head = temp.linkForward;
                        return;
                    }
                ListNode prev = temp.linkPrev;
                ListNode next = temp.linkForward;
                prev.linkForward = next;
                if (next!= null)
                    next.linkPrev = prev;
                return;
            }
        }
    }

    public void removeCurrent() // removes the current node
    {
        if(current==null)
            return;
        if(head == current)
        {
            head = head.linkForward;
            if (head != null) 
                head.linkPrev = null;
            current = head;
            return;
        }
        ListNode tempPrev = current.linkPrev; // ensures that the previous link is in tact when reseting the list
        ListNode tempNext = current.linkForward;
        if (tempPrev != null)
            tempPrev.linkForward = tempNext;
        if (tempNext != null)
            tempNext.linkPrev = tempPrev;
        current = tempNext;
        previous = tempPrev;

    }

    public void print() // iterates through the list and prints the data for each node
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.linkForward;
        }
    }

    public boolean contains(double aData) // iterates through the list to check if the inputted data is in the list
    {
        if(head==null)
            return false;
        ListNode temp = head;
        while(temp != null)
        {
            if(temp.data ==aData)
                return true;
            temp = temp.linkForward;
        }
        return false;
    }
}
