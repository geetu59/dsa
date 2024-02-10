package linkedlist.singlell;

import static linkedlist.singlell.Delete.printList;

//rotate a linked list in O(n) time and O(1) space by k nodes
public class Rotate {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = rotate(head, 2);
        printList(head);
    }

    private static Node rotate(Node head, int k) {
        Node curr = head;
        for (int i = 0; i < k - 1; i++)
            curr = curr.next;
        Node last = curr;
        for (int i = k - 1; last.next != null; k++)
            last = last.next;
        last.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }
}
