package array;

import static java.lang.Math.max;

/*Given a binary array, print max times consecutive 1s occurred. Eg: {0,1,1,1,0,1,0,11}, output:3
 * Naive sol: O(N*N) time and O(1) space.
 * Efficient sol: theta(N) time and O(1) space
 */
public class Consecutive1s {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0, 1, 0, 1, 1};
        //Naive sol
        System.out.println(consecutive1s(arr));
        //Efficient sol
        System.out.println(consecutiveOnes(arr));
    }

    private static int consecutiveOnes(int[] arr) {
        //while traversing only, check for 1s, update count and res, if 0, then count=0 to start again
        int res = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
                res = max(res, count);
            }
        }
        return res;
    }

    private static int consecutive1s(int[] arr) {
        //for each value of i, check if it's 0 or 1, 0 then break, 1 then count all 1s and accordingly update res
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 1) {
                    curr++;
                    res = max(res, curr);
                } else break;
            }
        }
        return res;
    }
}
