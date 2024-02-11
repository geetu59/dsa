package linkedlist.singlell;

import static linkedlist.singlell.Delete.printList;

/*Reverse in group of size k: Recursive theta(n) time and theta(n/k) space, iterative with O(n) time and O(1) space*/
public class ReverseInGroup {
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

        System.out.println("Reverse in group of k: Recursively");
        head = reverseInGroupk(head, 2);
        printList(head);

        System.out.println();
        System.out.println("Reverse in group of k: Iteratively");
        head = revInGroupk(head, 3);
        printList(head);
    }

    private static Node revInGroupk(Node head, int k) {
        Node curr = head;
        Node prevFirst = null;
        boolean firstPass = true;
        while (curr != null) {
            int count = 0;
            Node prev = null, first = curr;
            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (firstPass) {
                head = prev;
                firstPass = false;
            } else prevFirst.next = prev;
            prevFirst = first;
        }
        return head;
    }

    private static Node reverseInGroupk(Node head, int k) {
        //reverse ll code, just added count to reverse till k
        Node curr = head;
        Node prev = null, next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        //make a recursive call for rest of ll
        if (next != null) {
            Node rest_head = reverseInGroupk(next, k);
            head.next = rest_head;
        }
        return prev;
    }
}
