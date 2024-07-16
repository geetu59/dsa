package searching;

/*In binary search, we divide array into 2 parts, here we divide array into 3 parts to search for any element. Array should be sorted to perform this.
 * Time: O(logN to the base 3)*/
public class TernarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(searchRecursive(arr, 0, arr.length - 1, 11));
        System.out.println(searchIterative(arr, 6));
    }

    private static int searchIterative(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if (arr[mid1] == x) return mid1;
            else if (arr[mid2] == x) return mid2;
            else if (x < arr[mid1]) right = mid1 - 1;
            else if (x > arr[mid2]) left = mid2 + 1;
            else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }

    private static int searchRecursive(int[] arr, int left, int right, int x) {
        if (right >= left) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if (arr[mid1] == x) return mid1;
            else if (arr[mid2] == x) return mid2;
            else if (x < arr[mid1]) return searchRecursive(arr, left, mid1 - 1, x);
            else if (x > arr[mid2]) return searchRecursive(arr, mid2 + 1, right, x);
            else return searchRecursive(arr, mid1 + 1, mid2 - 1, x);
        }
        return -1;
    }
}
