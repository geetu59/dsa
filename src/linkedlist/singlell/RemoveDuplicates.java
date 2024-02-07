package linkedlist.singlell;

import java.util.HashSet;

/*Remove duplicates present in ll: O(N) time, O(1) space sorted and unsorted*/
public class RemoveDuplicates {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(7);
        Node tail = new Node(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = tail;

        System.out.println();
        head = removeDuplicates(head);
        printList(head);

        Node head2 = new Node(5);
        Node node6 = new Node(2);
        Node node7 = new Node(2);
        Node node8 = new Node(4);
        Node node9 = new Node(3);
        Node node10 = new Node(7);
        Node tail2 = new Node(7);
        head2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = tail2;
        System.out.println("Unsorted list: ");
        head = removeDuplicatesUnsortedlist(head2);
        printList(head);
    }

    private static Node removeDuplicatesUnsortedlist(Node head) {
        /*if (head == null) return head;
        HashMap<Node, Integer> hashMap = new HashMap<>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (hashMap.containsValue(curr.data)) {
                prev.next = curr.next;
            } else {
                hashMap.put(curr, curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;*/
        if (head == null) return head;
        HashSet<Integer> set = new HashSet<>();
        Node curr = head;
        Node prev=null;
        while (curr != null) {
            //if it is able to add then it'll return true'
            if (set.add(curr.data)) {
                prev=curr;
            } else {
                prev.next=curr.next;
            }
            curr = curr.next;
        }
        return head;
    }

    private static Node removeDuplicates(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else
                curr = curr.next;
        }
        return head;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
