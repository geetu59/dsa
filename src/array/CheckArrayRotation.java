package array;
/*check if this array is Sorted and Rotated counter-clockwise. Note that input array may be sorted in either increasing or decreasing order, then rotated.
A sorted array is not considered as sorted and rotated, i.e., there should be at least one rotation. O(N) time and O(1) space
Refer to GRG Array: Check if array is sorted and rotated PS*/
public class CheckArrayRotation {
    public static void main(String[] args) {
        //{1,2,3}
        int arr[] = {3, 4, 1, 2};
        System.out.println(checkRotatedAndSorted(arr, arr.length));
    }

    public static boolean checkRotatedAndSorted(int arr[], int num) {
        int rotate = 0;
        for (int i = 1; i < num; i++) {
            if (arr[i - 1] > arr[i]) {
                rotate++;
                if (rotate > 1) return false;
            }
        }
        return true;
    }
}
