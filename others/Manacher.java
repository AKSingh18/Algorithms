package others;

import java.util.Arrays;

/*
INPUT: String S

OUTPUT: Count of the number of palindromic substrings in S

REFERENCE: https://cp-algorithms.com/string/manacher.html

TIME COMPLEXITY: O(n) where n = |S|
SPACE COMPLEXITY: O(n)
 */
public class Manacher
{
    private int[] manacherOdd(String S)
    {
        int n = S.length();
        int[] p = new int[n+2];

        S = '#' + S + '^'; // to avoid dealing with end of string cases

        int l = 0, r = 1;
        for (int i = 1;i <= n;i++)
        {
            p[i] = Math.max(0, Math.min(r-i, p[l+(r-i)]));

            while (S.charAt(i-p[i]) == S.charAt(i+p[i]))
                p[i]++;

            if (i+p[i] > r)
            {
                l = i-p[i];
                r = i+p[i];
            }
        }

        return Arrays.copyOfRange(p,1,n+1);
    }

    private int countPalindromicSubstrings(String S)
    {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0;i < S.length();i++) sb.append(S.charAt(i)).append('#');

        int[] p = manacherOdd(sb.toString());

        int count = 0;
        for (int i = 1;i < sb.length();i+=2)
        {
            count += p[i]/2 + (p[i+1]-1)/2;
        }

        return count;
    }
}
