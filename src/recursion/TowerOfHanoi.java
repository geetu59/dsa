package recursion;

/*We've to move discs from tower A to C by using tower B as auxiliary tower in between.
 * For more understanding, watch GFG Recursion TOH video
 * Number of movements for given discs is:
 * 1 disc: 1, 2 discs: 3, 3 discs: 7 and hence 2^N-1
 * Time: O(2^N) and Space: O(N)*/
public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(4, 'A', 'B', 'C');
    }

    private static void towerOfHanoi(int n, char A, char B, char C) {
        //T(1)=1
        //if there is only 1 disc, then you have to directly move it from A to C
        if (n == 1) {
            System.out.println("Move disc 1 from " + A + " to " + C);
            return;
        }
        //2T(N-1) + 1 as we are making 2 recursive calls for n-1 so T(N)=2T(N-1)+1. Make a tree and understand series,
        //1+ 2+ 4+ 8+ .. + 2^(N-1), sum = 1*(2^N-1)/(2-1), we get 2^N-1
        //we move n-1 discs from A to B, keeping C as auxiliary
        towerOfHanoi(n - 1, A, C, B);
        //After first operation, we will be left with mth disc in A, hence move it from A to C
        System.out.println("Move disc " + n + " from " + A + " to " + C);
        //Now, (n-1) discs which were moved to B will be moved to C keeping A as auxiliary
        towerOfHanoi(n - 1, B, A, C);
    }

}
