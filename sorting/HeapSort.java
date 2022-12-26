package sorting;

/*
INPUT: A[]

OUTPUT: Sorts the array

TIME COMPLEXITY: O(n*log(n))
SPACE COMPLEXITY: O(1)
 */
public class HeapSort
{
    private static void swap(int[] A, int x, int y)
    {
        int t = A[x];
        A[x] = A[y];
        A[y] = t;
    }

    private static void maxHeapify(int[] H, int hs, int i)
    {
        int largest = i;

        if (2*i+1 < hs && H[largest] < H[2*i+1]) largest = 2*i+1;
        if (2*i+2 < hs && H[largest] < H[2*i+2]) largest = 2*i+2;

        if (largest != i)
        {
            swap(H, largest, i);
            maxHeapify(H, hs, largest);
        }
    }

    private static void buildMaxHeap(int[] A)
    {
        final int n = A.length;
        for (int i = n/2-1;i >= 0;i--) maxHeapify(A, n, i);
    }
    public static void sort(int[] A)
    {
        final int n = A.length;

        buildMaxHeap(A);

        for (int i = 0;i < n-1;i++)
        {
            swap(A, 0,n-i-1);
            maxHeapify(A, n-i-1, 0);
        }
    }
}
