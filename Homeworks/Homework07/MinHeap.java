package Homeworks.Homework07;

public class MinHeap <Sheep extends Comparable<Sheep>>
{

    private Sheep[] heap;
    public static final int DEF_SIZE = 60;
    private int lastIndex;

    public MinHeap()
    {
        init(DEF_SIZE);
    }

    public MinHeap(int size)
    {
        init(size);
    }

    public void init(int size)
    {
        if(size>0)
        {
            heap = (Sheep[])(new Comparable[size]);
            lastIndex = 0;
        }
        else
            init(DEF_SIZE);
    }

    public void add(Sheep data)
    {
        if(lastIndex >= heap.length)
            return;
        heap[lastIndex] = data;
        bubbleUp();
        lastIndex ++;

    }

    public Sheep remove()
    {
        if(lastIndex ==0)
            return null;    
        Sheep ret = heap[0];
        heap[0] = heap[lastIndex-1];
        heap[lastIndex-1]= null;
        lastIndex--;
        bubbleDown();
        return ret;
    }

    private void bubbleUp()
    {
        int index = lastIndex;
        while(index>0 && heap[(index-1)/2].compareTo(heap[index])>0)
        {
            Sheep temp = heap[(index-1)/2];
            heap[(index-1)/2] = heap[index];
            heap[index] = temp;
            index = (index-1)/2;
        }
    }

    private void bubbleDown()
    {
        int index = 0;
        while(index*2+1 < lastIndex)
        {
            int smallIndex = index*2+1;
            if(index*2+2 < lastIndex && heap[index*2+1].compareTo(heap[index*2+2])>0)
                smallIndex = index*2+2;
            if(heap[index].compareTo(heap[smallIndex])>0)
            {
                Sheep temp = heap[index];
                heap[index] = heap[smallIndex];
                heap[smallIndex] = temp;
            }
            else
                break;

            index = smallIndex;
        }
    }

    public Sheep isEmpty()
    {
        return heap[0];
    }

    public void printHeap()
    {
        for (int i=0;i<heap.length;i++)
        {
            System.out.println(heap[i]);
        }
    }

    public Sheep peek()
    {
        return heap[0];
    }
    
}
