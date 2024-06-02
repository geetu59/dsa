package searching;

/*Find last occurrence of element x in sorted array.
 * Sol 1: Traverse from end and search for element, once found, return x. Time: O(N)
 * SOl 2: Use binary search and if x==arr[mid] then check arr[mid+1], if this is also same as x then update low with mid+1
 * becaz you need to consider that part now. Time: O(logn)*/
public class LastOccurrence {
    public static void main(String[] args) {
        int arr[] = {5, 10, 10, 15, 20, 20, 20};
        //recursive
        System.out.println(lastOccurrence(arr, 0, 6, 20));
        //iterative
        System.out.println(findLastOccurrence(arr, 20));
    }

    static int findLastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                if (mid == arr.length - 1 || arr[mid + 1] != x)
                    return mid;
                else
                    low = mid + 1;
            } else if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private static int lastOccurrence(int[] arr, int low, int high, int x) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == x) {
            if (mid == arr.length - 1 && arr[mid + 1] != x)
                return mid;
            else
                return lastOccurrence(arr, mid + 1, high, x);
        } else if (arr[mid] > x) return lastOccurrence(arr, low, mid - 1, x);
        else return lastOccurrence(arr, mid + 1, high, x);
    }
}
