package mathematics.numbertheory;

/*
INPUT: a and b

OUTPUT: GCD(a,b) and coefficients x and y satisfying the equation ax + by = GCD(a,b)

TIME COMPLEXITY: O(h) where h = number of digits in min(a,b)
                              = log10(min(a,b))
SPACE COMPLEXITY: log10(min(a,b))
*/

public class ExtendedEuclideanAlgorithm
{
    public static int x, y;

    public static int gcd(int a, int b)
    {
        if (a == 0)
        {
            x = 0;
            y = 1;

            return b;
        }

        int x1, y1;
        int G = gcd(b%a, a);

        x1 = x;
        y1 = y;

        x = y1 - (b/a)*x1;
        y = x1;

        return G;
    }
}
