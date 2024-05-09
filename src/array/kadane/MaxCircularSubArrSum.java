package array.kadane;

import static java.lang.Math.max;

//KADANE'S ALGO
/*Find sub array with max sum. {1,2,3} => Sub arrays: 1 2 3 12 23 123, Circular subArrays: 231, 31, 321 sum=6. Array can have negative nos
 * Naive sol: O(N*N) time and O(1) space
 * Efficient sol: O(N) time and O(1) space. The idea behind this is, for normal sub arrays, use kadane's algo and for circular sub arrays,
 * calculate total sum and remove min sub array sum, it'll give you max sum. arr[] = {5, -2, -1, 3, 4}, sum=3,4,5, so you have to remove -3.
 * Total sum -2-1, will also give you result. To get (-2, -1), you have to use kadane's algo. You want to calculate min subarray sum so that
 * you can subtract it from total sum. For that, you can either use min instead of max in fn of Kadane's algo or you can reverse array, cal max and add
 * it to sum, it'll eventually be the same thing.*/
public class MaxCircularSubArrSum {
    public static void main(String[] args) {
        int arr[] = {5, -2, 3, 4};
        //Naive sol
        System.out.println(maxSum(arr));
        //Efficient sol
        System.out.println(maxSumCircularSubArr(arr));
    }

    private static int maxSumCircularSubArr(int[] arr) {
        //normal sub array sum using kadane's algo for all normal sub arrays
        int maxSumArr = maxSumSubArr(arr);
        //this condition is imp, arr:{-8,-3} maxSumArr: -3, if we remove this condition, it'll go ahead for circular sub arrays
        //there, sum=-11, arr: {-8,-3}  circularSum = -11 + 11 = 0
        if (maxSumArr < 0) return maxSumArr;
        int sum = 0;
        //calculating total sum and
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = -arr[i];
        }
        int circularSum = sum + maxSumSubArr(arr);
        return max(maxSumArr, circularSum);
    }

    //find max sub array sun of normal array using kadane's algo for non-circular sub array
    private static int maxSumSubArr(int arr[]) {
        int res = arr[0], maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = max(maxSum + arr[i], arr[i]);
            res = max(res, maxSum);
        }
        return res;
    }

    private static int maxSum(int[] arr) {
        int res = arr[0];
        //for each ith element, consider all elements in rotation and try to find max the way we do in naive sol for max sum sub arr
        //currSum stores current value of sum and currMax stores max sum when ith element is the first element and result stores
        //max of all currMax considered for each ith element being the starting one
        for (int i = 0; i < arr.length; i++) {
            int currSum = arr[i];
            int currMax = arr[i];
            for (int j = 1; j < arr.length; j++) {
                int index = (i + j) % arr.length;
                currSum += arr[index];
                currMax = max(currMax, currSum);
            }
            res = max(res, currMax);
        }
        return res;
    }
}
