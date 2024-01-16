package Week10;

public class MinTester 
{
    public static void main(String[] args)    
    {
        MinHeap<Integer> iHeap = new MinHeap<Integer>();
        Integer[] iArray = {5,1,4,3,6,2};
        iHeap.heapSort(iArray);
        for(Integer i: iArray)
            System.out.println(i);
    }
}
