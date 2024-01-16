/*
 * Written by Ian Kruger
 */

public class LLQueue <T> implements QueueI<T>
{
    private class ListNode
    {
        ListNode next;
        T data;
        public ListNode(T aData, ListNode aLink)
        {
            data = aData;
            next = aLink;
        }
    }
    private ListNode head;
    private ListNode tail;
    private int size;

    public LLQueue() // initialize the queue 
    {
        head = tail = null;
    }


    public void enqueue(T aData) // serves as an "add" function
    {
        if(aData == null)
            return;
        ListNode newNode = new ListNode(aData, null);
        if (head==null)
        {
            head = tail = newNode;
            size += 1;
        }
        else
        {
            tail.next = newNode;
            tail = tail.next;
            size += 1;
        }
    }

    public T dequeue() // serves as a "remove" function
    {
        if(head==null)
            return null;
        T ret = head.data;
        head = head.next;
        size --;
        return ret;
    }

    public T peek() // shows the first element in queue
    {
        if(head==null)
            return null;
        return head.data;
    }

    public void print() // iterates through the list to print out the processes in queue
    {
        if(head!=null)
        {
            for(ListNode temp = head;temp!=null;temp = temp.next)
            {
                System.out.println(temp.data.toString());
            }
        }
        else
            System.out.println("None");
    }
}
