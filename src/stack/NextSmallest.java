package stack;

import java.util.Collections;
import java.util.Stack;

/*Same as that of next greatest, just that condition will be reversed
 * Logic is same as that of prev smallest if we consider it from end and then reverse it
*/
public class NextSmallest {
    public static void main(String[] args) {
        int arr[] = {6, 2, 5, 4, 1, 5, 6};

        int[] result = nextSmallest(arr);
        System.out.println("Indexes");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println("values");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == arr.length)
                System.out.println(arr.length);
            else
                System.out.println(arr[result[i]]);
        }
    }

    public static int[] nextSmallest(int[] arr) {
        int[] next = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);//if there's no smallest element, we will push length of arr, it'll contain indexes
        next[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            int index = stack.isEmpty() ? arr.length : stack.peek();
            next[i] = index;
            stack.push(i);
        }
        Collections.reverse(Collections.singletonList(next));
        return next;
    }
}
