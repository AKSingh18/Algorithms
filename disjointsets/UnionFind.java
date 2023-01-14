package disjointsets;

/*
A disjoint-set data structure maintains a collection {S1,S2,...Sk} of disjoint dynamic sets. We identify each set by
a representative, which is some member of the set.

We wish to support the following operations:

    1. Make-Set(x) creates a new set whose only member (and thus representative) is x.
    2. Union(x,y) unites the dynamic sets that contain x and y, say Sx and Sy , into a new set that is the union of
       these two sets
    3. Find-Set(x) returns a pointer to the representative of the (unique) set containing

TIME COMPLEXITY:
    n    = the total number of Make-Set operations
    f    = the total number of Find-Set operations
    m    = the total number of Make-Set, Union, and Find-Set operations
    α(n) = very slowly growing function, mostly α(n) <= 4

    Using only union by rank,                           O(m*(log n))
    Using only path compressions,                       O(n*f(1 + (log n)))
    Using both union by rank and path compression,      O(m*α(n))

SPACE COMPLEXITY: O(n) where n is total number of elements in all the sets
 */
public class UnionFind
{
    // path compression
    private static int findSet(int[] S, int x)
    {
        if (S[x] != x)                // if x.p != x:
            S[x] = findSet(S,S[x]);   //    x.p = Find-Set(x.p)
        return S[x];                  // return x.p
    }

    // union by rank
    private static void union(int[] S, int[] R, int x, int y)
    {
        link(S, R, findSet(S,x), findSet(S,y));
    }

    private static void link(int[] S, int[] R, int x, int y)
    {
        if (R[x] > R[y])                // if x.rank > y.rank:
            S[y] = x;                   //     y.p = x
        else                            // else:
        {
            S[x] = y;                   //     x.p = y
            if (R[x] == R[y])           //     if x.rank == y.rank
                R[y]++;                 //         y.rank = y.rank + 1
        }
    }
}
