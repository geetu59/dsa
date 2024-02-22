package stack;
/*Same as that of previous greatest, just that condition will be reversed. You'll pop when peek >arr[i] as you need min value elements in stack*/

import java.util.Stack;

public class PreviousSmallest {
    public static void main(String[] args) {
        int arr[] = {6, 2, 5, 4, 1, 5, 6};

        int result[] = previousSmallest(arr);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == -1)
                System.out.println("-1");
            else
                System.out.println(arr[result[i]]);
        }
    }

    public static int[] previousSmallest(int[] arr) {
        int[] prev = new int[arr.length]; //to store output
        Stack<Integer> stack = new Stack<>(); //to store prev minimums
        prev[0] = -1; // -1 when no min present
        //We should ideally push elements but since we require index in Largest Rect ARea problem and will be using same code there and hence index
        stack.push(0); //storing indexes, we can even directly push elements.
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) //as we want small value elements only in stack
                stack.pop();
            int index = stack.isEmpty() ? -1 : stack.peek(); //-1 as no element smaller than ith is found else whatever index at peek is there, that's smallest
            prev[i] = index;
            stack.push(i);
        }
        return prev;
    }
}
