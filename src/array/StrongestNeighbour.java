package array;
import static java.lang.Math.max;

/* find the maximum for every adjacent pairs in the array.
* arr[] = {1,2,2,3,4,5}
Output: 2 2 3 4 5
Explanation: Maximum of arr[0] and arr[1]
is 2, that of arr[1] and arr[2] is 2, ...
and so on. For last two elements, maximum
is 5.
* O(n) time and O(1) space
*/
public class StrongestNeighbour {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5};
        maximumAdjacent(arr);
    }

    static void maximumAdjacent(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(max(arr[i], arr[i + 1]) + " ");
        }
    }
}
