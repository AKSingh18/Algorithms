package stringmatching;

import java.util.ArrayList;
import java.util.List;

/*
INPUT: text T, pattern P

OUTPUT: list of indices i such that T[i..m] = P[1..m] where m = |P|

TIME COMPLEXITY: O(n) where n = |T|, m = |P|
SPACE COMPLEXITY: O(m)
 */
public class KMP
{
    private static List<Integer> kmpMatcher(String T, String P)
    {
        final int n = T.length();
        final int m = P.length();
        final int[] r = computePrefixFunction(P);

        List<Integer> L = new ArrayList<>(n); // to store all the valid shifts

        int q = 0;  // number of characters matched

        for (int i = 0;i < n;i++)
        {
            while (q > 0 && P.charAt(q) != T.charAt(i))
            {
                q = r[q];
            }
            if (P.charAt(q) == T.charAt(i))
            {
                q = q+1;
            }
            if (q == m)
            {
                L.add(i-q+1);
                q = r[q];    // look for the next match
            }
        }

        return L;
    }

    private static int[] computePrefixFunction(String P)
    {
        final int m = P.length();
        final int[] r = new int[m+1];

        r[1] = 0;
        int k = 0;

        for (int q = 2; q <= m; q++)
        {
            while (k > 0 && P.charAt(k) != P.charAt(q-1))
            {
                k = r[k];
            }
            if (P.charAt(k) == P.charAt(q-1))
            {
                k = k + 1;
            }
            r[q] = k;
        }

        return r;
    }
}
