package searching.twopointer;

/*Given a sorted array, find pair of elements whose sum is equal to given sum, if it is there then return true else false
 * Naive sol: O(N*N) time We fix one element and then loop at rest of elements and keep on checking if sum==given sum, if yes
 * then return true else false
 * Efficient sol: Two pointer approach. O(N) time, traverse the sorted array from left and right side. If a[left]+a[right]=given sum then return true
 * else if sum is greater than given sum that means we don't need bigger element and hence we most right to one place before, if sum is less, that means
 * we need bigger element, so left++*/
public class IsPair {
    public static void main(String[] args) {
        int arr[] = {2, 3, 8, 11};
        //Naive
        System.out.println(isPair(arr, 10));
        //Efficient
        System.out.println(isSumPresent(arr, 10));
    }

    private static boolean isSumPresent(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int calculatedSum = arr[left] + arr[right];
            if (calculatedSum == sum) return true;
            else if (calculatedSum > sum) right--;
            else left++;
        }
        return false;
    }

    private static boolean isPair(int[] arr, int sum) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i]+arr[j]==sum) return true;
            }
        }
        return false;
    }
}
