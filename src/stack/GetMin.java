package stack;

import java.util.Stack;

//push the elements of the array into a stack and then print minimum in the stack at each pop until stack becomes empty.
//Eg: arr=[1,2,3,4,5] 1. push it into stack top-> 5,4,3,2,1 now pop such that you get min element
//pop 5-> 1, pop 4-> 1, pop 3-> 1, pop 2->1, pop 1->1
//O(N) time and space
public class GetMin {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        /*in order to fulfil the ask, if I push 1 in stack and then compare arr[i] with stack.peek() if its small push arr[i] else push peek()
         * on popping elements you'll get response*/
        getMin(arr);
    }

    private static void getMin(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < stack.peek())
                stack.push(arr[i]);
            else
                stack.push(stack.peek());
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
