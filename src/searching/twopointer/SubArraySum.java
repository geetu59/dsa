package searching.twopointer;


import java.util.ArrayList;

/*There is an unsorted array of non - integers,  find a sub-array (continuous elements) that has sum equal to s. Return left and right indexes
 * Naive: Time: O(N*N)
 * Efficient: Time: O(N) Window Sliding Problem*/
public class SubArraySum {
    public static void main(String[] args) {
        int arr[] = {1, 0};
        //Naive
        System.out.println(subArraySum(arr, 12));
        //Efficient
        System.out.println(subarraySum(arr, 0));
    }

    private static ArrayList<Integer> subArraySum(int[] arr, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (sum < s) {
                    sum += arr[j];
                }
                if (sum == s) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return result;
    }

    private static ArrayList<Integer> subarraySum(int[] arr, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        int l = 0, r = 0, sum = 0;
        while (r < arr.length) {
            sum += arr[r];
            while (sum > s) {
                sum -= arr[l];
                l++;
            }
            if (sum == s && l <= r) {
                result.add(l + 1);
                result.add(r + 1);
                return result;
            }
            r++;
        }
        if (result.isEmpty()) result.add(-1);
        return result;
    }
}
