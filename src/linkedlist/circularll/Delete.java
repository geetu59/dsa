package linkedlist.circularll;

import linkedlist.singlell.Node;

public class Delete {
    static Node head;
    public static void main(String[] args) {
        head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node tail = new Node(5);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=tail;
        tail.next=head;

        System.out.println("Delete from kth position where k<=N");
        deleteAtPos(1);
        traverse();
        deleteAtPos(4);
        traverse();
        deleteAtPos(3);
        traverse();
    }

    private static void deleteAtPos(int pos) {
        if (pos == 1) {
            if (head == null || head.next == head)
                head = null;
            else {
                /*
                Node curr = head;
                while (curr.next != head)
                    curr = curr.next;
                curr.next = head.next;
                head = curr.next;*/
                /*O(1)*/
                head.data = head.next.data;
                head.next = head.next.next;
            }
        } else {
            Node curr = head;
            for (int i = 1; i < pos - 1; i++)
                curr = curr.next;
            curr.next = curr.next.next;
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
