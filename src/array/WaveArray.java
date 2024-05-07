package array;

import java.util.Arrays;

/*Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
O(N) time and O(1) space*/
public class WaveArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        convertToWave(5, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void convertToWave(int n, int[] a) {
        for (int i = 1; i < n; i += 2) {
            int temp = a[i];
            a[i] = a[i - 1];
            a[i - 1] = temp;
        }
    }
}
