package searching;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

/* Given 2 sorted arrays, merge them and return middle element, if number is even, then return average of two middle elements
 * Naive sol: Create new array temp, move all elements to it, sort it and then return middle if n is odd else calculate average of middle two elements.
 *  O(n1+n2) space and O((n1+n2)log(n1+n2)) time
 * Efficient sol 1: Use merge technique of sorting. O(n1+n2) time
 * Efficient sol 2: Use binary search. O(log(n)) time where n is the size smaller array*/
public class MedianOfMergedSortedArray {
    public static void main(String[] args) {
        int arr1[] = {10, 20, 30, 40, 50};
        int arr2[] = {5, 15, 25, 30, 35, 55, 65, 75, 85};
        //Naive
        System.out.println(median(arr1, arr2));
        //Efficient sol 2
        System.out.println(getMedian(arr1, arr2));
    }

    private static double getMedian(int[] arr1, int[] arr2) {
        //We apply binary search on smaller array and hence making sure that arr1 is smaller than arr2, if not then we reverse arr2 and arr1
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 > n2) return getMedian(arr2, arr1);

        int start = 0, end = n1;
        int realMid = (n1 + n2 + 1) / 2;
        while (start <= end) {
            //we have to make sure that elements on left and right are same i.e. both arrays are equally divided. i1 is giving us mid of first arr,
            //we are calculating i2 to get mid of second array. Also, i1 and i2 will be start point for right side of array
            int i1 = (start + end) / 2;
            int i2 = realMid - i1;

            /*For arr1, since we are interested in middle elements and we  divided array into 2 parts, so last element of left and first element
             * of right array is what we need, so to get last element of left, it'll be max element and i1 is pointing to first element on right,
             * i1-1th will be the max and if there's nothing on left, then assign min value as other value should always be the max in that case
             * For min1, it will be min element on right, which is first element only, hence ith pos na dif there's nothing on right, assign max value*/
            int min1 = (i1 < n1) ? arr1[i1] : Integer.MAX_VALUE;
            int max1 = (i1 > 0) ? arr1[i1 - 1] : Integer.MIN_VALUE;
            //same for arr2
            int min2 = (i2 < n2) ? arr2[i2] : Integer.MAX_VALUE;
            int max2 = (i2 > 0) ? arr2[i2 - 1] : Integer.MIN_VALUE;

            if (max1 <= min2 && max2 <= min1) {
                if ((n1 + n1) % 2 == 0) return (max(max1, max2) + min(min1, min2)) / 2.0;
                else return max(max1, max2);
            } else if (max2 > min1) {
                start = i1 + 1;
            } else end = i1 - 1;
        }
        return 0;
    }

    private static float median(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int temp[] = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            temp[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            temp[i + arr1.length] = arr2[i];
        }
        Arrays.sort(temp);
        if (n % 2 == 0)
            return (float) (temp[n / 2] + temp[n / 2 - 1]) / 2;
        else return (float) temp[n / 2] / 2;
    }
}
