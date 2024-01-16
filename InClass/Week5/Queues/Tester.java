package Week5.Queues;

public class Tester {
    public static void main(String[] args)
    {
        QueueI<Integer> q;
        q = new LLQueue();
        for(int i=0;i<10;i++)
            q.enqueue(i);
        q.print();
        int val = q.dequeue();
        int val2 = q.dequeue();
        q.print();

    }
    
}
