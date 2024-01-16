package Week5.Queues;

public interface QueueI <T>
{
    public void enqueue(T data);
    public T dequeue();
    public T peek();
    public void print();
    
}
