package mathematics.numbertheory;

/*
INPUT: x, y and m

OUTPUT: (x^y) % m

TIME COMPLEXITY: O(log y)
SPACE COMPLEXITY: O(1)
 */
public class FastExponentiation
{
    private static long power(long x, long y, long m)
    {
        if (y == 0) return 1;
        long R = 1;

        x = x % m;
        if (x == 0) return 0;

        while (y > 0)
        {
            // if x is odd
            if ((y & 1) != 0) R = (R * x)%m;

            x = (x * x)%m;
            y = y >> 1; // y = y/2
        }

        return R;
    }
}
