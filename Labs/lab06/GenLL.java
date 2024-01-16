package Labs.lab06;
/*
 * Written By Ian Kruger, CSCE 146
 */
public class GenLL<T>
{
    
    private class ListNode
    {
        T data;
        int count;
        ListNode nextForward;
        ListNode nextPrev;//previous next
        public ListNode(T aData, int aCount, ListNode anextF, ListNode anextB) //initializing the listnode
        {
            data = aData;
            count = aCount;
            nextForward = anextF;
            nextPrev = anextB;
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
        current = current.nextForward;
    }

    public void gotoPrev() // goes to the previous node through thanks to the provided previous next
    {
        if (previous == null)
            return;
        current = previous;
        previous = previous.nextPrev;

    }

    public void reset() // resets the list to be empty
    {
        current = head = previous = null;
    }

    public void gotoEnd() // goes to the end of the nexted list
    {
        if(current == null)
            return;
        while(current.nextForward != null)
            current = current.nextForward;
    }

    public boolean hasMore() //returns a boolean based on how much more is left of the loop
    {
        return current != null;
    }
    

    public T getCurrentData() // returns the data of the current node
    {
        if(current == null)
            return null;
        return current.data;
    }

    public int getCurrentCount()
    {
        return current.count;
    }

    public T getHeadData()
    {
        return head.data;
    }

    public void setCurrent(T aData) // sets the data of the current node
    {
        if(current==null || aData ==null)
            return;
        current.data = aData;
    }
    
    public void add(T aData, int aCount) // adds a node to the end of the list
    {
        ListNode newNode = new ListNode(aData,aCount,null,null);
        if(head == null)
        {
            head = current = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.nextForward != null)
            temp = temp.nextForward;
        newNode.nextPrev = temp;
        temp.nextForward = newNode;
        current = newNode;
    }

    public void addAfterCurrent(T aData, int aCount) // adds a node after the current node
    {
        if(current == null)
            return;
        
        ListNode newNode = new ListNode(aData,aCount,null,null);
        ListNode temp = current.nextForward;

        if (temp!= null)
            temp.nextPrev = newNode;
        
        newNode.nextForward = temp;
        newNode.nextPrev = current;
        current.nextForward = newNode;
    }
    
    public void remove(T aData) // removes the node based on the given data
    {
        if(head==null)
            return;
        for(ListNode temp = head; temp != null;temp = temp.nextForward)
        {
            if(temp.data ==aData)
            {
                if(temp == head)
                    {
                        head = temp.nextForward;
                        return;
                    }
                ListNode prev = temp.nextPrev;
                ListNode next = temp.nextForward;
                prev.nextForward = next;
                if (next!= null)
                    next.nextPrev = prev;
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
            head = head.nextForward;
            if (head != null) 
                head.nextPrev = null;
            current = head;
            return;
        }
        ListNode tempPrev = current.nextPrev; // ensures that the previous next is in tact when reseting the list
        ListNode tempNext = current.nextForward;
        if (tempPrev != null)
            tempPrev.nextForward = tempNext;
        if (tempNext != null)
            tempNext.nextPrev = tempPrev;
        current = tempNext;
        previous = tempPrev;

    }

    public void print() // iterates through the list and prints the data for each node
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.nextForward;
        }
    }

    public boolean contains(T aData) // iterates through the list to check if the inputted data is in the list
    {
        if(head==null)
            return false;
        ListNode temp = head;
        while(temp != null)
        {
            if(temp.data ==aData)
                return true;
            temp = temp.nextForward;
        }
        return false;
    }


    public void quickSort() {
        head = quickSort(head);
    }
    
    private ListNode quickSort(ListNode head) {
        if (head == null || head.nextForward == null) {
            return head;
        }
    
        ListNode pivot = partition(head);
        ListNode smaller = quickSort(pivot.nextPrev); // Recursively sort the smaller elements
        ListNode greater = quickSort(pivot.nextForward); // Recursively sort the greater elements
    
        if (smaller == null) {
            head = pivot;
        } else {
            head = smaller;
            getTail(smaller).nextForward = pivot;
            pivot.nextPrev = getTail(smaller);
        }
    
        if (greater != null) {
            pivot.nextForward = greater;
            greater.nextPrev = pivot;
        } else {
            pivot.nextForward = null;
        }
    
        return head;
    }
    
    
    public ListNode partition(ListNode head) {
        ListNode pivot = findPivot(head);
        ListNode smaller = null; // List for elements smaller than pivot
        ListNode greater = null; // List for elements greater than pivot
        ListNode current = head;
    
        while (current != null) {
            ListNode next = current.nextForward;
    
            if (current != pivot) {
                if (current.count <= pivot.count) {
                    if (smaller == null) {
                        smaller = current;
                        smaller.nextPrev = null;
                        smaller.nextForward = null;
                    } else {
                        current.nextForward = smaller;
                        smaller.nextPrev = current;
                        smaller = current;
                    }
                } else {
                    if (greater == null) {
                        greater = current;
                        greater.nextPrev = null;
                        greater.nextForward = null;
                    } else {
                        current.nextForward = greater;
                        greater.nextPrev = current;
                        greater = current;
                    }
                }
            }
    
            current = next;
        }
    
        if (smaller != null) {
            pivot.nextPrev = quickSort(smaller);
            smaller = getTail(smaller);
        } else {
            pivot.nextPrev = null;
        }
    
        if (greater != null) {
            pivot.nextForward = quickSort(greater);
        } else {
            pivot.nextForward = null;
        }
    
        return pivot;
    }
    
    private ListNode findPivot(ListNode head) // similar to "Go to end" but returns a listnode instead of changing currents position
    {
        ListNode temp = head;
        while (temp.nextForward != null) {
            temp = temp.nextForward;
        }
        return temp;
    }
    
    private ListNode getTail(ListNode head) 
    {
        if (head == null || head.nextForward == null) {
            return head;
        }
        while (head.nextForward != null) {
            head = head.nextForward;
        }
        return head;
    }
}