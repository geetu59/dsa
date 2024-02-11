package linkedlist.singlell;

import static linkedlist.singlell.Delete.printList;

/*sort a linked list of 0s, 1s and 2s in O(N) time and space */
public class Segregate012 {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(0);
        Node node5 = new Node(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = segregate(head);
        printList(head);
    }

    static Node segregate(Node head) {
        Node curr = head;
        Node h1 = null, h2 = null, h3 = null, t1 = null, t2 = null, t3 = null;
        while (curr != null) {
            if (curr.data == 0) {
                Node temp = new Node(0);
                if (h1 == null)
                    t1 = temp;
                temp.next = h1;
                h1 = temp;
            } else if (curr.data == 1) {
                Node temp = new Node(1);
                if (h2 == null)
                    t2 = temp;
                temp.next = h2;
                h2 = temp;
            } else {
                Node temp = new Node(2);
                if (h3 == null)
                    t3 = temp;
                temp.next = h3;
                h3 = temp;
            }
            curr = curr.next;
        }
        if (t1 != null) {
            if (h2 != null) t1.next = h2;
            else t1.next = h3;
        }
        if (t2 != null) t2.next = h3;
        return h1 != null ? h1 : h2 != null ? h2 : h3;
    }
}
