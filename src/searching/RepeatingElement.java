package searching;

import java.util.Arrays;

/* Given an array having atleast 2 elements, 1. There is only 1 repeating element(any number of times) 2. All the elements from 0 to max(arr) are present
hence, 0 <= max(arr) <=n-2
 * Super Naive: O(N*N) time and O(1) space
 * Naive sol: O(NlogN) time and O(1) space by modifying existing array
 * Efficient 1: O(N) time, O(N) space with no modification in existing array
 Efficient 2: O(N) time, O(1) space, No modifications to original array
 Watch GFG videos in sorting for more understanding*/
public class RepeatingElement {
    public static void main(String[] args) {
        int arr[] = {0, 2, 1, 3, 2, 2};
        //Super Naive
        System.out.println(repeat(arr));
        //Naive
        System.out.println(repeatedElement(arr));
        //Efficient 1
        System.out.println(getRepeatedElement(arr));
        //Twist in the ques is, we've elements starting from 1, 1 <= max(arr) <=n-1
        int arr1[] = {4, 2, 1, 3, 2, 2};
        System.out.println(getRepeatElements(arr1));
        //Efficient 2 Same as above approach, just that we are adding 1 to all values and while return the value, we subtract 1
        //The reason of doing this is, if we have {0,1} then, since arr[0]=0, again it will come here and forms a self loop or {1,0}
        //then arr[0]=1, arr[1]=0, these 2 will form a loop, so to avoid these, we add 1 to all elements and then proceed and later while
        //returning element, we subtract 1
        System.out.println(getElement(arr));
    }

    private static int getElement(int[] arr) {
        int slow = arr[0] + 1, fast = arr[0] + 1;
        //maintain slow and fast pointer, which will point to the position where we've to go and slow will move one step and fast will move 2 steaps at a time
        //identify loop
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1];
        } while (slow != fast);

        //now move slow and fast, one step at a time to get first element in the loop
        slow = arr[0] + 1;
        while (slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }
        return slow - 1;
    }

    /*Traverse the array elements from left to right, form chain, we'll always have cycle. We will maintain slow and fast variables and create a chain.
    The approach we use is used in famous linkedlist problem of finding first node in the cycle.
    eg: a: 1,3,2,4,6,5,7,3 cycle will be: 1->3->4->6->7->3, 3 is the starting point of loop and hence the output.*/
    private static int getRepeatElements(int[] arr) {
        int slow = arr[0], fast = arr[0];
        //maintain slow and fast pointer, which will point to the position where we've to go and slow will move one step and fast will move 2 steaps at a time
        //identify loop
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        //now move slow and fast, one step at a time to get first element in the loop
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    private static int getRepeatedElement(int[] arr) {
        boolean[] visited = new boolean[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (visited[arr[i]]) return arr[i];
            visited[arr[i]] = true;
        }
        return -1;
    }

    private static int repeatedElement(int[] arr) {
        //sort the array, which will bring all repeating elements together
        Arrays.sort(arr);
        //check if any element matches then return
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return arr[i];
        }
        return -1;
    }

    private static int repeat(int[] arr) {
        //for each ith element, check rest of the elements, if you find the same element, then that is the repeating element and hence return
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    return arr[i];
            }
        }
        return -1;
    }
}
