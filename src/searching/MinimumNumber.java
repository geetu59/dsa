package searching;
/*Given an array of distinct elements which was initially sorted. This array may be rotated at some unknown point.
The task is to find the minimum element in the given sorted and rotated array.
Example 1:
Input:
N = 10
arr[] = {2,3,4,5,6,7,8,9,10,1}
Output: 1
Explanation: The array is rotated once anti-clockwise. So minimum element is at last index (n-1) which is 1.
Time and space: O(logn)*/
public class MinimumNumber {
    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        System.out.println(minNumber(arr, 0, 4));
    }
    static int minNumber(int arr[], int low, int high) {
        while (low <= high) {
            if (arr[low] <= arr[high]) return arr[low]; //means array is sorted
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid + 1]) return arr[mid + 1];
            else if (arr[mid] < arr[mid - 1]) return arr[mid];
            else if (arr[mid] > arr[high]) low = mid + 1;
            else if (arr[mid] < arr[low]) high = mid - 1;
        }
        return -1;
        /*while(low<=high){
           int mid=(low+high)/2;
           if(low==high || (  (mid==0 || arr[mid-1]>=arr[mid]) && arr[mid+1]>=arr[mid]))
           return arr[mid];
           if(arr[high]>arr[mid] )
            high=mid-1;
            else
            low=mid+1;
       }
       return -1;*/
    }

}
