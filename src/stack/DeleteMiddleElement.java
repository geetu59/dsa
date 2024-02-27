package stack;

import java.util.ArrayDeque;

//Delete middle element of stack in O(N) time and space //1 2 3 4 5 then output should be 5 4 2 1 and if 1 2 3 4 then output should be 5 4 1
public class DeleteMiddleElement {
    public static void main(String[] args) {
        // Can use either Stack class or ArrayDeque, Stack class extends vector class which provides us thread safety,
        // since we dont wan that and hence to avoid overhead we use ArrayDeque when we have single threaded environment
        //Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        delMid(s, 5);
    }

    private static void delMid(ArrayDeque<Integer> s, int size) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int mid = (size + 1) / 2;
        if (size % 2 == 0) {
            for (int i = 1; i < mid + 1; i++) {
                stack.push(s.pop());
            }
            s.pop();
            while (!stack.isEmpty()) {
                s.push(stack.pop());
            }
        } else {
            for (int i = 1; i < mid; i++) {
                stack.push(s.pop());
            }
            s.pop();
            while (!stack.isEmpty()) {
                s.push(stack.pop());
            }
        }

        for (int i = 1; i < size; i++) {
            System.out.print(s.pop() + " ");
        }
    }
}
