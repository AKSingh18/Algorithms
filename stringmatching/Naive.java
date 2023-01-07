package stringmatching;

import java.util.ArrayList;
import java.util.List;

/*
INPUT: text T, pattern P

OUTPUT: list of indices i such that T[i..m] = P[1..m] where m = |P|

TIME COMPLEXITY: O((n-m+1)m) where n = |T|, m = |P|
SPACE COMPLEXITY: O(1)
 */
public class Naive
{
    private static List<Integer> naiveStringMatcher(String T, String P)
    {
        final int n = T.length();
        final int m = P.length();

        List<Integer> L = new ArrayList<>(n);

        int j;

        for (int s = 0;s <= n-m;s++)
        {
            for (j = 0;j < m;j++)
            {
                if (T.charAt(s+j) != P.charAt(j)) break;
            }
            if (j == m) L.add(s);  // match found
        }

        return L;
    }
}
