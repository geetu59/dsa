package array;

import static java.lang.Math.min;

/*Minimum adjacent difference in a circular array
* Given an array Arr of n integers arranged in a circular fashion. Your task is to find the minimum absolute difference between adjacent elements.
* n = 7 Arr[] = {8,-8,9,-9,10,-11,12} Output: 4 Explanation: The absolute difference between adjacent elements in the given array are as such: 16 17 18  19 21 23 4
(first and last). Among the calculated absolute difference the minimum is 4.*/
public class MinAdjDiff {
    public static void main(String[] args) {
        int arr[] = {1, 21, 5, 47, 71, 0, 36, 22, 64, 46, 18, 11, 73, 13, 57, 68, 8, 45, 99, 78, 3, 33, 17, 13, 30, 26};
        System.out.println(minDiff(arr));
    }

    private static int minDiff(int[] arr) {
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int curr = Math.abs(arr[i] - arr[i - 1]);
            diff = min(curr, diff);
        }
        return Math.min(Math.abs(arr[arr.length-1]-arr[0]), diff);
    }
}
