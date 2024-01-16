package Week6;

public class ArrayStack<T> implements StackI<T> {
    private T[] stack;
    private int head; //first null element
    public static final int DEF_SIZE = 100;

    public ArrayStack()
    {
        init(DEF_SIZE);
    }
    public ArrayStack(int size)
    {
        init(size);
    }
    public void init(int size)
    {
        head = 0;
        if(size >= 1)
            stack = (T[])(new Object[size]);
        else
            stack = (T[])(new Object[DEF_SIZE]);
    }

    public void push(T aData)
    {
        if (head >= stack.length)
            return;
        stack[head] = aData;
        head++;
    }

    public T pop()
    {
        if(head == 0)
            return null;
        T ret = stack[head-1];
        head--;
        return ret;
    }

    public T peek()
    {
        if (head ==0)
            return null;
        return stack[head-1];
    }

    public void print()
    {
        for(int i = head-1;i>=0;i--)
            System.out.println(stack[i]);
    }

}
