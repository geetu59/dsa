package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Works on sorted array
 * Time: log(N) Space: O(1)
 * If using recursion, log(N) time and space */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {10, 15, 20, 25, 50};
        //iterative
        System.out.println(search(arr, 15));
        //recursive
        System.out.println(searchRecursive(arr, 0, arr.length - 1, 15));
        //built-in
        System.out.println(Arrays.binarySearch(arr, 20));
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(4);
        integers.add(3);
        integers.add(2);
        System.out.println(Collections.binarySearch(integers, 20, Collections.reverseOrder()));
    }

    private static int searchRecursive(int[] arr, int low, int high, int x) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (x == arr[mid]) return mid;
        else if (x > arr[mid]) return searchRecursive(arr, mid + 1, high, x);
        else return searchRecursive(arr, low, mid - 1, x);
    }

    private static int search(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x > arr[mid]) {
                low = mid + 1;
            } else if (x == arr[mid]) return mid;
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
