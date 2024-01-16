package Week5.QueueGame;

public interface QueueI <T>
{
    public void enqueue(T data);
    public T dequeue();
    public T peek();
    public void print();
    public int size();
    
}
