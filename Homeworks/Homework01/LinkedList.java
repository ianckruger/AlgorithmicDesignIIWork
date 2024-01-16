package Homeworks.Homework01;
/*
 * Written by Ian Kruger, CSCE146
 */
public class LinkedList <T>
{
    private class ListNode
    {
        Prize data;
        ListNode link;

        public ListNode(Prize aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }
    private ListNode head;
    private ListNode current;
    private int size;
    public LinkedList()
    {
        head = current = null;
        this.size = 0;
    }

    public void add(Prize aData) // adds a node to the linked list
    {
        ListNode newNode = new ListNode(aData, null);
        if(head==null)
        {
            head = current = newNode;
            this.size = 1;
            return;
        }
        ListNode temp = head;
        while(temp.link != null)
            temp = temp.link;
        temp.link = newNode;
        this.size++;
    }
    public void print() // iterates through the linked list to print each name of the prize, but not the price to ensure the game isnt ruined
    {
        ListNode temp = head;
        while(temp != null)
        {
            String name = temp.data.getName();
            System.out.println(name);
            temp = temp.link;
        }
    }

    public void addAfterCurrent(Prize aData)
    {
        if(current == null)
            return;
        ListNode newNode = new ListNode(aData, current.link);
        current.link = newNode;
    }

    public Prize getCurrent()
    {
        if(current == null)
            return null;
        return current.data;
    }

    public void setCurrent(Prize aData)
    {
        if (aData == null || current == null)
            return;
        current.data = aData;
    }

    public void reset()
    {
        current = head = null;  
    }


    public int getSize()
    {
        return this.size;
    }

    public Prize getAt(int index) // gets the data at an index
    {
        if(index<0 || index >= size)
            return null;
        ListNode temp = head;
        for (int i=0;i<index;i++)
        {
            temp = temp.link;
        }
        return temp.data;
    }

    public void setAt(int index, Prize aData) // sets the data at an index
    {
        if (index<0 || index >= size || aData==null)
            return;
        ListNode temp = head;
        for(int i=0; i<index;i++)
        {
            temp = temp.link;
        }
        temp.data = aData;
    }

    public double getTotalPrice() // iterates through the linked list to get each prizes value for a total value calculation
    {
        double totalprice = 0.0;
        ListNode temp = head;
        while(temp != null)
        {
            //System.out.println("Added Prize: " + temp.data.getName() + ", Price: " + temp.data.getPrice()); used for debuggin
            double currprice = temp.data.getPrice();
            totalprice += currprice;
            temp = temp.link;
        }
        return totalprice;
    } 


}
