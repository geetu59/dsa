package recursion;

/*You are given n and a,b,c where 0<a,b,c<=n. So you have to cut the rope into pieces with the combination of a,b,c and
 * return max pieces in which rope can be cut.
 * Eg: n=5, a=2,b=5,c=1, answer is 5. There are multiple combos possibles like (2+2+1), 5, (1+1+1+1+1) but last one can give us max pieces
 * Eg: n=5, a=2,b=4,c=6, answer is -1. Rope cannot be cut into pieces using any of a,b,c.
 * Time: O(3^N)
 * Check for GFG Recursion Rope Cutting video for better understanding*/
public class RopeCutting {
    public static void main(String[] args) {
        System.out.println(maxPieces(5, 2, 5, 1));
        //9,2,2,2
    }

    /*Approach: We have n length of rope, n can be further cut into either n-a, n-b, n-c, where further each of them can be cut into n-a, n-b, n-c
     * and so on. So time complexity is 3^N. If you take an eg and make a tree for the same, you'll see base cases as n is either 0 or negative, if
     * it is negative that means it cannot be cut into pieces using that combo completely. Else it'll see max out of all and return. Let's say there's
     * no combo possible and all of them returned -1, then check if res is -1 and return else add 1. We need to add one to the result becaz when we
     * make first recursive call, we are already making one cut, so add 1*/
    private static int maxPieces(int n, int a, int b, int c) {
        if (n == 0) return 0;
        if (n < 0) return -1;
        int res = Integer.max(maxPieces(n - a, a, b, c), Math.max(maxPieces(n - b, a, b, c), maxPieces(n - c, a, b, c)));
        if (res == -1) return -1;
        return res + 1;
    }
}
