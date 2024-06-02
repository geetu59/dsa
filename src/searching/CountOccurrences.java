package searching;

import static searching.FirstOccurrence.findFirstOcc;
import static searching.LastOccurrence.findLastOccurrence;

/*Find number of occurrences of x in sorted array.
 * Sol 1: Traverse thru the array and when arr[i]==x, then count++. Time: O(N)
 * Sol 2: Apply binary search and let's say your element is present at mid, then traverse thru both sides of it and find count.
 * Time: O(logn + k) where k is output/number of occurrences. Eg: a={5,5,5,5,5} for this, you have to traverse on both sides of mid to get count of 5 which will
 * eventually be O(N) only
 * Sol 3: For time complexity of strictly logn, we'll do binary search twice. So, we will find firstOccurrence and lastOccurrence(one of the codes) and
 * get the difference to get count.*/
public class CountOccurrences {
    public static void main(String[] args) {
        int arr[] = {5, 10, 10, 15, 20, 20, 20};
        //sol 2
        System.out.println(countOccurrences(arr, 20));
        //sol 3
        System.out.println(countOcc(arr, 20));
    }

    private static int countOcc(int[] arr, int x) {
        int first = findFirstOcc(arr, x);
        if (first == -1) return 0;
        else return findLastOccurrence(arr, x) - first + 1;
    }

    private static int countOccurrences(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                int count = 1;
                for (int i = mid + 1; i < arr.length; i++) {
                    if (arr[i] == x) count++;
                }
                for (int i = mid - 1; i >= 0; i--) {
                    if (arr[i] == x) count++;
                }
                return count;
            } else if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
