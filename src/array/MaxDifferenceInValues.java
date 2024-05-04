package array;

import static java.lang.Math.max;

/*Find max diff in values.
 * Naive: O(N*N) time O(1) space.
 * Efficient: O(N) time O(1) space. */
public class MaxDifferenceInValues {
    public static void main(String[] args) {
        int arr[] = {2, 3, 10, 6, 4, 8, 1};
        //Naive
        System.out.println(maxDiffernce(arr));
        //Efficient
        System.out.println(maximumDiff(arr));
    }

    private static int maximumDiff(int[] arr) {
        int result = arr[1] - arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            result = max(result, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return result;
    }

    private static int maxDiffernce(int[] arr) {
        int result = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                result = max(result, arr[j] - arr[i]);
            }
        }
        return result;
    }
}
