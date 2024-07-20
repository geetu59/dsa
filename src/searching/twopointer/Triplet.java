package searching.twopointer;

/*Find triplet in sorted array.
 * Naive sol: 3 loops, first < n-2, n-1, n and find sum and check if it is equal to x, return true else false. Time: O(N^3)
 * Efficient sol: Time: O(N^2) Use same approach as that of isPair, use for loop, sum-arr[i], consider this sum and then apply
 * two pointer/isPair approach. This will work for unsorted array also, becaz you'll first sort it in O(nlogn), O(nlogn) + O(n*n)
 * is O(n*n)*/
public class Triplet {
    public static void main(String[] args) {
        int arr[] = {2, 5, 10, 15, 18};
        //Efficient sol
        System.out.println(isTriple(arr, 33));
    }

    private static boolean isTriple(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (isPair(arr, x - arr[i], i + 1)) return true;
        }
        return false;
    }

    private static boolean isPair(int[] arr, int x, int i) {
        int low = i, high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum == x) return true;
            else if (sum > x) high--;
            else low++;
        }
        return false;
    }
}
