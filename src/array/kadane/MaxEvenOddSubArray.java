package array.kadane;

import static java.lang.Math.max;

/* KADANE'S ALGO
Find the subarray of max length which contains even odd numbers alternatively
* Eg: arr: {5,10,20,6,3,8} output: 3 {6,3,8}
* Naive sol: O(N*N) time and O(1) space complexity
Efficient sol: O(N) time and O(1) space*/
public class MaxEvenOddSubArray {
    public static void main(String[] args) {
        int arr[] = {5, 10, 20, 6, 3, 8};
        //Naive sol
        System.out.println(maxEvenOdd(arr));
        //Efficient sol
        System.out.println(maxEvenOddSubArr(arr));
    }

    private static int maxEvenOddSubArr(int[] arr) {
        //we traverse once and check prev element even and odd thingy, accordingly update the curr and store max in res
        // Kadane's algo
        //eg: 3 1 2 3 4 6 3 8
        int res = 1, curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0)
                    || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                curr++;
                res = max(res, curr);
            } else
                curr = 1;
        }
        return res;
    }

    private static int maxEvenOdd(int[] arr) {
        //we start from ith element and j is the one which goes from position i+1 to end, so we consider ith element as the starting element
        // then we check for even odd number and accordingly update curr and keep on checking if result stores max value only
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int curr = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0)
                        || (arr[j] % 2 != 0 && arr[j - 1] % 2 == 0))
                    curr++;
                else break;
            }
            res = max(res, curr);
        }
        return res;
    }
}
