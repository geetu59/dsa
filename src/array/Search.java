package array;

/*Search element in unsorted array in O(N) time and sorted array in O(log(N)) time using binary search*/
public class Search {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {3, 1, 7, 9, 4};
        System.out.println(sorted(arr1, 0, arr1.length - 1, 4));
        System.out.println(unsorted(arr2, 7));
    }

    private static int sorted(int[] arr1, int first, int last, int x) {
        while (first < last) {
            int mid = (first + last) / 2;
            if (x < arr1[mid])
                last = mid - 1;
            else if (x == arr1[mid])
                return mid;
            else
                first = mid + 1;
        }
        return -1;
    }

    private static int unsorted(int[] arr2, int x) {
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == x) return i;
        }
        return -1;
    }
}
