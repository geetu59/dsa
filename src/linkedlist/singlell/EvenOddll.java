package linkedlist.singlell;

import static linkedlist.singlell.Delete.printList;
/*
* Segregate even and then odd nodes of ll
* SOl 1: 2 traversals, reach last node and then traverse again from front, if it's odd node, move it to end
* Sol 2: O(n) time O(1) space, by maintaing reference of odd start and end and even start and end
* */
public class EvenOddll {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        //Sol: 1
        head = segregateEvenOdd(head);
        printList(head);

        //Sol 2:
        System.out.println();
        head = segregate(head);
        printList(head);
    }

    private static Node segregate(Node head) {
        //odd start and end, even start and end make it null
        Node os = null, oe = null, es = null, ee = null;
        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (es == null) es = ee = curr;
                else {
                    ee.next = curr;
                    ee = curr;
                }
            } else {
                if (os == null) os = oe = curr;
                else {
                    oe.next = curr;
                    oe = curr;
                }
            }
            curr = curr.next;
        }
        if (os == null || es == null)
            return head;
        ee.next = os; //join even and odd
        oe.next = null; //last of odd should point to null as it must be pting so some other node
        return es;
    }

    private static Node segregateEvenOdd(Node head) {
        Node end = head;
        Node curr = head;
        Node prev = null;
        Node newHead = null;
        //to identify first even node to update head
        int flag = 1;
        //get last node
        while (end.next != null)
            end = end.next;
        //traverse from each node, if it's odd, move it to end and update end
        do {
            if (curr.data % 2 != 0) {
                end.next = curr;
                Node next = curr.next;
                curr.next = null;
                end = curr;
                curr = next;
            } else {
                if (flag == 1) {
                    newHead = curr;
                    flag = 0;
                }
                if (prev != null) prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        } while (curr != null && curr != head);
        if (prev != null) prev.next = curr;
        return newHead == null ? head : newHead;
    }
}
