package Week9;

public class BSTTester 
{
    public static void main(String[] args)
    {
        LinkedBST<Integer> iBST = new LinkedBST<Integer>();
        iBST.add(8);
        iBST.add(7);
        iBST.add(4);
        iBST.add(1);
        iBST.add(9);
        iBST.add(23);
        iBST.printPreorder();
        iBST.printInOrder();

        System.out.println(iBST.search(5));
        iBST.remove(4);
        iBST.printInOrder();
    }
}
