package searching;

/*Search for the first occurrence of the element in sorted array
 * Sol 1: Traverse thru array and search for element, once you get it, return it's index. But this sol takes O(N) time
 * Sol 2: Use binary search, when arr[mid]==x, then check for element before it, if it is same, then consider that part of array i.e. change high to mid
 * Do this both recursively and iteratively and time is O(logn) T(N)=T(N/2)+k*/
public class FirstOccurrence {
    public static void main(String[] args) {
        int arr[] = {4,4,5, 7, 8};
        //recursive
        System.out.println(findFirstOccurrence(arr, 0, 4, 10));
        //iterative
        System.out.println(findFirstOcc(arr, 10));
    }

    static int findFirstOcc(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                if (mid > 0 && arr[mid - 1] == x)
                    high = mid - 1;
                else
                    return mid;
            } else if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private static int findFirstOccurrence(int[] arr, int low, int high, int x) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == x) {
            if (mid > 0 && arr[mid - 1] == x)
                return findFirstOccurrence(arr, low, mid - 1, x);
            return mid;
        } else if (arr[mid] > x) return findFirstOccurrence(arr, low, mid - 1, x);
        else return findFirstOccurrence(arr, mid + 1, high, x);
    }
}
