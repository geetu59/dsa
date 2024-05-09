package array.kadane;


import static java.lang.Math.max;
//KADANE'S ALGO
/*Find sub array with max sum. {1,2,3} => Subarrays: 1 2 3 12 23 123, sum=6. Array can have negative nos
* Naive sol: O(N*N) time and O(1) space
* Efficient sol: O(N) time and O(1) space. */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int arr[] = {-5, 1, 2, 3, -1, 2, -2};
        //Naive sol
        System.out.println(maxSum(arr));
        //Efficient sol
        System.out.println(maxSubArrSum(arr));
    }

    private static int maxSubArrSum(int[] arr) {
        //store final max in res
        int res=arr[0];
        //find max sum till now and store it in maxEndingSum
        int maxEndingSum=arr[0];
        //check the max sum till now + arr[i] is more or we've to start new sub array i.e. arr[i] is more
        for (int i = 1; i <arr.length; i++) {
            maxEndingSum = max(maxEndingSum + arr[i], arr[i]);
            res = max(res, maxEndingSum);
        }
        return res;
    }

    private static int maxSum(int[] arr) {
        //we cannot keep this 0 becaz, it is possible that all values in array are negative, so 0
        // will turn out to be max and that's wrong. If we've only 1 element that itself would be max, so keeping it as arr[0]
        int sum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                curr += arr[j];
                sum = max(curr, sum);
            }
        }
        return sum;
    }
}
