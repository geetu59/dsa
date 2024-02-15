package stack;

import linkedlist.singlell.Node;

import java.util.Stack;

//Implement stack using LinkedList in O(1) time
public class LinkedListStack {
    Node head;
    int size;

    public LinkedListStack() {
        this.head = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.size);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }

    void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop() {
        if (head == null) return Integer.MAX_VALUE;
        int x = head.data;
        head = head.next;
        size--;
        return x;
    }

    int size() {
        return size;
    }

    int peek() {
        return head == null ? Integer.MAX_VALUE : head.data;
    }

    boolean isEmpty() {
        return head == null;
    }
}
