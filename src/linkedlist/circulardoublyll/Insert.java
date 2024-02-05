package linkedlist.circulardoublyll;

import linkedlist.doublell.Node;

public class Insert {
    static Node head;
//3 2 1 4 5 6
    public static void main(String[] args) {
        insertInBegin(1);
        insertInBegin(2);
        insertInBegin(3);
        insertAtEnd(4);
        insertAtEnd(5);
        insertAtEnd(6);
        traverse();
    }

    private static void insertAtEnd(int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            head = temp;
        } else {
            temp.next = head;
            temp.prev = head.prev;
            head.prev.next = temp;
            head.prev = temp;
        }
    }

    private static void insertInBegin(int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            head = temp;
        } else {
            temp.next = head;
            temp.prev = head.prev;
            head.prev.next = temp;
            head.prev = temp;
            head = temp;
        }
    }

    private static void traverse() {
        Node curr = head;
        System.out.println(curr.data);
        while (curr.next != head) {
            curr = curr.next;
            System.out.println(curr.data);
        }
    }
}
