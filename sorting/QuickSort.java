package sorting;

/*
INPUT: A[]

OUTPUT: Sorts the array

TIME COMPLEXITY: O(n^2)                       # Mostly O(n*log(n))
SPACE COMPLEXITY: O(1)
 */
public class QuickSort
{
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static int partition(int[] A, int p, int r)
    {
        int x = A[r];
        int i = p-1;

        for (int j = p;j < r;j++)
        {
            if (A[j] <= x)
            {
                i++;
                swap(A,i,j);
            }
        }

        swap(A,i+1,r);
        return i+1;
    }

    private static int randomizedPartition(int[] A, int p, int r)
    {
        int i = (int)(Math.random()*(r-p+1)+p); // generate a random number between [p,r]
        swap(A,i,r);
        return partition(A,p,r);
    }

    public static void sort(int[] A, int p, int r)
    {
        if (p < r)
        {
            int q = randomizedPartition(A,p,r);
            sort(A,p,q-1);
            sort(A,q+1,r);
        }
    }

    public static void sort(int[] A)
    {
        sort(A,0,A.length-1);
    }
}
