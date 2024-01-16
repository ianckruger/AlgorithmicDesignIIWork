package Week4.LinkedListTest;

public class IntLLTester 
{
    public static void main(String args[])
    {
        IntLL iLL;
        iLL = new IntLL();

        for(int i=4;i>=0;i--)
        {
            iLL.add(i);
        }
        iLL.print();
        iLL.addAfterCurrent(22);
        iLL.print();

        iLL.goToNext();
        iLL.addAfterCurrent(23);
        iLL.print();

        iLL.setCurrent(42);
        iLL.print();

        iLL.removeCurrent();
        iLL.print();
    }
}