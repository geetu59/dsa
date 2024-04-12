package array;

import java.util.Arrays;
/*Delete first occurrence of an element: theta(n) as the whole array is traverse once, O(n)-> as del at last is possible in O(1)
* Get and update ith element: O(1)*/
public class Delete {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(delete(arr, 4));
        System.out.println(Arrays.toString(arr));
    }

    private static int delete(int[] arr, int x) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == x) break;
        }
        if (i == arr.length) return arr.length;
        for (int j = i; j < arr.length - 1; j++) {
            arr[j] = arr[j + 1];
        }
        return arr.length - 1;
    }
}
