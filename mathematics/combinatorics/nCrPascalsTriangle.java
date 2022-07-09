package mathematics.combinatorics;

/*
INPUT: N, R and M

OUTPUT: 2D matrix 'C' denoting nCr % M in the form C[n][r]

LOGIC:
The idea is to store the Pascal’s triangle in a matrix then the value of nCr will be the value of the
cell at nth row and rth column. To create the pascal triangle use these two formula:

    1. nC0 = 1
    2. nCr = n-1Cr-1 + n-1Cr

TIME COMPLEXITY: O(N*R)
SPACE COMPLEXITY: O(N*R)
*/
public class nCrPascalsTriangle
{
    private static long[][] buildPascalsTriangle(int N, int R, long M)
    {
        long[][] C = new long[N+1][R+1];

        C[0][0] = 1;
        for (int n = 1; n <= N; n++)
        {
            C[n][0] = 1;
            for (int r = 1;r <= R;r++)
            {
                C[n][r] = (C[n-1][r-1] + C[n-1][r])%M;
            }
        }

        return C;
    }
}
