package array.WindowSliding;

import static java.lang.Math.max;

/* Find subarray with max sum for given window.
 * eg: {10,5,-2,20,1}, for k=3 23 is the max sum
 * Naive sol: O(n*k) time and O(1) space
 * Efficient sol: theta(n) time and O(1) space. We will use window sliding technique for this*/
public class SubArrayWithMaxSumInGivenWindow {
    public static void main(String[] args) {
        int arr[] = {10, 5, -2, 20, 1};
        //Naive
        System.out.println(maxSumSubArray(arr, 3));
        //Efficient
        System.out.println(maxSumSubArr(arr, 3));
    }

    private static int maxSumSubArr(int[] arr, int k) {
        int sum = 0;
        int res = 0;
        //find sum of first sub array
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        //accordingly keep on adding next element and removing first to check sum of sub arrays of size k which contains max sum
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            res = max(res, sum);
        }
        return res;
    }

    private static int maxSumSubArray(int[] arr, int k) {
        int res = Integer.MIN_VALUE; //becaz array contains negative value also, 0 won't suffice
        //traverse thru' each array value such that you have k element further to cal sum for
        for (int i = 0; i + k - 1 < arr.length; i++) {
            int curr = 0;
            //cal sum for next k elements for each i
            for (int j = 0; j < k; j++) {
                curr += arr[i + j];
            }
            //keep max sum here
            res = max(curr, res);
        }
        return res;
    }
}
