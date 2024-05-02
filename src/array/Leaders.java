package array;

import java.util.ArrayList;
import java.util.Collections;


/*Find leaders in an array. An element is said to be leader if elements on the right of it are less than that element.
 * Naive: O(N*N) time and O(1) space. Nest for loops, for ith, check all elements above ith and if you find greater then break
 * Efficient: theta(N) time and theta(n) space if you want to store the result in array as we get list of leaders in reverse order. So, if
 * you print it, it is O(1), if you  store it in array and reverse it and then print, it is theta(n) */
public class Leaders {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 10, 3, 6, 5, 2};
        //int arr[]={7,8,9};
        //int[] arr = {7, 6, 5};
        //naive
        printLeaders(arr);
        //efficient
        leaders(arr);
    }

    /*idea behind this approach is, we will start from right side of array and since last element will always be leader, we will print it and
     * then check if arr[i]>current leader becaz current leader will be greatest only, that's why it is leader and if arr[i] is even greater than
     * current leader that means it's also deserved to be leader, since we traverse from right to left and hence it will print in opposite order,
     * so we will store result in an array and reverse it*/
    private static void leaders(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int curr_leader = arr[arr.length - 1];
        result.add(arr[arr.length - 1]); //last element will always be leader as there is nothing on the right of it
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > curr_leader) {
                result.add(arr[i]);
                curr_leader = arr[i];
            }
        }
        Collections.reverse(result);
        System.out.println(result);
    }

    private static void printLeaders(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    break;
                }
            }
            if (j == arr.length)
                System.out.println(arr[i]);
        }
    }
}
