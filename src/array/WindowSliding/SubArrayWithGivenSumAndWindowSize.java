package array.WindowSliding;

/*Sub array with given sum and window size
 * Eg: {1, 4, 20, 3, 10, 5}, tell sub array of size 3, if it has sum=33
 * We will using window sliding technique*/
public class SubArrayWithGivenSumAndWindowSize {
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        //Efficient sol
        System.out.println(subSum(arr, 33, 3));
    }

    private static boolean subSum(int[] arr, int sum, int windowSize) {
        //calculate sum for first window
        int curr = 0;
        for (int i = 0; i < windowSize; i++) {
            curr += arr[i];
        }
        //remove element from beginning if curr>sum, add element at end if curr<sum
        int start = 0;
        while (start < arr.length) {
            if (curr < sum) curr = curr + arr[start + windowSize] - arr[start];
            else if (curr == sum) return true;
            else curr -= arr[start];
            start++;
        }
        return false;
    }
}
