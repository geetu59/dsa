package array;

import java.util.Arrays;

/*Remove duplicates from sorted array and return size. Hardly matters if other elements are present, just bring distinct elements to beginning and return their size
 * Naive sol: theta(N)+O(N)-> O(N) time and space. Create a temporary array and store distinct elements there
 * Efficient sol: Do everything in same array. O(N) time and O(1) space*/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
        System.out.println(removeDuplicates(arr));
        System.out.println(removeDups(new int[]{1, 2, 2, 3, 4, 5, 6, 6, 6}));
    }

    private static int removeDups(int[] arr) {
        int result = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[result - 1] != arr[i]) {
                arr[result] = arr[i];
                result++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return result;
    }

    private static int removeDuplicates(int[] arr) {
        int[] temp = new int[arr.length]; //ade it of arr.length size becaz worst case can be that all elements were distinct
        temp[0] = arr[0]; //there'd be first element which will be distinct, just one element it is
        int result = 1; //since 1 element is already present in temp, hence increment the size
        for (int i = 1; i < arr.length; i++) {
            if (temp[result - 1] != arr[i]) {
                temp[result] = arr[i];
                result++;
            }
        }
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < result; i++) {
            arr[i] = temp[i];
        }
        return result;
    }
}
