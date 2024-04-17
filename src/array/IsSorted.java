package array;
/*Check if an array is sorted. O(1) space in both
* Naive sol: O(N*N), Come on ith element and check all element from (i+1)th position till end, if you find any element smaller than ith then it's unsorted
* Efficient sol: a[i]<a[i+1] in single traversal. If that's not the case, return false*/
public class IsSorted {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(isSortedNaive(arr));
        System.out.println(isSorted(arr));
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1]>arr[i]) return false;
        }
        return true;
    }

    private static boolean isSortedNaive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[i]) return false;
            }
        }
        return true;
    }
}
