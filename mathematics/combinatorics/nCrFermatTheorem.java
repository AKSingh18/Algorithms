package mathematics.combinatorics;

/*
INPUT: n, r and p
CONSTRAINTS:
    1. p is prime
    2. n < p

OUTPUT: nCr % p

LOGIC:
    nCr = n! / (r! * (n-r!))
    nCr % p = [n! / (r! * (n-r)!)] % p
    nCr % p = [n! / (modInverse(r!) * modInverse((n-r)!))] % p      # Using fermat's little theorem

TIME COMPLEXITY: max(O(n), O(log2(p)))        # Pre-computation of factorials can reduce the complexity to O(1)
SPACE COMPLEXITY: O(n)
 */
public class nCrFermatTheorem
{
    private static long[] F; // F = factorial
    private static long[] I; // I = mod inverse of factorial

    private static void init(int n, long p)
    {
        F = new long[n+1];
        I = new long[n+1];

        F[0] = 1L;
        I[0] = 1L;

        for (int i = 1;i <= n;i++)
        {
            F[i] = (F[i-1]*i) % p;
            I[i] = modInverse(F[i], p);
        }
    }

    private static long power(long x, long y, long p)
    {
        if (y == 0) return 1;
        long R = 1;

        x = x % p;
        if (x == 0) return 0;

        while (y > 0)
        {
            // if x is odd
            if ((y&1) != 0) R = (R * x)%p;

            x = (x * x)%p;
            y = y >> 1; // y = y/2
        }

        return R;
    }

    private static long modInverse(long n, long p)
    {
        return power(n, p-2, p);
    }

    public static long nCr(int n, int r, long p)
    {
        // Pre-compute factorials. The F[] will only be computed once in case there are repetitive calls,
        // hence, saving time
        if (F == null) init(n, p);

        return ((F[n] * I[r])%p * I[n-r])%p;
    }
}
