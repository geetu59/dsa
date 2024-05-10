package array.WindowSliding;

/*You are given an array and sum, find if there is any subarray with given sum
 * Naive sol: time: O(N*N) space: O(1)
 * Efficient sol: Window sliding technique with a window of variable size. time: O(N) space: O(1)*/
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        //Naive sol
        System.out.println(subArraySum(arr, 33));
        //Efficient sol
        System.out.println(subSum(arr, 33));
    }

    private static boolean subSum(int[] arr, int sum) {
        /*we will have windows of varying size, so we have start and end of window, we will keep incrementing end if curr < sum
         * and if it becomes greater than sum, then we will increment start, basically shrink window*/
        int start = 0, curr = 0;
        for (int end = 0; end < arr.length; end++) {
            curr += arr[end];
            while (curr > sum) {
                curr -= arr[start];
                start++;
            }
            if (sum == curr) return true;
        }
        return false;
        /*diff way to implement, logic is same
        int start = 0, end = 1, curr = arr[0];
        while (start < end) {
            if (curr < sum) {
                curr += arr[end];
                end++;
            } else if (curr == sum) {
                return true;
            } else {
                curr -= arr[start];
                start++;
            }
        }
        return false;*/
    }

    private static boolean subArraySum(int[] arr, int sum) {
        //consider ith element to be the first element of subarray and check all sub arrays starting with it, to see if
        //sum matches
        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                curr += arr[j];
                if (curr == sum) return true;
            }
        }
        return false;
    }
}
