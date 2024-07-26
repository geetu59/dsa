package searching;

/*Search an element in sorted rotated array.
 * Sol 1: Time: O(N) Run a for loop and check for each element if it's equal to x, return index
 * Sol 2: Time: O(logN) Space: O(1) Using binary search, check which half is sorted, then check if x lies in that half, if yes, go to that half else other half
 * Check GFG video if unclear*/
public class SortedRotatedArray {
    public static void main(String[] args) {
        int arr[] = {10, 20, 40, 60, 5, 8};
        //Sol 2
        System.out.println(search(arr, 5));
    }

    private static int search(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] >= arr[low]) { //left half is sorted
                if (arr[low] <= x && arr[mid] > x)
                    high = mid - 1; //check if our element lies in sorted/left half, then go to it else go to other one
                else low = mid + 1;
            } else { //right half is sorted
                if (arr[high] >= x && arr[mid] < x) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
