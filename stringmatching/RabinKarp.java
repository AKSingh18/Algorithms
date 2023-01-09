package stringmatching;

import java.util.ArrayList;
import java.util.List;

/*
INPUT: text T, pattern P

OUTPUT: list of indices i such that T[i..m] = P[1..m] where m = |P|

TIME COMPLEXITY: O((n-m+1)m) where n = |T|, m = |P|
SPACE COMPLEXITY: O(m)
 */
public class RabinKarp
{
    private static List<Integer> rabinKarpMatcher(String T, String P, int d, int q)
    {
        final int n = T.length();
        final int m = P.length();

        List<Integer> L = new ArrayList<>(n);

        long h = hash(d,m-1,q); // calculates d^(m-1) mod q

        long p = 0;
        long t = 0;

        for (int i = 0;i < m;i++)
        {
            p = ((d*p)%q + P.charAt(i)%q) % q;
            t = ((d*t)%q + T.charAt(i)%q) % q;
        }

        for (int s = 0;s <= n-m;s++)
        {
            if (p == t)
            {
                int j;
                for (j = 0;j < m;j++)
                {
                    if (P.charAt(j) != T.charAt(s+j)) break;
                }

                if (j == m) L.add(s);
            }

            if (s < n-m)
            {
                t = ((d*(t - (h*T.charAt(s))%q)%q)%q + T.charAt(s+m)) % q;
                t = (t + q) % q;   // avoids -ve t
            }
        }

        return L;
    }

    private static long hash(int d, int p, int q)
    {
        long h = 1;
        for (int i = 0;i < p;i++) h = (h*d) % q;
        return h;
    }
}
