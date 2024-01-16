package Week6;

public class Tester {

    public static void main(String[] args)
    {
        StackI<Integer> stack;
        stack = new LLStack<Integer>();
        for(int i=0;i<10;i++)
            stack.push(i);
        stack.print();
        int val = stack.pop();
        int val2 = stack.pop();
        stack.print();
    }
    
}
