package searching.unbounded;

/*You are given an infinite array, search for element, if found, return index else -1. Infinite array can be created by
making an array of size millions and usually the element to be searched is present in left part of array only.
* Naive sol: Time: O(position) position is the position at which element is present Space: O(1)
* loop in and check arr[i], if it is equal to x, return index or if arr[i] becomes greater than x, that means x was not
* even present, so return -1
* Efficient sol: Time: O(log(position)) Space: O(1)
Use binary search but for that we need to know the value of high, which we cannot define, so we will use it in different way.
Multiply i by 2 everytime until arr[i]<x, since x is greater, we will multiply i by 2 until x becomes less, now let's check if
arr[i]==x, return x else call for binary search*/
public class SearchInInfiniteArray {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
        //Naive
        System.out.println(search(arr, 6));
        //Efficient
        System.out.println(searchInInfiniteArray(arr, 6));
    }

    private static int searchInInfiniteArray(int[] arr, int x) {
        //we need to handle index 0 separately becaz, if we start from 0 to multiply by 2, it'll not work and hence we start from 1
        if (arr[0] == x) return 0;
        int i = 1;
        //if x is greater then means it is at right, so we multiply i by 2 everytime, until we find equal or lesser
        while (arr[i] < x) {
            i = i * 2;
        }
        //if it is equal then return index
        if (arr[i] == x) return i;
        //if it is lesser, that means you have to perform binary search at some part of array, for that, high  would be i-1
        //becaz equality check we already did and for low, since we did i*2,  so  low wouldbe i/2+1, coz till i/2 we already
        // checked if it is = or less than x
        return binarySearch(arr, x, i / 2 + 1, i - 1);
    }

    private static int binarySearch(int[] arr, int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private static int search(int[] arr, int x) {
        int i = 0;
        while (true) {
            if (arr[i] == x) return i;
            if (arr[i] > x) return -1;
            i++;
        }
    }

}
