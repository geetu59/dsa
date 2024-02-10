package linkedlist.singlell;

import static linkedlist.singlell.Delete.printList;

/* Swap pairwise in ll
 * Sol 1: Naive sol, change data, not a recommended sol as if data is very big and not int, not suited
 * SOl 2: Change nodes O(n) time and O(1) space for both sol
 * */
public class PairwiseSwap {
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

        //Sol 1
        Node node = pairWiseSwap(head);
        printList(node);

        //SOl 2
        System.out.println();
        Node node1 = pairSwap(head);
        printList(node1);
    }

    private static Node pairSwap(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.next != null) {
            Node temp = curr.next;
            if (prev != null) prev.next = temp;
            else head=temp;
            curr.next = curr.next.next;
            temp.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    private static Node pairWiseSwap(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
        return head;
    }
}
