package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*1. Reverse a queue. 2 approaches: Iteratively and recursively. O(N) time and space.
Iteratively: We will push items to stack and then put them back to queue, it'll reverse
Recursively: Let's say out q is {12 5 15 20}, we assumed that we reversed (n-1) elements and we've to reverse nth.
So we assure, we reversed: {12, 20 15 5}. For 12, we will remove it, push it at back after recursive call, Since we are
popping so base condition would be to check is q is empty
2. Reverse first k element of queue in O(N) time and O(k) space*/
public class ReverseQueue {
    static Queue<Integer> queue;

    public static void main(String[] args) {
        queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("Iteratively: ");
        reverseIterative();
        System.out.println(queue);

        System.out.println("Recursively");
        reverseRecursively(queue);
        System.out.println(queue);

        System.out.println("Reverse first k elements");
        reverseKElements(3);
        System.out.println(queue);
    }

    private static void reverseKElements(int k) {
        Stack<Integer> stack = new Stack<>();
        //push first k items in stack
        for (int i=0;i<k;i++){
            stack.push(queue.remove());
        }
        //push items in stack back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        //remove left over items in queue to be moved at back
        for (int i=0;i<queue.size()-k;i++)
            queue.add(queue.remove());
    }

    private static void reverseIterative() {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    private static void reverseRecursively(Queue<Integer> queue) {
        //base condition
        if (queue.isEmpty()) return;
        Integer x = queue.remove();
        reverseRecursively(queue);
        queue.add(x);
    }
}
