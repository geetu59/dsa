package linkedlist.singlell;

import java.util.ArrayList;

/*
 * Reverse: 3 pointer, 2 pointer, recursively
 * */
public class Reverse {
    static Node head;

    public static void main(String[] args) {
        head = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("Naive sol: ");
        revList();
        printList();

        System.out.println("Two pointer: ");
        reverse();
        printList();

        System.out.println("Three pointer: ");
        reverseThreePointer();
        printList();

        //
        System.out.println("Recursive-1: ");
        reverseRecursively(head);
        printList();

        System.out.println("Recursive-2: ");
        revRecursively(head);
        printList();
    }

    private static void revRecursively(Node head) {
        rev(null, head);
    }

    //first part is already revered, on last node
    private static void rev(Node prev, Node curr) {
        if (curr == null) {
            head = prev;
            return;
        }
        Node temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        rev(prev, curr);
    }

    private static void revList() {
        Node curr = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (curr != null) {
            arrayList.add(curr.data);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            curr.data = arrayList.remove(arrayList.size() - 1);
            curr = curr.next;
        }
    }

    //last part is already reversed, left with head
    private static Node reverseRecursively(Node node) {
        if (node == null || node.next == null) {
            head = node;
            return node;
        }
            Node rest_head = reverseRecursively(node.next);
            Node rest_tail=node.next;
            rest_tail.next = node;
            node.next = null;

        return rest_head;
    }

    private static void reverseThreePointer() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    private static void reverse() {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            head = prev;
        }
    }

    private static void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
