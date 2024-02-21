package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*Find the upcoming nearest greatest element
 * Sol 1: Naive sol O(N*N) time O(1) space
 * Sol 2: Similar to stock span/ previous greatest O(N)*/
public class NextGreatest {
    public static void main(String[] args) {
        int arr[] = {5, 15, 10, 8, 70, 12, 9, 18};

        System.out.println("Naive sol: ");
        nextGreatest(arr);

        System.out.println("Efficient sol: ");
        nextGreat(arr);
    }

    private static void nextGreat(int[] arr) {
        //since this will give us output in reverse order, so we will store output in array and then print it in reverse order
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        ans.add(-1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            int greatest = stack.isEmpty() ? -1 : stack.peek();
            ans.add(greatest);
            stack.push(arr[i]);
        }
        Collections.reverse(ans);
        System.out.println(ans);
    }

    private static void nextGreatest(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    System.out.println(arr[j]);
                    break;
                }
            }
            if (j == arr.length) System.out.println("-1"); //for last element, it'll always be -1 but for any element
            // which comes in middle and on right of it, there's no element greater than it, it'll be -1
        }
    }
}
