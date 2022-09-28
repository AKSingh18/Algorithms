package mathematics.numbertheory;

/*
INPUT: a and m

OUTPUT: x such that ax(mod m) = 1(mod m) or 'x' is the modular multiplicative inverse of 'a' under modulo 'm'
        x = -1 in case it does not exist

LOGIC:
    We can find two coefficients x and y using extended euclidean algorithm such that,
        ax + my = GCD(a,m)

    If a and m are co-prime or GCD(a,m) = 1 (modular multiplicative inverse will not exist if GCD(a,m) != 1),
        ax + my = 1

    Take modulo m on both sides,
        (ax + by)(mod m) = 1(mod m)
               ax(mod m) = 1(mod m)

    x is the required answer

TIME COMPLEXITY: O(h) where h = number of digits in min(a,b)
                              = log10(min(a,b))
SPACE COMPLEXITY: log10(min(a,b))
*/
public class ModularMultiplicativeInverseExtendedEuclideanAlgorithm
{
    private static int x, y;

    private static int gcd(int a, int b)
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

    public static int modInverse(int a, int m)
    {
        int G = gcd(a,m);
        return G != 1 || m == 1 ? -1 : (x+m)%m ;
    }
}
