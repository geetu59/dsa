package queue;

import java.util.Stack;

/*Implement queue using stack.
 * To implement this we have 4 approaches:
 * 1. Implement queue using 2 stack by making push operation costly i.e. O(N), other being O(1)
 * 2. by making pop() operation costly i.e. O(N), other being O(1)
 * 3. By using 1 stack, iteratively O(N) push
 * 4. by using 1 stack, recursively O(N) push*/
public class QueueUsingStack {
    //s1 will be actual stack and s2 will be auxiliary stack
    static Stack<Integer> s1;
    static Stack<Integer> s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        /*Approach 1: Store elements such that enqueue is costly. Elements will be stored the way it is stored in queue. Dequeue=stack.pop()*/
        System.out.println("Approach 1:");
        queue.enqueue1(10);
        queue.enqueue1(20);
        queue.enqueue1(30);
        System.out.println(queue.dequeue1());
        System.out.println(queue.peek1());
        System.out.println(s1);

        /*Approach 3: Make dequeue costly but using 1 stack recursively*/
        System.out.println("Approach 3:");
        queue.enqueue2(70);
        queue.enqueue2(80);
        queue.enqueue2(90);
        System.out.println(queue.dequeue3(s1));
        System.out.println(s1);

        /*Approach 2: Store elements the way you store in stack but while popping, make sure to pop first element of stack,
        cant use top as it gives lastly pushed
        Better way is to push in stack 1 and pop from stack 2*/
        System.out.println("Approach 2:");
        queue.enqueue2(40);
        queue.enqueue2(50);
        queue.enqueue2(60);
        System.out.println(s1);
        System.out.println(queue.dequeue2());
        System.out.println(queue.peek2());
    }

    private int dequeue3(Stack s) {
        int res = 0;
        if (s.isEmpty()) return -1;
        else if (s.size() == 1) {
            return (int) s.pop();
        } else {
            int x = (int) s.pop();
            res = dequeue3(s);
            s.push(x);
        }
        return res;
    }

    private int peek2() {
        if (s1.isEmpty() && s2.isEmpty()) return -1;
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.peek();
        /*while (s1.size() != 1)
            s2.push(s1.pop());
        Integer pop = s1.peek();
        while (!s2.isEmpty())
            s1.push(s2.pop());
        return pop;*/
    }

    private int dequeue2() {
        /*while (s1.size() != 1)
            s2.push(s1.pop());
        Integer pop = s1.pop();
        while (!s2.isEmpty())
            s1.push(s2.pop());
        return pop;*/
        if (s1.isEmpty() && s2.isEmpty()) return -1;
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    private static void enqueue2(int x) {
        s1.push(x);
    }

    private static int peek1() {
        return s1.isEmpty() ? -1 : s1.peek();
    }

    private static int dequeue1() {
        return s1.isEmpty() ? -1 : s1.pop();
    }

    private static void enqueue1(int x) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }
}
