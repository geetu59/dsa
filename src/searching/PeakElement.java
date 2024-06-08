package searching;

/*Find peak element in an array. It is the one which is greater or equal to it's neighbouring elements. For leftmost and rightmost elements,
check the element after and before it respectively.
* Naive sol: O(N) time and O(1) space.
 Efficient sol: Based on binary search. We are applying binary search on an unsorted array, We find the mid, and if it  is greater than leftmost and
 rightmost, we return it and also check for leftmost and rightmost element, so if mid is 0 then check arr[0]>=arr[mid+1], similarly, if mid is n-1
 check arr[mid-1]>arr[mid], this check is covered.
 After checking for 0th, n-1th, mid being greater, now if that is not the case, then check if left or right element is greater than mid, whichever is
 greater, we consider that part of array as we are sure peak would be present in that part of array, it might be present in other part, but it'll
 definitely be there in that part of array. Consider different combinations of the array to understand more, {65, 45, 40, 30, 20, 70, 60} or
 {5, 20, 40, 30, 20, 50, 60} or {5, 20, 40, 30, 20, 70, 60} for dry run, check gfg video */
public class PeakElement {
    public static void main(String[] args) {
        int arr[] = {65, 45, 40, 30, 20, 70, 60};
        //Naive
        System.out.println(peak(arr));
        //Efficient
        System.out.println(findPeak(arr));
    }

    private static int findPeak(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
                return arr[mid];
            }
            if (mid!=0 && arr[mid - 1] >= arr[mid])
                high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private static int peak(int[] arr) {
        int n = arr.length;
        //if size is 1, then that element itself is peak element
        if (n == 1) return arr[0];
        //for leftmost i.e. first element, check with the element on it's right only and hence we segregated the check
        if (arr[0] >= arr[1]) return arr[0];
        //for rightmost i.e. last element, check with the element on it's left only and hence we segregated the check
        if (arr[n - 1] >= arr[n - 2]) return arr[n - 1];
        //for middle element, just check if it is greater than it's neighbouring elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                return arr[i];
        }
        return -1; //this will never be returned as there will always be a peak element. Eg: {10,30,20}, hardly matters whatever be the arrangement, but
        //there will be peak element. 30 is peak, if it is {10,20,30}, then last element i.e. 30 will be peak
    }
}
