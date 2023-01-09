package stringmatching;

import java.util.ArrayList;
import java.util.List;

/*
INPUT: text T, pattern P

OUTPUT: list of indices i such that T[i..m] = P[1..m] where m = |P|

TIME COMPLEXITY: O(n + |Σ|m) where n = |T|, m = |P|, |Σ| = character set
SPACE COMPLEXITY: O(|Σ|m)
 */
public class StringMatchingAutomaton
{
    private static List<Integer> finiteAutomatonMatcher(String T, int[][] transition, int m)
    {
        final int n = T.length();
        List<Integer> L = new ArrayList<>(n);

        int q = 0; // start state

        for (int i = 0; i < n; i++)
        {
            q = transition[q][T.charAt(i)-'a'];
            if (q == m) L.add(i-m+1);
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

    private static int[][] computeTransitionFunction(String P, int characterSize)
    {
        final int m = P.length();
        int[][] transition = new int[m+1][characterSize];

        final int[] r = computePrefixFunction(P);

        for (int q = 0;q <= m;q++)
        {
            for (int a = 0;a < characterSize;a++)
            {
                if (q < m && P.charAt(q) == (char)('a'+a)) transition[q][a] = q+1;
                else transition[q][a] = transition[r[q]][a];
            }
        }

        return transition;
    }
}
