package Week4.LinkedListTest;

public class IntLL 
{
    private class ListNode
    {
        int data;
        ListNode link;
        public ListNode(int aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }
    private ListNode head; //first element
    private ListNode current; // current node of interest
    private ListNode previous; // one node behind current

    public IntLL()
    {
        head = current = previous = null;
    }

    public void add(int aData)
    {
        ListNode newNode = new ListNode(aData, null);
        if (head == null) // empty list
        {
            head = current = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.link != null)
        {
            temp = temp.link;
        }
        temp.link = newNode;
    }
    public void addAfterCurrent(int aData)
    {
        if(current == null)
            return;
        ListNode newNode = new ListNode(aData, current.link);
        current.link = newNode;
    }
    public void print()
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }
    public int getCurrent()
    {
        if(current == null)
            return 0;
        return current.data;
    }
    public void setCurrent(int aData)
    {
        if (current == null)
            return;
        current.data = aData;
    }
    public void goToNext()
    {
        if(current != null)
        {
            previous = current;
            current = current.link;
        }
    }
    public boolean hasMore()
    {
        return current != null;
    }
    public void reset()
    {
        current = head;
        previous = null;
    }
    public void removeCurrent()
    {
        if(current != null && previous != null)
        {
            previous.link = current.link;
            current = current.link;
        }
        else if(current != null && previous == null)
        {
            head = head.link; //current = current.link;
            current = head;

        }
    }
}
