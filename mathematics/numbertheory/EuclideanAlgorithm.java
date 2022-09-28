package mathematics.numbertheory;

/*
INPUT: a and b

OUTPUT: GCD(a,b)

TIME COMPLEXITY: O(h) where h = number of digits in min(a,b)
                              = log10(min(a,b))
SPACE COMPLEXITY: log10(min(a,b))
*/

public class EuclideanAlgorithm
{
    public static int gcd(int a, int b)
    {
        if (a == 0) return b;
        return gcd(b%a, a);
    }
}
