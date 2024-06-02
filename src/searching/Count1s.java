package searching;

/*Count 1s in sorted non-increasing binary array.
 * Time: logn
 * It is same as getting last occurrence. Since, array is sorted in decreasing order and contains 0s and 1s only, so if we find last occurrence of 1
 * We can do mid+1(as index start from 0) and get the result. 1,1,1,0,0,0 then last occurrence is 2+1=3*/
public class Count1s {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        System.out.println(count1s(arr));
    }

    private static int count1s(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //that means for one, you surely have to go to left part of array
            if (arr[mid] == 0)
                high = mid - 1;
            else { //else can be that arr[mid]==1, 1 can be to right and left of it also but we are interested to check it's right as we want last occurrence
                if (mid == arr.length - 1 || arr[mid + 1] != 1)
                    return mid + 1;
                else low = mid + 1;
            }
        }
        return 0;
    }
}
