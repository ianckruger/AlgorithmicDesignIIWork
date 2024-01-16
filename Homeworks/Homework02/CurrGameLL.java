package Homeworks.Homework02;
/*
 * Written by Ian Kruger, CSCE 146
 */
public class CurrGameLL { // linked list used to store the searched games
    
    private class ListNode
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

        public CurrGameLL()
        {
            head = current = previous = null;
            size = 0;
        }

        public void addGamesToSearched(Game aData) // add to the current linked list
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
        
        public void printGameList() // iterate through the linked list to print all games, unless the head is null
        {
            if(head == null)
                System.out.println("No games found in recent search");
            ListNode temp = head;
            while(temp != null)
            {
                System.out.println(temp.data.getName()+"\t"+temp.data.getConsole()+"\n");
                temp = temp.next;
            }
            
        }

        public void reset() // reset the current linked list
        {
            previous = head = current = null;
        }

        public void goToFirst()
        {
            current = head;
            previous = null;
        }

        public boolean hasMore()
        {
            return current != null;
        }

        public void goToNext()
        {
            previous = current;
            current = current.next;
        }

        public Game getCurrent()
        {
            return current.data;
        }

        
    }

