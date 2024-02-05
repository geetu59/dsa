package linkedlist.circularll;

import linkedlist.singlell.Node;

/*
 * Circular ll: Traverse: do while, while
 * Insert at begin, end: traverse O(N), O(1) optimised way
 * */
public class Insert {
    static Node head;

    public static void main(String[] args) {
        System.out.println("Traverse using while and O(N) insert");
        insertAtBegin(1);
        insertAtBegin(2);
        traversell();

        System.out.println("Traverse using do while and optimal insert");
        insertAtBeginOptimal(3);
        insertAtBeginOptimal(4);
        traverse();

        System.out.println("Insert at end: Naive");
        insertAtEnd(5);
        traverse();

        System.out.println("Insert at end: Optimal (N)");
        insertAtEndOptimal(6);
        traverse();
    }

    private static void insertAtEndOptimal(int x) {
        Node node = new Node(x);
        if (head == null) {
            node.next = node;
            head = node;
        } else {
            node.next = head.next;
            head.next = node;
            int temp = head.data;
            head.data = node.data;
            node.data = temp;
            head = node;
        }
    }

    private static void insertAtEnd(int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            head = temp;
        } else {
            Node curr = head;
            while (curr.next != head)
                curr = curr.next;
            curr.next = temp;
            temp.next = head;
        }
    }

    private static void insertAtBeginOptimal(int x) {
        Node node = new Node(x);
        if (head == null) {
            node.next = node;
            head = node;
        } else {
            node.next = head.next;
            head.next = node;
            int temp = head.data;
            head.data = node.data;
            node.data = temp;
        }
    }

    private static void insertAtBegin(int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
        } else {
            temp.next = head;
            Node curr = head;
            while (curr.next != head)
                curr = curr.next;
            curr.next = temp;
        }
        head = temp;
    }

    private static void traverse() {
        Node curr = head;
        System.out.println(curr.data);
        while (curr.next != head) {
            curr = curr.next;
            System.out.println(curr.data);
        }
    }

    private static void traversell() {
        Node curr = head;
        do {
            System.out.println(curr.data);
            curr = curr.next;
        } while (curr != head);
    }

}
