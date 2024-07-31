package searching;

/*Find index of first 1 in sorted binary array. eg: {0,0,0,1,1,1} ans is 3
 * Naive sol: Time O(N) Do linear search and get position
 * Efficient sol: Time(logn) Apply binary search*/
public class FirstOne {
    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 1, 1, 1};
        System.out.println(indexOfFirstOne(arr));
    }

    private static int indexOfFirstOne(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] != 1))
                return mid;
            else if (arr[mid] == 1)
                high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
