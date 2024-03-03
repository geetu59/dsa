package queue;

import java.util.LinkedList;
import java.util.Queue;

/*Implement stack using queue.
 * To implement this we have 4 approaches:
 * 1. Implement stack using 2 queues by making push operation costly i.e. O(N), other being O(1)
 * 2. by making pop() operation costly i.e. O(N), other being O(1)
 * 3. By using 1 queue, iteratively O(N) push
 * 4. by using 1 queue, recursively O(N) push*/
public class StackUsingQueue {
    //q1 will be actual queue and q2 will be auxiliary queue
    static Queue<Integer> q2;
    static Queue<Integer> q1;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public static void main(String[] args) {
        StackUsingQueue queue = new StackUsingQueue();
        /*Approach 1: Idea behind this is, store elements in such a way in queue such that popping is q.front, top is q.front.
         * In short, elements in queue should be in stack way, reversed*/
        System.out.println("Approach 1:");
        push1(10);
        push1(20);
        push1(30);
        System.out.println(pop1());
        System.out.println(q1.size());
        System.out.println(q1.isEmpty());
        System.out.println(top1());
        System.out.println(q1);

        /*Use only 1 queue and recursion*/
        System.out.println("Approach 3:");
        push3(70, q1.size());
        push3(80, q1.size());
        push3(90, q1.size());
        System.out.println(q1);
        System.out.println(pop1());
        System.out.println(q1.size());
        System.out.println(q1.isEmpty());
        System.out.println(top1());

        /*Use only 1 queue and do iteratively*/
        System.out.println("Approach 4:");
        System.out.println(q1);
        push4(100);
        push4(110);
        push4(120);
        System.out.println(q1);
        System.out.println(pop1());
        System.out.println(q1.size());
        System.out.println(q1.isEmpty());
        System.out.println(top1());
        System.out.println(q1);

        /*Approach 2: Idea behind this is, elements will be stored normally in queue but while pop, you have to pop rear one and queue's pop provides you front.
        Remove elements from q1 and put in q2 except last one, remove it and then store q2 elements */
        System.out.println("Approach 2:");
        push2(40);
        push2(50);
        push2(60);
        System.out.println(q1);
        System.out.println(pop2());
        System.out.println(q1.size());
        System.out.println(q1.isEmpty());
        System.out.println(top2());
        System.out.println(q1);
    }

    private static void push1(int x) {
        //q1: 2 1 Add item 3 to q2
        q2.add(x); //q2:3
        //Remove all elements from q1 and add to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        } //q2: 3 2 1, swap q1 and q2 as q2 contains the list we want
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        //otherwise, you can move all items from q1 to q2, add(x) to q1 and then move elements back to q1
    }

    private static int top1() {
        return q1.isEmpty() ? -1 : q1.peek();
    }

    private static int pop1() {
        return q1.isEmpty() ? -1 : q1.remove(); //peek will contain front, which is top of stack
    }

    private static void push2(int x) {
        q1.add(x);
    }

    private static int pop2() {
        if (q1.isEmpty()) return -1;
        while (q1.size() != 1) //remove elements until last element is left
            q2.add(q1.remove());
        int x = q1.remove(); //remove it and return becaz that would be top of stack
        Queue<Integer> q = q2; //q2 contains actual answer so, swap the queues
        q2 = q1;
        q1 = q;
        return x;
    }

    private static int top2() {
        if (q1.isEmpty()) return -1;
        while (q1.size() != 1)
            q2.add(q1.remove());
        int x = q1.peek();
        Queue<Integer> q = q2;
        q2 = q1;
        q1 = q;
        return x;
    }

    private static void push3(int x, int size) {
        //add element and size is current size of queue, q:10, 20, size=2, x=30, q1: 20 10 30
        q1.add(x);
        if (size <= 0) return;
        size--;
        //remove each element size times and add it back to queue q1: 30 20 10
        push3(q1.remove(), size);
    }

    //same as that of push3, just using loop
    private static void push4(int x) {
        q1.add(x);
        for (int i = 0; i < q1.size() - 1; i++) {
            q1.add(q1.remove());
        }
    }
}
