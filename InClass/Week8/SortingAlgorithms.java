package Week8;

public class SortingAlgorithms 
{

    public static void main(String[] args)
    {
        int[] array = {10,8,7,6,12,5,11,9};
        quickSort(array);
        for(int i : array)
            System.out.println(i);
    }

    public static void mergeSort(int[] a)
    {
        int size = a.length;
        if(size<2)
            return;
        int mid = size/2;

        int leftSize = mid;
        int rightsize = size -mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightsize];

        for(int i=0;i<mid;i++)
            left[i] = a[i];
        for(int i=mid;i<size;i++)
            right[i-mid] =a[i];

        mergeSort(left);
        mergeSort(right);

        merge(left,right,a);
    }

    public static void merge(int[] left, int[] right, int[] a)
    {
        int leftSize = left.length;
        int rightSize = right.length;
        int i=0;//left index
        int j=0;//right index
        int k=0;//merge index

        while(i<leftSize&&j<rightSize)
        {
            if(left[i]<= right[j])
            {
                a[k] = left[i];
                i++;
                k++;
            }
            else
            {
                a[k] = right[j];
                j++;
                k++;
            }
        }
        while(i<leftSize)
        {
            a[k] = left[i];
            i++;
            k++;
        }
        while(j<rightSize)
        {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] a)
    {
        quickSort(a, 0, a.length-1);

        
    }

    public static void quickSort(int[] a, int start, int end)
    {
        if(start>+end)
            return;
        
        //pivot
        int pivot = partition(a, start, end);
        quickSort(a, start, pivot-1);
        quickSort(a, pivot+1, end);

    }
    public static int partition(int[] a, int start, int end)
    {
        int pivot = a[end];
        int i = start;
        for(int j=start;j<=end;j++)
        {
            if(a[j]<pivot)
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i];
        a[i] = a[end];
        a[end] = temp;
        return i;
    }
}
