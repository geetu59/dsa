package array;

import java.util.Arrays;

/*Merge 2 sorted arrays of size m and n and put elements into third array of size m+n */
public class MergeSortedArray {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 6};
        int arr2[] = {2, 5, 7, 8};
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] arr3 = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                k++;
                i++;
            } else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < m) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }
        return arr3;
    }
}
