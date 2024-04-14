package array;

import java.util.ArrayList;
import java.util.Arrays;

/*1. Reverse array, we will use 2 pointer approach.
 * we will start 2 pointers one from left and other from right and reverse the elements at those positions.
 * Time: theta(n) becaz we will traverse array n/2 times
 * Space: theta(1) as using some constants only
 * 2. Reverse array in group*/
public class Reverse {
    public static void main(String[] args) {
        int arr[] = {30, 7, 6, 5, 10};
        reverse(arr);
        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> integers = new ArrayList<>(5);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        reverseInGroups(integers, 5, 3);
        reverseInGroups(integers, 5, 77);
    }

    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int left = 0, right = Math.min(n - 1, (left + k - 1));
        while (left < right) {
            reverse(arr, left, right);
            left += k;
            right = Math.min(n - 1, (left + k - 1));
        }
    }

    static void reverse(ArrayList<Integer> arr, int left, int right) {
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
        System.out.println(arr.toString());
    }
}