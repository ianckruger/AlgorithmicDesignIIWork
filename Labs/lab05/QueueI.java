/*
 * Written by Ian Kruger
 */
public interface QueueI <T> // an interface for the LL to use
{
    public void enqueue(T data);
    public T dequeue();
    public T peek();
    public void print();  
}
